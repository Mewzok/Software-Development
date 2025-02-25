import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Programming17_15 {
    public static void main(String[] args) {
        // declare variables
        Scanner in = new Scanner(System.in);

        // get valid source file
        File encryptedFile = getValidFile(in, "Enter encrypted file name: ", true);

        // get valid destination file
        File unencryptedFile = getValidFile(in, "Enter new file name: ", false);

        // unencrypt and write to new file
        unencryptFile(encryptedFile, unencryptedFile);

        // inform user of successful operation
        System.out.println("Operation completed successfully.");
    }

    private static File getValidFile(Scanner in, String message, boolean mustExist) {
        File file;
        while(true) {
            System.out.print(message);
            file = new File(in.nextLine());
            if(mustExist && file.exists()) break;
            if(!mustExist && !file.exists()) break;
            System.out.println("Invalid input.");
        }
        return file;
    }

    // unencrypt file method
    private static void unencryptFile(File fileSource, File fileTarget) {
        try(BufferedInputStream input = new BufferedInputStream(new FileInputStream(fileSource));
        BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream(fileTarget));) {

            // write to file, subtracting 5 from each byte
            int r;
            while((r = input.read()) != -1) {
                output.write(r - 5);
            }
            
        } catch(FileNotFoundException e) {
            System.out.println("File not found.");
            e.printStackTrace();
        } catch(IOException e) {
            System.out.println("An error occured.");
            e.printStackTrace();
        }
    }
}
