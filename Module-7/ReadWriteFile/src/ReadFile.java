import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class ReadFile {
    public static void main(String[] args) {
        // declare variables
        Scanner in = new Scanner(System.in);

        // receive user input for file name
        System.out.print("Enter file name: ");
        String userInput = in.nextLine();

        // create File object with user input
        File file = new File(userInput);

        // ensure source file exists
        while(!file.exists()) {
            System.out.print("File not found. Enter file name: ");
            userInput = in.nextLine();
            file = new File(userInput);
        }

        try(BufferedInputStream input = new BufferedInputStream(new FileInputStream(file));) {
            byte[] byteArray = input.readAllBytes();
            String str = new String(byteArray, StandardCharsets.UTF_8);

            System.out.println(str);
        } catch(FileNotFoundException e) {
            System.out.println("File not found.");
            e.printStackTrace();
        } catch(IOException e) {
            System.out.println("An error occured.");
            e.printStackTrace();
        }
    }
}
