import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class WriteFile {
    public static void main(String[] args) {
        // declare variables
        String userString = "";
        Scanner in = new Scanner(System.in);

        // receive user input for file name
        System.out.print("Enter file name: ");
        String userInput = in.nextLine();

        // create File object with user input
        File file = new File(userInput);

        // ensure source file does not exist
        while(file.exists()) {
            System.out.print("File already exists. Enter file name: ");
            userInput = in.nextLine();
            file = new File(userInput);
        }

        // receive input to write to file
        System.out.print("Input to write to file: ");
        userString = in.nextLine();

        // create binary file
        try(DataOutputStream output = new DataOutputStream(new FileOutputStream(file));) {
            output.writeChars(userString);

            for(int i = 1; i <= 10; i++) {
                output.write(i);
            }

            System.out.println("Operation completed successfully.");
        } catch(FileNotFoundException e) {
            System.out.println("File not found.");
            e.printStackTrace();
        } catch(IOException e) {
            System.out.println("An error occured.");
            e.printStackTrace();
        }
    }
}
