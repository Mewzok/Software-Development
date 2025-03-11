import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LogisticsEditor extends Stage {
    public LogisticsEditor() {
        setTitle("Logistics Editor");

        // main layout
        BorderPane mainPane = new BorderPane();
        VBox buttonBox = new VBox(10);

        // choice buttons
        Button editBrokersButton = new Button("Edit Brokers");
        Button editShippersButton = new Button("Edit Shippers");
        Button editReceiversButton = new Button("Edit Receivers");

        buttonBox.getChildren().addAll(editBrokersButton, editShippersButton, editReceiversButton);
        mainPane.setCenter(buttonBox);

        // button handlers
        editBrokersButton.setOnAction(e -> openEditorWindow("Brokers"));
        editShippersButton.setOnAction(e -> openEditorWindow("Shippers"));
        editReceiversButton.setOnAction(e -> openEditorWindow("Receivers"));

        // scene
        Scene scene = new Scene(mainPane, 300, 200);
        setScene(scene);
        show();
    }

    private void openEditorWindow(String type) {
        //new LogisticsListWindow(type);
    }
}
