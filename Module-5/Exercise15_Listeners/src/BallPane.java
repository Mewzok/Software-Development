import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class BallPane extends Pane {
    public final double radius = 20;
    public final int moveIncrement = 50;
    private double x = radius, y = radius;
    private Circle circle = new Circle(x, y, radius);

    public BallPane() {
        circle.setStroke(Color.BLACK);
        circle.setFill(Color.WHITE);
        getChildren().add(circle);
    }

    protected void moveLeft() {
        if((circle.getCenterX() - radius) > 0) {
            circle.setCenterX(circle.getCenterX() - moveIncrement);
            if(circle.getCenterX() - radius < 0) {
                circle.setCenterX(radius);
            }
        }
    }

    protected void moveRight() {
        if((circle.getCenterX() + radius) < this.getWidth()) {
            circle.setCenterX(circle.getCenterX() + moveIncrement);
            if(circle.getCenterX() + radius > this.getWidth()) {
                circle.setCenterX(this.getWidth() - radius);
            }
        }
    }

    protected void moveUp() {
        if((circle.getCenterY() - radius) > 0) {
            circle.setCenterY(circle.getCenterY() - moveIncrement);
            if(circle.getCenterY() - radius < 0) {
                circle.setCenterY(0 + radius);
            }
        }
    }

    protected void moveDown() {
        if((circle.getCenterY() + radius) < this.getHeight()) {
            circle.setCenterY(circle.getCenterY() + moveIncrement);
            if(circle.getCenterY() + radius > this.getHeight()) {
                circle.setCenterY(this.getHeight() - radius);
            }
        }
    }

    protected void resize() {
        if(circle.getCenterX() - radius < 0) {
            circle.setCenterX(radius);
        }

        if(circle.getCenterX() + radius > this.getWidth()) {
            circle.setCenterX(this.getWidth() - radius);
        }

        if(circle.getCenterY() - radius < 0) {
            circle.setCenterY(radius);
        }

        if(circle.getCenterY() + radius > this.getHeight()) {
            circle.setCenterY(this.getHeight() - radius);
        }
    }
}