public class Rectangle {
    // declare variables, public for assignment
    public double width;
    public double height;

    // default constructor
    Rectangle() {
        width = 1;
        height = 1;
    }

    Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getArea() {
        return width * height;
    }

    public double getPerimeter() {
        return 2 * (width + height);
    }
}