import java.util.Scanner;

public class Exercise13_11 {
    public static void main(String[] args) {
        // declare variables
        Octagon octagon = new Octagon();

        Scanner input = new Scanner(System.in);

        // prompt user and assign input
        System.out.print("Enter side length: ");
        double sideLength = input.nextDouble();

        // set octagon's side length
        octagon.setSideLength(sideLength);

        // clone octagon
        Octagon octagon2 = (Octagon)octagon.clone();

        // display octagon's areas
        System.out.println("Area 1: " + octagon.getArea() +
        "\nArea 2: " + octagon2.getArea());

        // compare octagons
        System.out.println("Compared: " + octagon.compareTo(octagon2));
        
        if(octagon.compareTo(octagon2) == 0) {
            System.out.println("Octagons are equal");
        }
    }
}
