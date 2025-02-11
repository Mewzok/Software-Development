public class Octagon extends GeometricObject implements Comparable<Octagon>, Cloneable{
    // declare variables
    private double sideLength;

    // constructors
    public Octagon() {
        this(1.0);
    }

    public Octagon(double sideLength) {
        this.sideLength = sideLength;
    }

    // getters and setters
    public double getSideLength() {
        return sideLength;
    }

    public void setSideLength(double sideLength) {
        this.sideLength = sideLength;
    }

    // get area and perimeter
    public double getArea() {
        double area = 2 * (1 + Math.sqrt(2)) * sideLength * sideLength;
        return area;
    }

    public double getPerimeter() {
        return sideLength * 8;
    }

    // implement compareTo
    @Override
    public int compareTo(Octagon o) {
        if(getArea() > o.getArea()) {
            return 1;
        } else if (getArea() < o.getArea()) {
            return -1;
        } else {
            return 0;
        }
    }

    // implement clone
    @Override
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
