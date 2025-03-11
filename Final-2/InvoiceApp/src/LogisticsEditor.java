import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LogisticsEditor extends Stage {

    private WindowCloseCallback callback;
    private ComboBox<String> logisticsTypeComboBox = new ComboBox<>();
    private ListView<String> logisticsListView = new ListView<>();
    private Button editButton = new Button("Edit");
    private Button deleteButton = new Button("Delete");

    public LogisticsEditor(WindowCloseCallback callback) {
        setTitle("Logistics Editor");

        // main layout
        VBox vBox = new VBox(10);
        vBox.setPadding(new Insets(10));

        // logistic selection combobox
        logisticsTypeComboBox.getItems().addAll("Brokers", "Shippers", "Receivers");
        logisticsTypeComboBox.setValue("Brokers");

        // listview to display all saved selected logistics
        updateLogisticsList("Brokers"); // default

        // event handlers
        logisticsTypeComboBox.setOnAction(e -> {
            updateLogisticsList(logisticsTypeComboBox.getValue());
        });

        editButton.setOnAction(this::handleEdit);
        deleteButton.setOnAction(this::handleDelete);

        // add everything to layout
        vBox.getChildren().addAll(logisticsTypeComboBox, logisticsListView, editButton, deleteButton);

        // scene
        Scene scene = new Scene(vBox);
        setScene(scene);
        show();
    }

    // update listview based on selected logistic
    private void updateLogisticsList(String selection) {
        logisticsListView.getItems().clear();

        if (selection.equals("Brokers")) {
            logisticsListView.getItems().addAll(InvoiceStorage.getSavedBrokerNames());
        } else if (selection.equals("Shippers")) {
            logisticsListView.getItems().addAll(InvoiceStorage.getSavedShipperNames());
        } else if (selection.equals("Receivers")) {
            logisticsListView.getItems().addAll(InvoiceStorage.getSavedReceiverNames());
        }
    }

    // edit button handle method
    private void handleEdit(ActionEvent event) {
        String selection = logisticsListView.getSelectionModel().getSelectedItem();

        if (selection != null) {
            if (logisticsTypeComboBox.getValue().equals("Brokers")) {
                Broker broker = InvoiceStorage.getBroker(selection);
                openEditorWindow(broker);
            } else if (logisticsTypeComboBox.getValue().equals("Shippers")) {
                Shipper shipper = InvoiceStorage.getShipper(selection);
                openEditorWindow(shipper);
            } else if (logisticsTypeComboBox.getValue().equals("Receiver")) {
                Receiver receiver = InvoiceStorage.getReceiver(selection);
                openEditorWindow(receiver);
            }
        }
    }

    private void openEditorWindow(Logistic logistic) {
        // create editor
    }

    private void handleDelete(ActionEvent event) {
        String selection = logisticsListView.getSelectionModel().getSelectedItem();

        if (selection != null) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Delete Logistic");
            alert.setHeaderText("Are you sure you want to delete this " +
                    logisticsTypeComboBox.getValue().substring(0, logisticsTypeComboBox.getValue().length() - 1) + "?");
            alert.setContentText("This action cannot be undone.");

            alert.showAndWait().ifPresent(response -> {
                if (response == ButtonType.OK) {
                    // delete logistic
                    if(logisticsTypeComboBox.getValue().equals("Brokers")) {
                        InvoiceStorage.deleteBroker(selection);
                    } else if(logisticsTypeComboBox.getValue().equals("Shippers")) {
                        InvoiceStorage.deleteShipper(selection);
                    } else if(logisticsTypeComboBox.getValue().equals("Receivers")) {
                        InvoiceStorage.deleteReceiver(selection);
                    }
                    updateLogisticsList(logisticsTypeComboBox.getValue()); // update list
                }
            });
        }
    }

    // error message
    private void alertError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
