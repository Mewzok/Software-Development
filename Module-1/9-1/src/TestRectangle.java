public class TestRectangle {
    public static void main(String[] args) {
        Rectangle rectangle1 = new Rectangle(4, 40);
        Rectangle rectangle2 = new Rectangle(3.5, 35.9);

        // display properties of rectangle 1
        System.out.println("Rectangle 1\nWidth: " + rectangle1.width + "\nHeight: " + rectangle1.height + "\nArea: " +
        rectangle1.getArea() + "\nPerimeter: " + rectangle1.getPerimeter());

        // display properties of rectangle 2
        System.out.println("Rectangle 2\nWidth: " + rectangle2.width + "\nHeight: " + rectangle2.height + "\nArea: " +
        rectangle2.getArea() + "\nPerimeter: " + rectangle2.getPerimeter());
    }
}