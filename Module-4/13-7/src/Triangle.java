public class Triangle extends GeometricObject implements Colorable {
    // declare variables
    private double side1;
    private double side2;
    private double side3;

    // constructors
    public Triangle() {
        this(1.0, 1.0, 1.0, "white", false);
    }

    public Triangle(double side1, double side2, double side3) {
        this(side1, side2, side3, "white", false);
    }

    public Triangle(double side1, double side2, double side3, String color, boolean filled) {
        super(color, filled);
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    // getters and setters
    public double getSide1() {
        return side1;
    }

    public void setSide1(double side1) {
        this.side1 = side1;
    }

    public double getSide2() {
        return side2;
    }

    public void setSide2(double side2) {
        this.side2 = side2;
    }

    public double getSide3() {
        return side3;
    }

    public void setSide3(double side3) {
        this.side3 = side3;
    }

    // toString
    @Override
    public String toString() {
        return "Area: " + getArea() + "\nPerimeter: " + getPerimeter() + "\n" + super.toString();
    }

    // implemented area and perimeter methods
    public double getArea() {
        double s = (side1 + side2 + side3) / 2;
        double area = Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));

        return area;
    }

    public double getPerimeter() {
        double perimeter = side1 + side2 + side3;

        return perimeter;
    }

    // implement how to color
    @Override
    public void howToColor() {
        System.out.println("Color all three sides");
    }
}
