public abstract class GeometricObject implements Colorable {
    // declare variables
    private String color;
    private boolean filled;

    // constructors
    protected GeometricObject() {
        this("white", false);
    }

    protected GeometricObject(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    // getters and setters
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    // toString
    @Override
    public String toString() {
        return "Color: " + color + "\nFilled: " + filled;
    }

    // abstract area and perimeter methods
    public abstract double getArea();

    public abstract double getPerimeter();

    // implement howToColor but leave abstract
    @Override
    public abstract void howToColor();
}
