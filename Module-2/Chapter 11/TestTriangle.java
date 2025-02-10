import java.util.Scanner;

public class TestTriangle {
    public static void main(String[] args) {
        // declare variables
        Scanner in = new Scanner(System.in);

        Triangle triangle1 = new Triangle();

        // prompt user and receive all 3 sides
        System.out.print("Enter side 1: ");
        triangle1.setSide1(in.nextDouble());

        System.out.print("Enter side 2: ");
        triangle1.setSide2(in.nextDouble());

        System.out.print("Enter side 3: ");
        triangle1.setSide3(in.nextDouble());

        // prompt user and receive color
        in.nextLine(); // consume newline
        System.out.print("Enter color: ");
        triangle1.setColor(in.nextLine());

        // prompt user and receive filled status
        System.out.print("Enter filled (true | false): ");
        triangle1.setFilled(in.nextBoolean());

        // display triangle properties
        System.out.println("Area: " + triangle1.getArea() + "\nPerimeter: " + triangle1.getPerimeter() + "\nColor: " +
        triangle1.getColor() + "\nDate created: " + triangle1.getDate() + "\nFilled: " + triangle1.isFilled());
    }
}
