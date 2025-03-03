import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

public class InvoiceManager extends Application implements WindowCloseCallback {
    ArrayList<Invoice> invoices = new ArrayList<>();
    private Button addButton = new Button("Add");
    private Button editButton = new Button("Edit");
    private Button removeButton = new Button("Delete");
    private GridPane mainGrid = new GridPane();
    private InvoiceCreator IC = new InvoiceCreator(InvoiceManager.this);
    private Stage icStage = new Stage();

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

        // place headers in first row, also determine size of each column
        placeHeadersInRow();

        invoices = InvoiceStorage.loadInvoices();

        loadInvoicesToGrid();

        manageButtons(mainBorderPane);

        // delete
        //mainBorderPane.setCenter(mainGrid);

        // handle button events
        // add event
        addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                icStage.setTitle("Invoice Creator");
                icStage.setScene(new Scene(IC));
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

    private void manageButtons(BorderPane mBPane) {
        // place buttons in pane
        HBox buttonHBox = new HBox(8);

        buttonHBox.getChildren().addAll(addButton, editButton, removeButton);

        buttonHBox.setAlignment(Pos.CENTER);
        mBPane.setBottom(buttonHBox);
    }

    @Override
    public void onCloseWindow() {
        Invoice newInvoice = IC.getInvoice();

        System.out.println(newInvoice.isValidInvoice());
        System.out.println(newInvoice.getDispatchCost());

        invoices.add(newInvoice);

        InvoiceStorage.saveInvoices(invoices);
        icStage.close();

        loadInvoicesToGrid();
    }

    public static void main(String[] args) throws Exception {
        Application.launch(args);
    }
}

interface WindowCloseCallback {
    void onCloseWindow();
}
