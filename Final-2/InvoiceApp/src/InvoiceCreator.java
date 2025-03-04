import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;

import java.math.BigDecimal;
import java.util.*;

public class InvoiceCreator extends Pane {
    // declare variables
    Invoice invoice = new Invoice();
    private WindowCloseCallback callback;
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
    private final Label receiverPickupNumberLabel = new Label("Receiver Confirmation Number: ");
    private final Label grossLabel = new Label("Gross: ");
    private final Label pickupDateLabel = new Label("Pickup Date: ");
    private final Label deliveryDateLabel = new Label("Delivery Date: ");
    private final Label factorCostLabel = new Label("Factor Cost: ");
    private final Label factorDateLabel = new Label("Factor Date: ");
    private final Label factorDueDateLabel = new Label("Factor Due Date: ");
    private final Label dispatchCostLabel = new Label("Dispatch Cost: ");
    private final Label otbCostLabel = new Label("OTB Cost: ");
    private final Label netLabel = new Label("Net: ");
    private final Label lumperFeeLabel = new Label("Lumper Fee: ");
    private final Label dispatchedFeeLabel = new Label("Dispatch Fee: ");
    private final Label factoredFeeLabel = new Label("Factor Fee: ");
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
    private TextField shipperPickupDateTimeTF = new TextField("");
    private TextField shipperApproxWeightTF = new TextField();
    private TextField shipperConfirmationNumberTF = new TextField();
    private TextField receiverCompanyNameTF = new TextField();
    private TextField receiverAddressTF = new TextField();
    private TextField receiverPhoneNumberTF = new TextField();
    private TextField receiverReeferTemperatureTF = new TextField();
    private TextField receiverDeliveryAddressTF = new TextField();
    private TextField receiverPickupDateTimeTF = new TextField();
    private TextField receiverApproxWeightTF = new TextField();
    private TextField receiverPickupNumberTF = new TextField();
    private TextField grossTF = new TextField();
    private TextField pickupDateTF = new TextField();
    private TextField deliveryDateTF = new TextField();
    private TextField factorCostTF = new TextField();
    private TextField factorDateTF = new TextField();
    private TextField factorDueDateTF = new TextField();
    private TextField dispatchCostTF = new TextField();
    private TextField otbCostTF = new TextField();
    private TextField netTF = new TextField();
    private TextField lumperFeeTF = new TextField("0");
    private TextField dispatchedFeeTF = new TextField("0");
    private TextField factoredFeeTF = new TextField("0");

    private ComboBox<String> rkNumberSuffix = new ComboBox<>();

    private Button confirmButton = new Button("Confirm");

    private ComboBox<String> brokerDropdown = new ComboBox<>();
    private ComboBox<String> shipperDropdown = new ComboBox<>();
    private ComboBox<String> receiverDropdown = new ComboBox<>();

    private CheckBox lumperFeeCheckbox = new CheckBox();
    private CheckBox dispatchedFeeCheckbox = new CheckBox();
    private CheckBox factoredFeeCheckbox = new CheckBox();

    private Label netPayLabel = new Label("");

    private GridPane gridPane = new GridPane();

    // constructor for creating a new invoice
    public InvoiceCreator(WindowCloseCallback callback) {
        this.callback = callback;
        createPane();
    }

    // constructor for editing an existing invoice
    public InvoiceCreator(WindowCloseCallback callback, Invoice invoice) {
        this.callback = callback;
        this.invoice = invoice;
        createPane();
        fillFieldsWithInvoiceData();
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
        labels.add(receiverPickupNumberLabel);
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
        textFields.add(receiverPickupNumberTF);
        textFields.add(grossTF);
        textFields.add(pickupDateTF);
        textFields.add(deliveryDateTF);
        textFields.add(factorCostTF);
        textFields.add(factorDateTF);
        textFields.add(factorDueDateTF);
        textFields.add(dispatchCostTF);
        textFields.add(otbCostTF);
        textFields.add(netTF);

        // load suffix dropdown
        rkNumberSuffix.getItems().addAll("M", "D");

        // load saved fields into dropdowns
        brokerDropdown.getItems().addAll(InvoiceStorage.getSavedBrokerNames());
        shipperDropdown.getItems().addAll(InvoiceStorage.getSavedShipperNames());
        receiverDropdown.getItems().addAll(InvoiceStorage.getSavedReceiverNames());

        // allow typing in ComboBoxes
        rkNumberSuffix.setEditable(true);
        brokerDropdown.setEditable(true);
        shipperDropdown.setEditable(true);
        receiverDropdown.setEditable(true);

        // listen to changes in RK# dropdown
        rkNumberSuffix.setOnAction(e -> updateFormBasedOnSuffix());

        // modify fees
        // lumper
        lumperFeeCheckbox.setSelected(false);
        lumperFeeTF.setEditable(false);
        lumperFeeTF.setStyle("-fx-background-color: #e0e0e0;"); // gray

        // dispatched
        dispatchedFeeCheckbox.setSelected(false);
        dispatchedFeeTF.setEditable(false);
        dispatchedFeeTF.setStyle("-fx-background-color: #e0e0e0;"); // gray

        // factored
        factoredFeeCheckbox.setSelected(false);
        factoredFeeTF.setEditable(false);
        factoredFeeTF.setStyle("-fx-background-color: #e0e0e0;"); // gray

        // allow lumper fee to be entered if checkbox selected
        lumperFeeCheckbox.setOnAction(e -> {
            if(lumperFeeCheckbox.isSelected()) {
                lumperFeeTF.setEditable(true);
                lumperFeeTF.setStyle("-fx-background-color: white;");
                lumperFeeTF.setText("");
            } else {
                lumperFeeTF.setEditable(false);
                lumperFeeTF.setText("0");
                lumperFeeTF.setStyle("-fx-background-color: #e0e0e0;"); // gray
            }
                });

        // allow dispatch fee to be entered if checkbox selected
        dispatchedFeeCheckbox.setOnAction(e -> {
            if(dispatchedFeeCheckbox.isSelected()) {
                dispatchedFeeTF.setEditable(true);
                dispatchedFeeTF.setStyle("-fx-background-color: white;");
                dispatchedFeeTF.setText("5");
            } else {
                dispatchedFeeTF.setEditable(false);
                dispatchedFeeTF.setText("0");
                dispatchedFeeTF.setStyle("-fx-background-color: #e0e0e0;"); // gray
            }
        });

        // allow factor fee to be entered if checkbox selected
        factoredFeeCheckbox.setOnAction(e -> {
            if(factoredFeeCheckbox.isSelected()) {
                factoredFeeTF.setEditable(true);
                factoredFeeTF.setStyle("-fx-background-color: white;");
                factoredFeeTF.setText("");
            } else {
                factoredFeeTF.setEditable(false);
                factoredFeeTF.setText("0");
                factoredFeeTF.setStyle("-fx-background-color: #e0e0e0;"); // gray
            }
        });

        // autofill details when saved field is selected
        // broker autofill
        brokerDropdown.setOnAction(e -> {
            String selectedBroker = brokerDropdown.getValue();
            Broker broker = InvoiceStorage.getBroker(selectedBroker);
            if(broker != null) {
                brokerCompanyNameTF.setText(broker.getCompanyName());
                brokerAddressTF.setText(broker.getAddress());
                brokerPhoneNumberTF.setText(broker.getPhoneNumber());
                brokerReeferTemperatureTF.setText(broker.getReeferTemperature());
                brokerEmailTF.setText(broker.getEmail());
                brokerNameTF.setText(broker.getBrokerName());
                brokerPONumberTF.setText(broker.getPoNumber());
            }
        });

        // shipper autofill
        shipperDropdown.setOnAction(e -> {
            String selectedShipper = shipperDropdown.getValue();
            Shipper shipper = InvoiceStorage.getShipper(selectedShipper);
            if(shipper != null) {
                shipperCompanyNameTF.setText(shipper.getCompanyName());
                shipperAddressTF.setText(shipper.getAddress());
                shipperPhoneNumberTF.setText(shipper.getPhoneNumber());
                shipperReeferTemperatureTF.setText(shipper.getReeferTemperature());
                shipperDeliveryAddressTF.setText(shipper.getDeliveryAddress());
                shipperPickupDateTimeTF.setText(shipper.getPickupDateTime());
                shipperApproxWeightTF.setText(shipper.getApproximateWeight());
                shipperConfirmationNumberTF.setText(shipper.getConfirmationNumber());
            }
        });

        // receiver autofill
        receiverDropdown.setOnAction(e -> {
            String selectedReceiver = receiverDropdown.getValue();
            Receiver receiver = InvoiceStorage.getReceiver(selectedReceiver);
            if(receiver != null) {
                receiverCompanyNameTF.setText(receiver.getCompanyName());
                receiverAddressTF.setText(receiver.getAddress());
                receiverPhoneNumberTF.setText(receiver.getPhoneNumber());
                receiverReeferTemperatureTF.setText(receiver.getReeferTemperature());
                receiverDeliveryAddressTF.setText(receiver.getDeliveryAddress());
                receiverPickupDateTimeTF.setText(receiver.getPickupDateTime());
                receiverApproxWeightTF.setText(receiver.getApproximateWeight());
                receiverPickupNumberTF.setText(receiver.getPickupNumber());
            }
        });

        // listeners for text changes to update net
        setupListeners();

        // create main border pane
        BorderPane borderPane = new BorderPane();

        // create grid with required fields
        gridPane.setHgap(10);
        gridPane.setPrefWidth(350);

        // set column constraints
        ColumnConstraints labelConstraints = new ColumnConstraints(100);
        ColumnConstraints textFieldConstraints = new ColumnConstraints(200);
        ColumnConstraints extraConstraints = new ColumnConstraints(70);
        labelConstraints.setHalignment(HPos.LEFT);
        labelConstraints.setHgrow(Priority.NEVER);
        textFieldConstraints.setHalignment(HPos.LEFT);
        textFieldConstraints.setHgrow(Priority.NEVER);
        extraConstraints.setHalignment(HPos.RIGHT);
        extraConstraints.setHgrow(Priority.NEVER);
        gridPane.getColumnConstraints().addAll(labelConstraints, textFieldConstraints, extraConstraints);

        // group elements into HBox
        HBox rkNumberLabelSpacing = new HBox(5, new Label("   "), rkNumberTF);
        HBox rkNumberHBox = new HBox(5, new Label("-"), rkNumberSuffix);

        // add RK Number label, text field and suffix dropdown
        gridPane.add(rkNumberLabel, 0, 0);
        gridPane.add(rkNumberLabelSpacing, 1, 0);
        gridPane.add(rkNumberHBox, 2, 0);

        /*// add all labels and fields ------------------------
        int row = 0;
        for(Label label : labels) {
            gridPane.add(label, 0, row);
            gridPane.add(textFields.get(row), 1, row);
            if(label.getText().equals("RK#")) {
                gridPane.add(rkNumberSuffix, 2, 0);
            }
            if(label.getText().equals("Broker Company Name: ")) {
                gridPane.add(brokerDropdown, 1, row);
            }
            if(label.getText().equals("Shipper Company Name: ")) {
                gridPane.add(shipperDropdown, 1, row);
            }
            if(label.getText().equals("Receiver Company Name: ")) {
                gridPane.add(receiverDropdown, 1, row);
            }
            row++;
        }*/

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

        // vbox for button and label
        netPayLabel.setStyle("-fx-font-size: 16px;");
        VBox bottomElements = new VBox(5, netPayLabel, confirmButton);
        bottomElements.setAlignment(Pos.CENTER);

        // place confirm button
        borderPane.setBottom(bottomElements);

        borderPane.setCenter(scrollPane);
        this.getChildren().add(borderPane);

        handleEntry();
    }

    // set up event listeners for required text fields
    private void setupListeners() {
        grossTF.textProperty().addListener((observable, oldValue, newValue) -> updateNetProfit());
        lumperFeeTF.textProperty().addListener((observable, oldValue, newValue) -> updateNetProfit());
        dispatchedFeeTF.textProperty().addListener((observable, oldValue, newValue) -> updateNetProfit());
        factoredFeeTF.textProperty().addListener((observable, oldValue, newValue) -> updateNetProfit());
    }

    // consistently update net profit
    private void updateNetProfit() {
        try {
            BigDecimal sum;
            BigDecimal gross = new BigDecimal(grossTF.getText().isEmpty() ? "0" : grossTF.getText());
            BigDecimal lumperFee = new BigDecimal(lumperFeeTF.getText().isEmpty() ? "0" : lumperFeeTF.getText());
            BigDecimal dispatchedFee = new BigDecimal(dispatchedFeeTF.getText().isEmpty() ? "0" : dispatchedFeeTF.getText());
            BigDecimal factoredFee = new BigDecimal(factoredFeeTF.getText().isEmpty() ? "0" : factoredFeeTF.getText());

            // calculate net profit
            sum = gross; // first get gross
            sum = sum.subtract(lumperFee); // second subtract lumper fee
            sum = sum.subtract(sum.multiply(dispatchedFee.divide(new BigDecimal(100)))); // third subtract dispatch fee
            sum = sum.subtract(sum.multiply(factoredFee.divide(new BigDecimal(100)))); // fourth subtract factor fee

            BigDecimal netProfit = sum;

            netPayLabel.setText("Net Profit: $" + netProfit);
        } catch(NumberFormatException e) {
            netPayLabel.setText("Net Profit: Error");
        }
    }

    private void handleEntry() {
        confirmButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                invoice.setValidInvoice(true);
                // create broker shipper and receiver objects from inputted fields
                Broker broker = new Broker(brokerCompanyNameTF.getText(), brokerAddressTF.getText(), brokerPhoneNumberTF.getText(),
                        brokerReeferTemperatureTF.getText(), brokerEmailTF.getText(), brokerNameTF.getText(), brokerPONumberTF.getText());
                Shipper shipper = new Shipper(shipperCompanyNameTF.getText(), shipperAddressTF.getText(), shipperPhoneNumberTF.getText(),
                        shipperReeferTemperatureTF.getText(), shipperDeliveryAddressTF.getText(), shipperPickupDateTimeTF.getText(),
                        shipperApproxWeightTF.getText(), shipperConfirmationNumberTF.getText());
                Receiver receiver = new Receiver(receiverCompanyNameTF.getText(), receiverAddressTF.getText(), receiverPhoneNumberTF.getText(),
                        receiverReeferTemperatureTF.getText(), receiverDeliveryAddressTF.getText(), receiverPickupDateTimeTF.getText(),
                        receiverApproxWeightTF.getText(), receiverPickupNumberTF.getText());

                // convert inputted number fields to BigDecimals
                BigDecimal grossDecimal = bigDecimalConversion(grossTF, "gross");
                BigDecimal factorCostDecimal = bigDecimalConversion(factorCostTF, "factor cost");
                BigDecimal dispatchCostDecimal = bigDecimalConversion(dispatchCostTF, "dispatch cost");
                BigDecimal otbCostDecimal = bigDecimalConversion(otbCostTF, "OTB cost");
                BigDecimal netDecimal = bigDecimalConversion(netTF, "net");

                // check for valid values before creating invoice
                if(invoice.isValidInvoice()) {
                    invoice.setRkNumber(rkNumberTF.getText());
                    invoice.setOtbNumber(otbNumberTF.getText());
                    invoice.setBroker(broker);
                    invoice.setShipper(shipper);
                    invoice.setReceiver(receiver);
                    invoice.setGross(grossDecimal);
                    invoice.setPickupDate(pickupDateTF.getText());
                    invoice.setDeliveryDate(deliveryDateTF.getText());
                    invoice.setFactorCost(factorCostDecimal);
                    invoice.setFactorDate(factorDateTF.getText());
                    invoice.setFactorDueDate(factorDueDateTF.getText());
                    invoice.setDispatchCost(dispatchCostDecimal);
                    invoice.setOtbCost(otbCostDecimal);
                    invoice.setNet(netDecimal);

                    callback.onCloseWindow();
                }
            }
        });
    }

    private void updateFormBasedOnSuffix() {
        // receive RK# suffix
        String selectedSuffix = rkNumberSuffix.getValue();

        // modify and group elements into hbox
        HBox grossHBox = new HBox(5, new Label("$"), grossTF);
        HBox lumperHBox = new HBox(5, new Label("$"), lumperFeeTF);
        HBox dispatchHBox = new HBox(5, new Label("   "), dispatchedFeeTF, new Label("%"));
        HBox factorHBox = new HBox(5, new Label("   "), factoredFeeTF, new Label("%"));

        // change form based on suffix
        if(selectedSuffix.equals("M")) {
            gridPane.add(grossLabel, 0, 1);
            gridPane.add(grossHBox, 1, 1);
            gridPane.add(new Label(""), 2, 1);
            gridPane.add(lumperFeeLabel, 0, 2);
            gridPane.add(lumperHBox, 1, 2);
            gridPane.add(lumperFeeCheckbox, 2, 2);
            gridPane.add(dispatchedFeeLabel, 0, 3);
            gridPane.add(dispatchHBox, 1, 3);
            gridPane.add(dispatchedFeeCheckbox, 2, 3);
            gridPane.add(factoredFeeLabel, 0, 4);
            gridPane.add(factorHBox, 1, 4);
            gridPane.add(factoredFeeCheckbox, 2, 4);
        }
    }

    private BigDecimal bigDecimalConversion(TextField tf, String fieldType) {
        try{
            BigDecimal bigDecimal = new BigDecimal(tf.getText());
            return bigDecimal;
        } catch(NumberFormatException e) {
            invoice.setValidInvoice(false);

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Invalid Input");
            alert.setHeaderText(null);
            alert.setContentText(tf.getText() + " is not a valid value for " + fieldType + ".");

            alert.showAndWait();
            return null;
        }
    }

    public Invoice getInvoice() {
        return invoice;
    }

    private void fillFieldsWithInvoiceData() {
        if(invoice != null) {
            rkNumberTF.setText(invoice.getRkNumber());
            otbNumberTF.setText(invoice.getOtbNumber());
            brokerDropdown.setValue(invoice.getBroker().getCompanyName());
            brokerAddressTF.setText(invoice.getBroker().getAddress());
            brokerPhoneNumberTF.setText(invoice.getBroker().getPhoneNumber());
            brokerReeferTemperatureTF.setText(invoice.getBroker().getReeferTemperature());
            brokerEmailTF.setText(invoice.getBroker().getEmail());
            brokerNameTF.setText(invoice.getBroker().getBrokerName());
            brokerPONumberTF.setText(invoice.getBroker().getPoNumber());
            shipperDropdown.setValue(invoice.getShipper().getCompanyName());
            shipperAddressTF.setText(invoice.getShipper().getAddress());
            shipperPhoneNumberTF.setText(invoice.getShipper().getPhoneNumber());
            shipperReeferTemperatureTF.setText(invoice.getShipper().getReeferTemperature());
            shipperDeliveryAddressTF.setText(invoice.getShipper().getDeliveryAddress());
            shipperPickupDateTimeTF.setText(invoice.getShipper().getPickupDateTime());
            shipperApproxWeightTF.setText(invoice.getShipper().getApproximateWeight());
            shipperConfirmationNumberTF.setText(invoice.getShipper().getConfirmationNumber());
            receiverDropdown.setValue(invoice.getReceiver().getCompanyName());
            receiverAddressTF.setText(invoice.getReceiver().getAddress());
            receiverPhoneNumberTF.setText(invoice.getReceiver().getPhoneNumber());
            receiverReeferTemperatureTF.setText(invoice.getReceiver().getReeferTemperature());
            receiverDeliveryAddressTF.setText(invoice.getReceiver().getDeliveryAddress());
            receiverPickupDateTimeTF.setText(invoice.getReceiver().getPickupDateTime());
            receiverApproxWeightTF.setText(invoice.getReceiver().getApproximateWeight());
            receiverPickupNumberTF.setText(invoice.getReceiver().getPickupNumber());
            grossTF.setText(invoice.getGross().toString());
            pickupDateTF.setText(invoice.getPickupDate());
            deliveryDateTF.setText(invoice.getDeliveryDate());
            factorCostTF.setText(invoice.getFactorCost().toString());
            factorDateTF.setText(invoice.getFactorDate());
            factorDueDateTF.setText(invoice.getFactorDueDate());
            dispatchCostTF.setText(invoice.getDispatchCost().toString());
            otbCostTF.setText(invoice.getOtbCost().toString());
            netTF.setText(invoice.getNet().toString());
        }
    }
}
