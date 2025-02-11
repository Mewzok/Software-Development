import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class MoreBook extends Application {
    @Override
    public void start(Stage primaryStage) {
        // create a scene and place a button in the scene
        StackPane pane = new StackPane();
        Button btOK = new Button("OK");
        btOK.setStyle("-fx-border-color: blue;");

        pane.setRotate(45);
        pane.setStyle("-fx-border-color: red; -fx-background-color: lightgray;");

        Circle circle = new Circle(45);
        Color color = new Color(1.0, 0.55, 0.233, 0.89);
        circle.setFill(color);

        // label
        Label label = new Label("JavaFX");
        label.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 20));

        // image
        //Image image = new Image("http://liveexample.pearsoncmg.com/book/image/us.gif");
        ImageView imageView = new ImageView("http://liveexample.pearsoncmg.com/book/image/us.gif");

        pane.getChildren().addAll(circle, label, imageView);

        Scene scene = new Scene(pane, 200, 250);
        primaryStage.setTitle("NodeStyleRotateDemo"); // set the stage title
        primaryStage.setScene(scene); // place the scene in the stage
        primaryStage.show();

    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
