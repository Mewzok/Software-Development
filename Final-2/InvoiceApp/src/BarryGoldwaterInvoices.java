import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

public class BarryGoldwaterInvoices extends Application {
    @Override
    public void start(Stage primaryStage) {
        // declare variables

        // create main grid
        GridPane mainGrid = new GridPane();
        mainGrid.setHgap(0);
        mainGrid.setVgap(0);

        // place headers in first row, also determine size of each column
        placeHeadersInRow(mainGrid);

        // example, delete
        // Invoice invoice = new Invoice("RK008-M", "N/A",
        // new Broker("Broker Name", "123 Main St", "5555555555", 11.4,
        // "fake@email.com", "brokerName",
        // "poNumber"),
        // new Shipper("Shipper Name", "123 Main St", "phonenumber", 81.5,
        // "delivery address", "pickupDateandTime",
        // 408.5, 4015791),
        // new Receiver("Receiver Name", "123 Main St", "phonenumber", 81.5,
        // "delivery address",
        // "pickupDateandTime", 408.5, 4015791),
        // new BigDecimal("1500.00"),
        // new Date(), new Date(), new BigDecimal("200.00"),
        // new Date(), new Date(), new BigDecimal("50.00"),
        // new BigDecimal("100.00"), new BigDecimal("1150.00"));

        ArrayList<Invoice> invoices = InvoiceStorage.loadInvoices();
        // invoices.add(invoice);
        // InvoiceStorage.saveInvoices(invoices);

        invoices.get(0).getBroker();

        // add all invoices to main grid
        for (Invoice invoiceT : invoices) {
            addInvoiceToGrid(mainGrid, invoiceT);
        }

        // set and place main window scene
        Scene scene = new Scene(mainGrid);
        primaryStage.setTitle("Failed Presidential Nominee Barry Goldwater's Invoices");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // place headers in first row, also determine size of each column
    private void placeHeadersInRow(GridPane mGrid) {
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
            mGrid.add(cell, col, 0);
        }
    }

    private void addInvoiceToGrid(GridPane mGrid, Invoice inv) {
        // make invoice params into String array
        String[] invoiceData = {
                inv.getRkNumber(),
                inv.getOtbNumber(),
                inv.getBroker().getCompanyName(),
                inv.getShipper().getCompanyName(),
                inv.getReceiver().getCompanyName(),
                inv.getGross().toString(),
                DateFormatter.formatDate(inv.getPickupDate()),
                DateFormatter.formatDate(inv.getDeliveryDate()),
                inv.getFactorCost().toString(),
                DateFormatter.formatDate(inv.getFactorDate()),
                DateFormatter.formatDate(inv.getFactorDueDate()),
                inv.getDispatchCost().toString(),
                inv.getOtbCost().toString(),
                inv.getNet().toString() };

        // set data row from invoice array
        double columnWidth = 100;
        for (int col = 0; col < invoiceData.length; col++) {
            StackPane cell = new StackPane(new Label(invoiceData[col]));
            cell.setStyle("-fx-border-color: black; -fx-padding: 5; -fx-background-color: white;");
            cell.setAlignment(Pos.CENTER);
            mGrid.add(cell, col, 1);

            if (columnWidth < cell.getWidth()) {
                columnWidth = cell.getWidth();
            }
            ColumnConstraints columnConstraints = new ColumnConstraints();
            columnConstraints.setMinWidth(columnWidth);
            columnConstraints.setPrefWidth(columnWidth);
            columnConstraints.setMaxWidth(Double.MAX_VALUE);
            mGrid.getColumnConstraints().add(columnConstraints);
        }
    }

    public static void main(String[] args) throws Exception {
        Application.launch(args);
    }
}
