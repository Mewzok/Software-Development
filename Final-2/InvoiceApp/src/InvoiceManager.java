import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.ArrayList;

public class InvoiceManager extends Application implements WindowCloseCallback {
    ArrayList<Invoice> invoices = new ArrayList<>();
    private Button addButton = new Button("Add");
    private Button editButton = new Button("Edit");
    private Button removeButton = new Button("Delete");
    private GridPane mainGrid = new GridPane();
    private InvoiceCreator IC = new InvoiceCreator(InvoiceManager.this);
    private Stage icStage = new Stage();
    private ContextMenu contextMenu = new ContextMenu();
    private Invoice selectedInvoice;

    @Override
    public void start(Stage primaryStage) {
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

        loadInvoicesToGrid();

        addButtonsToPane(mainBorderPane);


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
                InvoiceCreator editIC = new InvoiceCreator(InvoiceManager.this, selectedInvoice);
                icStage.setTitle("Invoice Editor");
                icStage.setScene(new Scene(editIC));
                icStage.show();
            }
        });

        // set and place main window scene
        Scene scene = new Scene(mainBorderPane);
        primaryStage.setTitle("Invoice Manager");
        primaryStage.setScene(scene);
        primaryStage.setHeight(700);
        primaryStage.show();
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
                inv.getGross().toString(),
                inv.getPickupDate(),
                inv.getDeliveryDate(),
                inv.getFactorCost().toString(),
                inv.getFactorDate(),
                inv.getFactorDueDate(),
                inv.getDispatchCost().toString(),
                inv.getOtbCost().toString(),
                inv.getNet().toString() };

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

            // set grid size per cell
            ColumnConstraints columnConstraints = new ColumnConstraints();
            columnConstraints.setHgrow(Priority.ALWAYS);
            mainGrid.getColumnConstraints().add(columnConstraints);
        }
    }

    private void loadInvoicesToGrid() {
        // declare variables
        int rowIndex = 1;

        // add all invoices to main grid
        for (Invoice invoice : invoices) {
            addInvoiceToGrid(invoice, rowIndex);
            rowIndex++;
        }
    }

    private void addButtonsToPane(BorderPane mBPane) {
        // place buttons in pane
        HBox buttonHBox = new HBox(8);

        buttonHBox.getChildren().addAll(addButton, editButton, removeButton);

        buttonHBox.setAlignment(Pos.CENTER);
        mBPane.setBottom(buttonHBox);
    }

    @Override
    public void onCloseWindow() {
        Invoice newInvoice = IC.getInvoice();

        boolean invoiceExists = false;

        // update existing invoice
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
