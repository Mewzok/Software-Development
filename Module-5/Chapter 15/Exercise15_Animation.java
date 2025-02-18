import javafx.animation.*;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Exercise15_Animation extends Application {

    @Override
    public void start(Stage primaryStage) {
        double sceneWidth = 250;
        double sceneHeight = 200;

        // create a pane
        Pane pane = new Pane();

        // create a rectangle
        Rectangle rectangle = new Rectangle(0, 0, 25, 50);
        rectangle.setFill(Color.RED);

        // create a pentagon
        double centerX = sceneWidth / 2;
        double centerY = sceneHeight / 2;
        double radius = 70;

        Double[] points = new Double[10];

        System.out.println(centerX);

        Polygon pentagon = new Polygon();

        pentagon.setStroke(Color.BLACK);
        pentagon.setFill(Color.GOLD);

        for(int i = 0; i < 5; i++) {
            double angle = Math.toRadians(-90 + i * 72);
            points[i * 2] = centerX + radius * Math.cos(angle);
            points[i * 2 + 1] = centerY + radius * Math.sin(angle);
        }

        pentagon.getPoints().addAll(points);

        pane.getChildren().addAll(pentagon, rectangle);

        // create path transition
        PathTransition pt = new PathTransition();
        pt.setDuration(Duration.millis(4000));
        pt.setPath(pentagon);
        pt.setNode(rectangle);
        pt.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        pt.setCycleCount(Timeline.INDEFINITE);
        pt.play();

        // apply fade
        FadeTransition ft = new FadeTransition(Duration.millis(3000), rectangle);
        ft.setFromValue(1.0);
        ft.setToValue(0.1);
        ft.setCycleCount(Timeline.INDEFINITE);
        ft.setAutoReverse(true);
        ft.play();

        // pause on mouse click
        pane.setOnMousePressed(e -> {
            pt.pause();
            ft.pause();
        });
        pane.setOnMouseReleased(e -> {
            pt.play();
            ft.play();
        });

        // create scene and place in stage
        Scene scene = new Scene(pane, sceneWidth, sceneHeight);
        primaryStage.setTitle("Exercise15_Animation");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
