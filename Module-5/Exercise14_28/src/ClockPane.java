import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class ClockPane extends Pane {
    private int hour;
    private int minute;
    private int second;
    private boolean hourHandVisible = true;
    private boolean minuteHandVisible = true;
    private boolean secondHandVisible = true;

    // construct default clock with the current time
    public ClockPane() {
        setCurrentTime();
    }

    // construct clock with specified hour, minute and second
    public ClockPane(int hour, int minute, int second) {
        this(hour, minute, second, true, true, true);
    }

    // construct clock with specified hour, minute, second, hour hand visible,
    // minute hand visible and second hand visible
    public ClockPane(int hour, int minute, int second, boolean hourHandVisible, boolean minuteHandVisible,
            boolean secondHandVisible) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
        this.hourHandVisible = hourHandVisible;
        this.minuteHandVisible = minuteHandVisible;
        this.secondHandVisible = secondHandVisible;
    }

    // getters and setters
    // hour
    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
        paintClock();
    }

    // minute
    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
        paintClock();
    }

    // second
    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
        paintClock();
    }

    // hour visibile
    public boolean isHourHandVisible() {
        return hourHandVisible;
    }

    public void setHourHandVisible(boolean hourHandVisible) {
        this.hourHandVisible = hourHandVisible;
        paintClock();
    }

    // minute visible
    public boolean isMinuteHandVisible() {
        return minuteHandVisible;
    }

    public void setMinuteHandVisible(boolean minuteHandVisible) {
        this.minuteHandVisible = minuteHandVisible;
        paintClock();
    }

    // second visible
    public boolean isSecondHandVisible() {
        return secondHandVisible;
    }

    public void setSecondHandVisible(boolean secondHandVisible) {
        this.secondHandVisible = secondHandVisible;
    }

    // set current time
    public void setCurrentTime() {
        // construct calendar for the current date and time
        Calendar calendar = new GregorianCalendar();

        // set current hour, minute and second
        this.hour = calendar.get(Calendar.HOUR_OF_DAY);
        this.minute = calendar.get(Calendar.MINUTE);
        this.second = calendar.get(Calendar.SECOND);

        paintClock();
    }

    // paint the clock
    private void paintClock() {
        // initialize clock parameters
        double clockRadius = Math.min(getWidth(), getHeight()) * 0.8 * 0.5;
        double centerX = getWidth() / 2;
        double centerY = getHeight() / 2;

        // draw circle
        Circle circle = new Circle(centerX, centerY, clockRadius);
        circle.setFill(Color.WHITE);
        circle.setStroke(Color.BLACK);
        Text t1 = new Text(centerX - 5, centerY - clockRadius + 12, "12");
        Text t2 = new Text(centerX - clockRadius + 3, centerY + 5, "9");
        Text t3 = new Text(centerX + clockRadius - 10, centerY + 3, "3");
        Text t4 = new Text(centerX - 3, centerY + clockRadius - 3, "6");

        // draw second hand
        double shLength = clockRadius * 0.8;
        double secondX = centerX + shLength * Math.sin(second * (2 * Math.PI / 60));
        double secondY = centerY - shLength * Math.cos(second * (2 * Math.PI / 60));
        Line shLine = new Line(centerX, centerY, secondX, secondY);
        shLine.setStroke(Color.RED);

        // draw minute hand
        double mhLength = clockRadius * 0.65;
        double minuteX = centerX + mhLength * Math.sin(minute * (2 * Math.PI / 60));
        double minuteY = centerY - mhLength * Math.cos(minute * (2 * Math.PI / 60));
        Line mhLine = new Line(centerX, centerY, minuteX, minuteY);
        mhLine.setStroke(Color.GREEN);

        // draw hour hand
        double hhLength = clockRadius * 0.5;
        double hourX = centerX + hhLength * Math.sin((hour % 12 + minute / 60.0) * (2 * Math.PI / 12));
        double hourY = centerY - hhLength * Math.cos((hour % 12 + minute / 60.0) * (2 * Math.PI / 12));
        Line hhLine = new Line(centerX, centerY, hourX, hourY);
        hhLine.setStroke(Color.BLUE);

        getChildren().clear();
        getChildren().addAll(circle, t1, t2, t3, t4);

        // display hands if visible
        if (hourHandVisible) {
            getChildren().add(hhLine);
        }

        if (minuteHandVisible) {
            getChildren().add(mhLine);
        }

        if (secondHandVisible) {
            getChildren().add(shLine);
        }
    }

    @Override
    public void setWidth(double width) {
        super.setWidth(width);
        paintClock();
    }

    @Override
    public void setHeight(double height) {
        super.setHeight(height);
        paintClock();
    }
}
