import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Exercise16_1 extends Application {
    @Override
    public void start(Stage primaryStage) {
        // main pane
        BorderPane pane = new BorderPane();

        // button pane and buttons for moving text left and right
        HBox paneForButtons = new HBox(5);
        Button btLeft = new Button("<=");
        Button btRight = new Button("=>");

        paneForButtons.getChildren().addAll(btLeft, btRight);
        paneForButtons.setAlignment(Pos.CENTER);
        paneForButtons.setStyle("-fx-border-color: black");

        // radio button pane and radio buttons for colors
        HBox paneForRadio = new HBox(20);
        paneForRadio.setStyle("-fx-border-color: black");
        paneForRadio.setAlignment(Pos.CENTER);
        RadioButton rbRed = new RadioButton("Red");
        RadioButton rbYellow = new RadioButton("Yellow");
        RadioButton rbBlack = new RadioButton("Black");
        RadioButton rbOrange = new RadioButton("Orange");
        RadioButton rbGreen = new RadioButton("Green");
        paneForRadio.getChildren().addAll(rbRed, rbYellow, rbBlack, rbOrange, rbGreen);

        // add radio buttons to group
        ToggleGroup group = new ToggleGroup();
        rbRed.setToggleGroup(group);
        rbYellow.setToggleGroup(group);
        rbBlack.setToggleGroup(group);
        rbOrange.setToggleGroup(group);
        rbGreen.setToggleGroup(group);

        // text pane and text
        Text text = new Text(50, 50, "Programming is fun");
        text.setFont(new Font(20));

        Pane paneForText = new Pane();
        paneForText.getChildren().add(text);

        // place panes in main pane
        pane.setTop(paneForRadio);
        pane.setCenter(paneForText);
        pane.setBottom(paneForButtons);

        // handle button events
        btLeft.setOnAction(e -> {
            if(text.getX() - 10 < 0) { // prevent text from going offscreen to the left
                text.setX(0);
            } else {
                text.setX(text.getX() - 10);
            }
        });
        btRight.setOnAction(e -> {
            if(text.getX() + 10 > paneForText.getWidth() - text.getBoundsInLocal().getWidth()) { // prevent text from
                text.setX(paneForText.getWidth() - text.getBoundsInLocal().getWidth()); // going offscreen to the right
            } else {
                text.setX(text.getX() + 10);
            }
        });

        // handle radio button events
        rbRed.setOnAction(e -> {
            if(rbRed.isSelected()) {
                text.setFill(Color.RED);
            }
        });

        rbYellow.setOnAction(e -> {
            if(rbYellow.isSelected()) {
                text.setFill(Color.YELLOW);
            }
        });

        rbBlack.setOnAction(e -> {
            if(rbBlack.isSelected()) {
                text.setFill(Color.BLACK);
            }
        });

        rbOrange.setOnAction(e -> {
            if(rbOrange.isSelected()) {
                text.setFill(Color.ORANGE);
            }
        });

        rbGreen.setOnAction(e -> {
            if(rbGreen.isSelected()) {
                text.setFill(Color.GREEN);
            }
        });

        // set default
        text.setFill(Color.RED);
        rbRed.setSelected(true);

        // place pane in scene and scene in stage
        Scene scene = new Scene(pane, 450, 200);
        primaryStage.setTitle("Exercise16-1");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
