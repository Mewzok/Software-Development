import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.util.converter.BigDecimalStringConverter;

import java.math.BigDecimal;
import java.util.ArrayList;

public class InvoiceManager extends Application implements WindowCloseCallback {
    ArrayList<Invoice> invoices = new ArrayList<>();
    private Button addButton = new Button("Create New Invoice");

    private Label dispatchNetLabel = new Label();
    private BigDecimal dispatchNetAmount = new BigDecimal(0);
    private Label otbNetLabel = new Label();
    private BigDecimal otbNetAmount = new BigDecimal(0);
    private Label rkNetLabel = new Label();
    private BigDecimal rkNetAmount = new BigDecimal(0);

    private GridPane mainGrid = new GridPane();
    private InvoiceCreator IC = new InvoiceCreator(InvoiceManager.this);
    private Stage icStage = new Stage();
    private ContextMenu contextMenu = new ContextMenu();
    private Invoice selectedInvoice;
    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;

        // create main pane
        BorderPane mainBorderPane = new BorderPane();

        // create main grid
        mainGrid.setHgap(0);
        mainGrid.setVgap(0);

        // create scroll bar
        ScrollPane scrollPane = new ScrollPane(mainGrid);
        scrollPane.setFitToWidth(true);
        mainBorderPane.setCenter(scrollPane);

        // create context menu
        MenuItem editItem = new MenuItem("Edit");
        MenuItem deleteItem = new MenuItem("Delete");
        contextMenu.getItems().addAll(editItem, deleteItem);

        // place headers in first row, also determine size of each column
        placeHeadersInRow();

        invoices = InvoiceStorage.loadInvoices();
        InvoiceStorage.loadLogisticsFromFile(); // place logistics data in internal map

        loadInvoicesToGrid();

        addButtonsAndLabelsToPane(mainBorderPane);


        // handle events
        // add button event
        addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                // close the old window if it's open
                if(icStage.isShowing()) {
                    icStage.close();
                }

                // open invoice creator window
                IC = new InvoiceCreator(InvoiceManager.this);
                icStage = new Stage();
                icStage.setTitle("Invoice Creator");
                icStage.setScene(new Scene(IC));
                icStage.show();
            }
        });

        // edit context menu event
        editItem.setOnAction(editEvent -> {
            if(selectedInvoice != null) {
                // close the old window if it's open
                if(icStage.isShowing()) {
                    icStage.close();
                }

                // open invoice editor window
                IC = new InvoiceCreator(InvoiceManager.this, selectedInvoice);
                icStage = new Stage();
                icStage.setTitle("Invoice Editor");
                icStage.setScene(new Scene(IC));
                icStage.show();
            }
        });

        // delete context menu event
        deleteItem.setOnAction(deleteEvent -> {
            boolean invoiceFound = false;

            for(int i = 0; i < invoices.size(); i++) {
                if(invoices.get(i).getRkNumber().equals(selectedInvoice.getRkNumber())) {
                    invoiceFound = true;
                    invoices.remove(i);

                    // reset ui
                    InvoiceStorage.saveInvoices(invoices);
                    loadInvoicesToGrid();

                    break;
                }
            }

            // only runs if invoice not found
            if(!invoiceFound) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Invoice Not Found");
                alert.setHeaderText(null);
                alert.setContentText("Selected invoice could not be found.");

                alert.showAndWait();
            }
        });

        // set and place main window scene
        Scene scene = new Scene(mainBorderPane);
        primaryStage.setTitle("Invoice Manager");
        primaryStage.setScene(scene);
        primaryStage.setHeight(700);
        primaryStage.show();

        refreshSize();
    }

    // place headers in first row, also determine size of each column
    private void placeHeadersInRow() {
        // create header String array
        String[] headers = {
                "RK Number", "OTB Number", "Broker", "Shipper", "Receiver", "Gross", "Pickup Date", "Delivery Date",
                "Factor Cost", "Factor Date", "Factor Due", "Dispatch Cost",
                "OTB Cost", "Net"
        };

        // set header row
        for (int col = 0; col < headers.length; col++) {
            StackPane cell = new StackPane(new Label(headers[col]));
            cell.setStyle("-fx-border-color: black; -fx-padding: 5; -fx-background-color: lightgray;");
            mainGrid.add(cell, col, 0);

            // set grid size per cell
            ColumnConstraints columnConstraints = new ColumnConstraints();
            columnConstraints.setHgrow(Priority.ALWAYS);
            columnConstraints.setMaxWidth(Double.MAX_VALUE);
            mainGrid.getColumnConstraints().add(columnConstraints);
        }
    }

    private void addInvoiceToGrid(Invoice inv, int row) {
        // make invoice params into String array
        String[] invoiceData = {
                inv.getRkNumber(),
                inv.getOtbNumber(),
                inv.getBroker().getCompanyName(),
                inv.getShipper().getCompanyName(),
                inv.getReceiver().getCompanyName(),
                inv.getGross(),
                inv.getPickupDate(),
                inv.getDeliveryDate(),
                inv.getFactorCost(),
                inv.getFactorDate(),
                inv.getFactorDueDate(),
                inv.getDispatchPay(),
                inv.getOtbCost(),
                inv.getNet() };

        // set row data from invoice array
        for (int col = 0; col < invoiceData.length; col++) {
            StackPane cell = new StackPane(new Label(invoiceData[col]));
            cell.setStyle("-fx-border-color: black; -fx-padding: 5; -fx-background-color: white;");
            cell.setAlignment(Pos.CENTER);
            mainGrid.add(cell, col, row);

            // attach event listener for cell editing
            cell.setOnContextMenuRequested(e -> {
                selectedInvoice = inv; // store selected invoice
                contextMenu.show(cell, e.getScreenX(), e.getScreenY());
            });
        }
    }

    private void loadInvoicesToGrid() {
        // clear pane entirely
        mainGrid.getChildren().clear();
        dispatchNetAmount = new BigDecimal(0);
        otbNetAmount = new BigDecimal(0);
        rkNetAmount = new BigDecimal(0);

        // load header to grid
        placeHeadersInRow();

        // add all invoices to main grid
        int rowIndex = 1;
        for (Invoice invoice : invoices) {
            addInvoiceToGrid(invoice, rowIndex);
            rowIndex++;

            // add net totals
            dispatchNetAmount = dispatchNetAmount.add(DollarConverter.formatFromDollars(invoice.getDispatchPay()));

            if(!invoice.getOtbCost().equals("N/A")) {
                otbNetAmount = otbNetAmount.add(DollarConverter.formatFromDollars(invoice.getOtbCost()));
            }

            if(!invoice.getNet().equals("N/A")) {
                rkNetAmount = rkNetAmount.add(DollarConverter.formatFromDollars(invoice.getNet()));
            }
        }

        updateNets();
        refreshSize();
    }

    private void addButtonsAndLabelsToPane(BorderPane mBPane) {
        // customize label UI
        dispatchNetLabel.setStyle("-fx-border-color: #B0B0B0; -fx-border-width: 1px; -fx-border-radius: 5px; " +
                "-fx-padding: 5px; -fx-background-radius: 5px; " +
                "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.15), 5, 0, 2, 2);");

        otbNetLabel.setStyle("-fx-border-color: #B0B0B0; -fx-border-width: 1px; -fx-border-radius: 5px; " +
                "-fx-padding: 5px; -fx-background-radius: 5px; " +
                "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.15), 5, 0, 2, 2);");

        rkNetLabel.setStyle("-fx-border-color: #B0B0B0; -fx-border-width: 1px; -fx-border-radius: 5px; " +
                "-fx-padding: 5px; -fx-background-radius: 5px; " +
                "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.15), 5, 0, 2, 2);");

        // set up button and label layout for bottom pane
        HBox bottomHBox = new HBox(8);
        HBox labelHBox = new HBox(8);

        labelHBox.getChildren().addAll(dispatchNetLabel, otbNetLabel, rkNetLabel);

        labelHBox.setAlignment(Pos.CENTER_RIGHT);
        bottomHBox.setAlignment(Pos.CENTER);

        Region spacer = new Region(); // spacer to force button in the middle, labels on the right
        spacer.setMinWidth(primaryStage.getWidth());

        HBox.setHgrow(labelHBox, Priority.ALWAYS);

        bottomHBox.getChildren().addAll(addButton, labelHBox);

        mBPane.setBottom(bottomHBox);
    }

    private void refreshSize() {
        primaryStage.close();
        primaryStage.show();
    }

    private void updateNets() {
        dispatchNetLabel.setText("Dispatcher Total Pay: " + DollarConverter.formatToDollars(dispatchNetAmount));
        otbNetLabel.setText("OTB Total Pay: " + DollarConverter.formatToDollars(otbNetAmount));
        rkNetLabel.setText("Net Pay: " + DollarConverter.formatToDollars(rkNetAmount));
    }

    @Override
    public void onCloseWindow() {
        Invoice newInvoice = IC.getInvoice();
        Broker broker = newInvoice.getBroker();
        Broker existingBroker = InvoiceStorage.getBroker(broker.getCompanyName());
        Shipper shipper = newInvoice.getShipper();
        Shipper existingShipper = InvoiceStorage.getShipper(shipper.getCompanyName());
        Receiver receiver = newInvoice.getReceiver();
        Receiver existingReceiver = InvoiceStorage.getReceiver(shipper.getCompanyName());

         //save broker if new
        if (existingBroker == null || !existingBroker.equals(broker)) {
            InvoiceStorage.saveLogistic(broker);
        }

        if(existingShipper == null || !existingShipper.equals(shipper)) {
            InvoiceStorage.saveLogistic(shipper);
        }

        if(existingReceiver == null || !existingReceiver.equals(receiver)) {
            InvoiceStorage.saveLogistic(receiver);
        }

        // update existing invoice
        boolean invoiceExists = false;
        for(int i = 0; i < invoices.size(); i++) {
            if(invoices.get(i).getRkNumber().equals(newInvoice.getRkNumber())) {
                invoices.set(i, newInvoice);
                invoiceExists = true;
                break;
            }
        }

        // add new invoice if it doesn't exist already
        if(!invoiceExists) {
            invoices.add(newInvoice);
        }

        // save new or updated invoice
        InvoiceStorage.saveInvoices(invoices);
        icStage.close();

        // refresh grid
        loadInvoicesToGrid();
    }

    public static void main(String[] args) throws Exception {
        Application.launch(args);
    }
}

interface WindowCloseCallback {
    void onCloseWindow();
}
