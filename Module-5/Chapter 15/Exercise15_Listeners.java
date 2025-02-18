import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Exercise15_Listeners extends Application {
    // create panes and buttons
    BorderPane borderPane = new BorderPane();
    BallPane ballPane = new BallPane();
    Button btLeft = new Button("Left");
    Button btRight = new Button("Right");
    Button btUp = new Button("Up");
    Button btDown = new Button("Down");
    HBox hBox = new HBox(5, btLeft, btRight, btUp, btDown);

    @Override
    public void start(Stage primaryStage) {
        hBox.setAlignment(Pos.CENTER);

        borderPane.setCenter(ballPane);
        borderPane.setBottom(hBox);

        // create and register button handlers
        btLeft.setOnAction(e -> {
            ballPane.moveLeft();
        });

        btRight.setOnAction(e -> {
            ballPane.moveRight();
        });

        btUp.setOnAction(e -> {
            ballPane.moveUp();
        });

        btDown.setOnAction(e -> {
            ballPane.moveDown();
        });

        // listener to prevent ball from going offscreen if window is resized
        ballPane.widthProperty().addListener(ov -> ballPane.resize());
        ballPane.heightProperty().addListener(ov -> ballPane.resize());

        // create scene and place in stage
        Scene scene = new Scene(borderPane, 200, 200);
        primaryStage.setMinWidth(125);
        primaryStage.setMinHeight(125);
        primaryStage.setTitle("Exercise15_Listeners");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}