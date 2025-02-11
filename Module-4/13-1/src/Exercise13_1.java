import java.util.Scanner;

public class Exercise13_1 {
    public static void main(String[] args) {
        // declare variables
        double side1 = 0.0;
        double side2 = 0.0;
        double side3 = 0.0;
        String color = "";
        boolean filled = false;
        Scanner input = new Scanner(System.in);

        // prompt user and assign sides
        System.out.print("Enter three sides: ");
        side1  = input.nextDouble();
        side2 = input.nextDouble();
        side3 = input.nextDouble();

        // prompt user and assign color
        System.out.print("Enter a color: ");
        input.nextLine();
        color = input.nextLine();

        // prompt user and assign filled status
        System.out.print("Is the triangle filled? (Y/N) ");
        if(Character.toUpperCase(input.nextLine().charAt(0)) == 'Y') {
            filled = true;
        }

        // create new triangle object with user input
        Triangle triangle = new Triangle(side1, side2, side3, color, filled);

        // display triangle
        System.out.println(triangle.toString());
    }
}
