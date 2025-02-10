import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise12_3 {
    public static void main(String[] args) throws Exception {
        // declare variables
        int userInput = 0;
        int[] hundredNumbers = new int[100];

        Scanner in = new Scanner(System.in);

        // initialize array with random numbers
        for(int i = 0; i < hundredNumbers.length; i++) {
            hundredNumbers[i] = (int)(Math.random() * 100);
        }

        // receive and assign user input
        System.out.print("Enter a number: ");
        userInput = in.nextInt();

        // try to display number at user's chosen index
        try {
         System.out.println("Number at index " + userInput + " is " + hundredNumbers[userInput]);

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Out of Bounds.");
        }
    }
}
