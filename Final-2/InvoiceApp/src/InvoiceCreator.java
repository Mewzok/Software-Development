import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.*;

public class InvoiceCreator extends Pane {
    // declare variables
    private final Label rkNumberLabel = new Label("RK#: ");
    private final Label otbNumberLabel = new Label("OTB#: ");
    private final Label brokerCompanyNameLabel = new Label("Broker Company Name: ");
    private final Label brokerAddressLabel = new Label("Broker Address: ");
    private final Label brokerPhoneNumberLabel = new Label("Broker Phone Number: ");
    private final Label brokerReeferTemperatureLabel = new Label("Broker Reefer Temperature: ");
    private final Label brokerEmailLabel = new Label("Broker Email: ");
    private final Label brokerNameLabel = new Label("Broker Name: ");
    private final Label brokerPONumberLabel = new Label("Broker PO#: ");
    private final Label shipperCompanyNameLabel = new Label("Shipper Company Name: ");
    private final Label shipperAddressLabel = new Label("Shipper Address: ");
    private final Label shipperPhoneNumberLabel = new Label("Shipper Phone Number: ");
    private final Label shipperReeferTemperatureLabel = new Label("Shipper Reefer Temperature: ");
    private final Label shipperDeliveryAddressLabel = new Label("Shipper Delivery Address: ");
    private final Label shipperPickupDateTimeLabel = new Label("Shipper Pickup Date: ");
    private final Label shipperApproxWeightLabel = new Label("Shipper Approximate Weight: ");
    private final Label shipperConfirmationNumberLabel = new Label("Shipper Confirmation Number: ");
    private final Label receiverCompanyNameLabel = new Label("Receiver Company Name: ");
    private final Label receiverAddressLabel = new Label("Receiver Address: ");
    private final Label receiverPhoneNumberLabel = new Label("Receiver Phone Number: ");
    private final Label receiverReeferTemperatureLabel = new Label("Receiver Reefer Temperature: ");
    private final Label receiverDeliveryAddressLabel = new Label("Receiver Delivery Address: ");
    private final Label receiverPickupDateTimeLabel = new Label("Receiver Pickup Date: ");
    private final Label receiverApproxWeightLabel = new Label("Receiver Approximate Weight: ");
    private final Label receiverConfirmationNumberLabel = new Label("Receiver Confirmation Number: ");
    private final Label grossLabel = new Label("Gross: ");
    private final Label pickupDateLabel = new Label("Pickup Date: ");
    private final Label deliveryDateLabel = new Label("Delivery Date: ");
    private final Label factorCostLabel = new Label("Factor Cost: ");
    private final Label factorDateLabel = new Label("Factor Date: ");
    private final Label factorDueDateLabel = new Label("Factor Due Date: ");
    private final Label dispatchCostLabel = new Label("Dispatch Cost: ");
    private final Label otbCostLabel = new Label("OTB Cost: ");
    private final Label netLabel = new Label("Net: ");
    private TextField rkNumberTF = new TextField();
    private TextField otbNumberTF = new TextField();
    private TextField brokerCompanyNameTF = new TextField();
    private TextField brokerAddressTF = new TextField();
    private TextField brokerPhoneNumberTF = new TextField();
    private TextField brokerReeferTemperatureTF = new TextField();
    private TextField brokerEmailTF = new TextField();
    private TextField brokerNameTF = new TextField();
    private TextField brokerPONumberTF = new TextField();
    private TextField shipperCompanyNameTF = new TextField();
    private TextField shipperAddressTF = new TextField();
    private TextField shipperPhoneNumberTF = new TextField();
    private TextField shipperReeferTemperatureTF = new TextField();
    private TextField shipperDeliveryAddressTF = new TextField();
    private TextField shipperPickupDateTimeTF = new TextField();
    private TextField shipperApproxWeightTF = new TextField();
    private TextField shipperConfirmationNumberTF = new TextField();
    private TextField receiverCompanyNameTF = new TextField();
    private TextField receiverAddressTF = new TextField();
    private TextField receiverPhoneNumberTF = new TextField();
    private TextField receiverReeferTemperatureTF = new TextField();
    private TextField receiverDeliveryAddressTF = new TextField();
    private TextField receiverPickupDateTimeTF = new TextField();
    private TextField receiverApproxWeightTF = new TextField();
    private TextField receiverConfirmationNumberTF = new TextField();
    private TextField grossTF = new TextField();
    private TextField pickupDateTF = new TextField();
    private TextField deliveryDateTF = new TextField();
    private TextField factorCostTF = new TextField();
    private TextField factorDateTF = new TextField();
    private TextField factorDueDateTF = new TextField();
    private TextField dispatchCostTF = new TextField();
    private TextField otbCostTF = new TextField();
    private TextField netTF = new TextField();
    private Button confirmButton = new Button("Confirm");

    // create default InvoiceCreator window
    public InvoiceCreator() {
        createPane();
    }

    private void createPane() {
        // add labels to arraylist for easy iteration
        List<Label> labels = new ArrayList<>();
        labels.add(rkNumberLabel);
        labels.add(otbNumberLabel);
        labels.add(brokerCompanyNameLabel);
        labels.add(brokerAddressLabel);
        labels.add(brokerPhoneNumberLabel);
        labels.add(brokerReeferTemperatureLabel);
        labels.add(brokerEmailLabel);
        labels.add(brokerNameLabel);
        labels.add(brokerPONumberLabel);
        labels.add(shipperCompanyNameLabel);
        labels.add(shipperAddressLabel);
        labels.add(shipperPhoneNumberLabel);
        labels.add(shipperReeferTemperatureLabel);
        labels.add(shipperDeliveryAddressLabel);
        labels.add(shipperPickupDateTimeLabel);
        labels.add(shipperApproxWeightLabel);
        labels.add(shipperConfirmationNumberLabel);
        labels.add(receiverCompanyNameLabel);
        labels.add(receiverAddressLabel);
        labels.add(receiverPhoneNumberLabel);
        labels.add(receiverReeferTemperatureLabel);
        labels.add(receiverDeliveryAddressLabel);
        labels.add(receiverPickupDateTimeLabel);
        labels.add(receiverApproxWeightLabel);
        labels.add(receiverConfirmationNumberLabel);
        labels.add(grossLabel);
        labels.add(pickupDateLabel);
        labels.add(deliveryDateLabel);
        labels.add(factorCostLabel);
        labels.add(factorDateLabel);
        labels.add(factorDueDateLabel);
        labels.add(dispatchCostLabel);
        labels.add(otbCostLabel);
        labels.add(netLabel);

        // add text fields to arraylist for easy iteration
        List<TextField> textFields = new ArrayList<>();
        textFields.add(rkNumberTF);
        textFields.add(otbNumberTF);
        textFields.add(brokerCompanyNameTF);
        textFields.add(brokerAddressTF);
        textFields.add(brokerPhoneNumberTF);
        textFields.add(brokerReeferTemperatureTF);
        textFields.add(brokerEmailTF);
        textFields.add(brokerNameTF);
        textFields.add(brokerPONumberTF);
        textFields.add(shipperCompanyNameTF);
        textFields.add(shipperAddressTF);
        textFields.add(shipperPhoneNumberTF);
        textFields.add(shipperReeferTemperatureTF);
        textFields.add(shipperDeliveryAddressTF);
        textFields.add(shipperPickupDateTimeTF);
        textFields.add(shipperApproxWeightTF);
        textFields.add(shipperConfirmationNumberTF);
        textFields.add(receiverCompanyNameTF);
        textFields.add(receiverAddressTF);
        textFields.add(receiverPhoneNumberTF);
        textFields.add(receiverReeferTemperatureTF);
        textFields.add(receiverDeliveryAddressTF);
        textFields.add(receiverPickupDateTimeTF);
        textFields.add(receiverApproxWeightTF);
        textFields.add(receiverConfirmationNumberTF);
        textFields.add(grossTF);
        textFields.add(pickupDateTF);
        textFields.add(deliveryDateTF);
        textFields.add(factorCostTF);
        textFields.add(factorDateTF);
        textFields.add(factorDueDateTF);
        textFields.add(dispatchCostTF);
        textFields.add(otbCostTF);
        textFields.add(netTF);

        // create main border pane
        BorderPane borderPane = new BorderPane();

        // create grid with required fields
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);

        // add labels and fields
        int row = 0;
        for(Label label : labels) {
            gridPane.add(label, 0, row);
            gridPane.add(textFields.get(row), 1, row);
            row++;
        }

        // wrap in vbox so scrolling actually works
        VBox vBox = new VBox(gridPane);
        vBox.setMinHeight((gridPane.getChildren().size() / 2) * 27); // number of rows * approx size of each row
        vBox.setPrefHeight((gridPane.getChildren().size() / 2) * 27);

        // create scroll bar
        ScrollPane scrollPane = new ScrollPane(vBox);
        scrollPane.setFitToWidth(true);
        scrollPane.setFitToHeight(false);
        scrollPane.setPrefViewportHeight(500);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);

        // place confirm button
        borderPane.setBottom(confirmButton);
        BorderPane.setAlignment(confirmButton, Pos.CENTER);

        borderPane.setCenter(scrollPane);
        this.getChildren().add(borderPane);

        handleEntry(gridPane);
    }

    private void handleEntry(GridPane gridPane) {
        confirmButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                Broker broker = new Broker(brokerCompanyNameTF.getText(), brokerAddressTF.getText(), brokerPhoneNumberTF.getText(),
                        brokerReeferTemperatureTF.getText(), brokerEmailTF.getText(), brokerNameTF.getText(), brokerPONumberTF.getText());
                Shipper shipper = new Shipper(shipperCompanyNameTF.getText(), shipperAddressTF.getText(), shipperPhoneNumberTF.getText(),
                        shipperReeferTemperatureTF.getText(), shipperDeliveryAddressTF.getText(), shipperPickupDateTimeLabel.getText(),
                        shipperApproxWeightTF.getText(), shipperConfirmationNumberTF.getText());
                //Invoice invoice = new Invoice(rkNumberTF.getText(), otbNumberTF.getText())
            }
        });
    }

    private Invoice returnInvoice() {
        return null;
    }

    @Override
    public void setWidth(double width) {
        super.setWidth(width);
    }

    public void setHeight(double height) {
        super.setHeight(height);
    }
}
