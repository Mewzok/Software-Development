import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;

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

    // create default InvoiceCreator window
    public InvoiceCreator() {
        createPane();
    }

    private void createPane() {
        // create main border pane
        BorderPane borderPane = new BorderPane();

        // create grid with required fields
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);

        // company numbers
        gridPane.add(rkNumberLabel, 0, 0);
        gridPane.add(rkNumberTF, 1, 0);
        gridPane.add(otbNumberLabel, 0, 1);
        gridPane.add(otbNumberTF, 1, 1);

        // broker
        gridPane.add(brokerCompanyNameLabel, 0, 2);
        gridPane.add(brokerCompanyNameTF, 1, 2);
        gridPane.add(brokerAddressLabel, 0, 3);
        gridPane.add(brokerAddressTF, 1, 3);
        gridPane.add(brokerPhoneNumberLabel, 0, 4);
        gridPane.add(brokerPhoneNumberTF, 1, 4);
        gridPane.add(brokerReeferTemperatureLabel, 0, 5);
        gridPane.add(brokerReeferTemperatureTF, 1, 5);
        gridPane.add(brokerEmailLabel, 0, 6);
        gridPane.add(brokerEmailTF, 1, 6);
        gridPane.add(brokerNameLabel, 0, 7);
        gridPane.add(brokerNameTF, 1, 7);
        gridPane.add(brokerPONumberLabel, 0, 8);
        gridPane.add(brokerPONumberTF, 1, 8);

        // shipper
        gridPane.add(shipperCompanyNameLabel, 0, 9);
        gridPane.add(shipperCompanyNameTF, 1, 9);
        gridPane.add(shipperAddressLabel, 0, 10);
        gridPane.add(shipperAddressTF, 1, 10);
        gridPane.add(shipperPhoneNumberLabel, 0, 11);
        gridPane.add(shipperPhoneNumberTF, 1, 11);
        gridPane.add(shipperReeferTemperatureLabel, 0, 12);
        gridPane.add(shipperReeferTemperatureTF, 1, 12);
        gridPane.add(shipperDeliveryAddressLabel, 0, 13);
        gridPane.add(shipperDeliveryAddressTF, 1, 13);
        gridPane.add(shipperPickupDateTimeLabel, 0, 14);
        gridPane.add(shipperPickupDateTimeTF, 1, 14);
        gridPane.add(shipperApproxWeightLabel, 0, 15);
        gridPane.add(shipperApproxWeightTF, 1, 15);

        // receiver
        gridPane.add(receiverCompanyNameLabel, 0, 16);
        gridPane.add(receiverCompanyNameTF, 1, 16);
        gridPane.add(receiverAddressLabel, 0, 17);
        gridPane.add(receiverAddressTF, 1, 17);
        gridPane.add(receiverPhoneNumberLabel, 0, 18);
        gridPane.add(receiverPhoneNumberTF, 1, 18);
        gridPane.add(receiverReeferTemperatureLabel, 0, 19);
        gridPane.add(receiverReeferTemperatureTF, 1, 19);
        gridPane.add(receiverDeliveryAddressLabel, 0, 20);
        gridPane.add(receiverDeliveryAddressTF, 1, 20);
        gridPane.add(receiverPickupDateTimeLabel, 0, 21);
        gridPane.add(receiverPickupDateTimeTF, 1, 21);
        gridPane.add(receiverApproxWeightLabel, 0, 22);
        gridPane.add(receiverApproxWeightTF, 1, 22);
        gridPane.add(receiverConfirmationNumberLabel, 0, 23);
        gridPane.add(receiverConfirmationNumberTF, 1, 23);

        // gross, dates, factors, costs, net
        gridPane.add(grossLabel, 0, 24);
        gridPane.add(grossTF, 1, 24);
        gridPane.add(pickupDateLabel, 0, 25);
        gridPane.add(pickupDateTF, 1, 25);
        gridPane.add(deliveryDateLabel, 0, 26);
        gridPane.add(deliveryDateTF, 1, 26);
        gridPane.add(factorCostLabel, 0, 27);
        gridPane.add(factorCostTF, 1, 27);
        gridPane.add(factorDateLabel, 0, 28);
        gridPane.add(factorDateTF, 1, 28);
        gridPane.add(factorDueDateLabel, 0, 29);
        gridPane.add(factorDueDateTF, 1, 29);
        gridPane.add(dispatchCostLabel, 0, 30);
        gridPane.add(dispatchCostTF, 1, 30);
        gridPane.add(otbCostLabel, 0, 31);
        gridPane.add(otbCostTF, 1, 31);
        gridPane.add(netLabel, 0, 32);
        gridPane.add(netTF, 1, 32);

        // wrap in vbox so scrolling actually works
        VBox vBox = new VBox(gridPane);
        vBox.setMinHeight((gridPane.getChildren().size() / 2) * 27); // number of rows * approx size of each row
        vBox.setPrefHeight((gridPane.getChildren().size() / 2) * 27);

        // create scroll bar
        ScrollPane scrollPane = new ScrollPane(vBox);
        scrollPane.setFitToWidth(true);
        scrollPane.setFitToHeight(false);
        scrollPane.setPrefViewportHeight(600);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);

        borderPane.setCenter(scrollPane);
        this.getChildren().add(borderPane);
    }

    @Override
    public void setWidth(double width) {
        super.setWidth(width);
    }

    public void setHeight(double height) {
        super.setHeight(height);
    }
}
