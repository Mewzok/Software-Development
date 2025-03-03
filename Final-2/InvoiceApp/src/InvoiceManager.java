import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

public class InvoiceManager extends Application {
    private Button addButton = new Button("Add");
    private Button editButton = new Button("Edit");
    private Button removeButton = new Button("Delete");

    @Override
    public void start(Stage primaryStage) {
        // create main pane
        BorderPane mainBorderPane = new BorderPane();

        // create main grid
        GridPane mainGrid = new GridPane();
        mainGrid.setHgap(0);
        mainGrid.setVgap(0);

        // place headers in first row, also determine size of each column
        placeHeadersInRow(mainGrid);

        ArrayList<Invoice> invoices = InvoiceStorage.loadInvoices();

        // add all invoices to main grid
        for (Invoice invoiceT : invoices) {
            addInvoiceToGrid(mainGrid, invoiceT);
        }

        manageButtons(mainBorderPane);

        mainBorderPane.setCenter(mainGrid);

        // handle button events
        // add event
        addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                InvoiceCreator IC = new InvoiceCreator();

                Stage icStage = new Stage();
                icStage.setTitle("Invoice Creator");
                icStage.setScene(new Scene(IC));
                icStage.show();
            }
        });

        // set and place main window scene
        Scene scene = new Scene(mainBorderPane);
        primaryStage.setTitle("Invoice Manager");
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

        // set row data from invoice array
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

    private void manageButtons(BorderPane mBPane) {
        // place buttons in pane
        HBox buttonHBox = new HBox(8);

        buttonHBox.getChildren().addAll(addButton, editButton, removeButton);

        buttonHBox.setAlignment(Pos.CENTER);
        mBPane.setBottom(buttonHBox);
    }

    public static void main(String[] args) throws Exception {
        Application.launch(args);
    }
}
