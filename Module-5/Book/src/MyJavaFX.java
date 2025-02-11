import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class MyJavaFX extends Application {
    @Override
    public void start(Stage primaryStage) {
        // create a circle
        Pane paneCircle = new Pane(); // pane to store the circle

        Circle circle = new Circle();
        circle.centerXProperty().bind(paneCircle.widthProperty().divide(2));
        circle.centerYProperty().bind(paneCircle.heightProperty().divide(2));
        circle.setRadius(50);
        circle.setStroke(Color.BLACK);
        circle.setFill(Color.WHITE);
        paneCircle.getChildren().add(circle);

        Button btOK = new Button("OK");
        StackPane pane = new StackPane(btOK); // create pane
        // pane.getChildren().add(btOK); // add button to pane, not needed because of above line
        Scene scene = new Scene(paneCircle, 200, 250);
        primaryStage.setTitle("MyJavaFX"); // set the stage title
        primaryStage.setScene(scene); // place the scene in the stage¡
        primaryStage.show(); // display the stage

        Stage stage = new Stage(); // create a new stage
        stage.setTitle("Second Stage"); // set the stage title
        stage.setResizable(false); // prevent user from resizing stage
        // set a scene with a button in the stage
        stage.setScene(new Scene(new Button("New Stage"), 200, 250));

        stage.show(); // display the stage
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
