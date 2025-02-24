import com.sun.tools.javac.comp.Check;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class App1 extends Application {
    protected Text text = new Text(50, 50, "JavaFX Programming");

    protected BorderPane getPane() {
        // main pane
        BorderPane pane = new BorderPane();

        // button pane
        HBox paneForButtons = new HBox(20);
        Button btLeft = new Button("Left");
        Button btRight = new Button("Right");

        paneForButtons.getChildren().addAll(btLeft, btRight);
        paneForButtons.setAlignment(Pos.CENTER);
        paneForButtons.setStyle("-fx-border-width: 2px; -fx-border-color: green");

        // checkbox pane
        VBox paneForCheckbox = new VBox(20);
        paneForCheckbox.setPadding(new Insets(5, 5, 5, 5));
        CheckBox chkBold = new CheckBox("Bold");
        CheckBox chkItalic = new CheckBox("Italic");

        paneForCheckbox.getChildren().addAll(chkBold, chkItalic);
        paneForCheckbox.setStyle("-fx-border-width: 2px; -fx-border-color: green");

        // radio pane
        VBox paneForRadio = new VBox(20);
        paneForRadio.setPadding(new Insets(5, 5, 5, 5));
        paneForRadio.setStyle("-fx-border-width: 2px; -fx-border-color: green");
        RadioButton rbRed = new RadioButton("Red");
        RadioButton rbGreen = new RadioButton("Green");
        RadioButton rbBlue = new RadioButton("Blue");
        paneForRadio.getChildren().addAll(rbRed, rbGreen, rbBlue);

        ToggleGroup group = new ToggleGroup();
        rbRed.setToggleGroup(group);
        rbGreen.setToggleGroup(group);
        rbBlue.setToggleGroup(group);

        // textField pane
        BorderPane paneForTextField = new BorderPane();
        paneForTextField.setPadding(new Insets(5, 5, 5, 5));
        paneForTextField.setStyle("-fx-border-width: 2px; -fx-border-color: green");
        paneForTextField.setLeft(new Label("Enter a new Message: "));

        TextField tf = new TextField();
        tf.setAlignment(Pos.BOTTOM_RIGHT);
        paneForTextField.setCenter(tf);
        pane.setTop(paneForTextField);

        // text pane
        Pane paneForText = new Pane();
        paneForText.getChildren().add(text);

        // set default
        text.setFill(Color.RED);
        rbRed.fire();

        pane.setBottom(paneForButtons);
        pane.setCenter(paneForText);
        pane.setRight(paneForCheckbox);
        pane.setLeft(paneForRadio);

        tf.setOnAction(e -> text.setText(tf.getText()));

        btLeft.setOnAction(e -> text.setX(text.getX() - 10));
        btRight.setOnAction(e -> text.setX(text.getX() + 10));

        EventHandler<ActionEvent> handler = e -> {
            if(chkBold.isSelected() && chkItalic.isSelected()) {
                text.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 20));
            } else if(chkBold.isSelected()) {
                text.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 20));
            } else if(chkItalic.isSelected()) {
                text.setFont(Font.font("Times New Roman", FontWeight.NORMAL, FontPosture.ITALIC, 20));
            } else {
                text.setFont(Font.font("Times New Roman", FontWeight.NORMAL, FontPosture.REGULAR, 20));
            }
        };

        chkBold.setOnAction(handler);
        chkItalic.setOnAction(handler);

        rbRed.setOnAction(e -> {
            if(rbRed.isSelected()) {
                text.setFill(Color.RED);
            }
        });

        rbGreen.setOnAction(e -> {
            if(rbGreen.isSelected()) {
                text.setFill(Color.GREEN);
            }
        });

        rbBlue.setOnAction(e -> {
            if(rbBlue.isSelected()) {
                text.setFill(Color.BLUE);
            }
        });

        return pane;
    }

    @Override
    public void start(Stage primaryStage) {
        Scene scene = new Scene(getPane(), 450, 200);
        primaryStage.setTitle("ButtonDemo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
