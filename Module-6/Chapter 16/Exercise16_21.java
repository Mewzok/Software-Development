import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Exercise16_21 extends Application {
    private Timeline animation;

    @Override
    public void start(Stage primaryStage) {
        // declare variables
        BorderPane pane = new BorderPane();
        TextField timeField = new TextField();
        Media media = new Media("https://liveexample.pearsoncmg.com/common/audio/anthem/anthem0.mp3");
        MediaPlayer mediaPlayer = new MediaPlayer(media);

        // modify text field parameters
        timeField.setPrefHeight(70);
        timeField.setAlignment(Pos.CENTER);
        timeField.setFont(Font.font("Times New Roman", 35));

        pane.setCenter(timeField);

        // create handler for subtracting from countdown number
        // play media if countdown is 0
        EventHandler<ActionEvent> eventHandler = e -> {
            timeField.setEditable(false);
            if(!timeField.getText().equals("0")) {
                timeField.setText(String.valueOf(Integer.parseInt(timeField.getText()) - 1));
            } else {
                animation.stop();
                mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
                mediaPlayer.play();
            }
        };

        // handle event when input entered and enter key pressed
        timeField.setOnAction(e -> {
            if(animation == null) {
                animation = new Timeline(new KeyFrame(Duration.seconds(1), eventHandler));
                animation.setCycleCount(Timeline.INDEFINITE);
                animation.play();
            }
        });

        // create and show scene
        Scene scene = new Scene(pane, 150, 70);
        primaryStage.setTitle("Exercise16-21");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
