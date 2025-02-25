import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Programming17_14 {
    public static void main(String[] args) {
        // declare variables
        Scanner in = new Scanner(System.in);

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

        // create new output file
        System.out.print("Enter new file name: ");
        userInput = in.nextLine();

        // create second File object with user input
        File file2 = new File(userInput);

        // ensure output file doesn't exit
        while(file.exists()) {
            System.out.print("File already exists. Enter file name: ");
            userInput = in.nextLine();
            file2 = new File(userInput);
        }

        // copy old file to new file
        copyFile();

        try(RandomAccessFile raf = new RandomAccessFile(file, "rw")) {

            for(int i = 1; i < raf.length(); i++) {
                raf.seek(i * 4);
                raf.writeInt(5);
            }

        } catch(FileNotFoundException e) {
            e.printStackTrace();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public static void copyFile() {
        
    }
}
