import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Programming17_14 {
    public static void main(String[] args) {
        // declare variables
        Scanner in = new Scanner(System.in);

        // get valid source file
        File file = getValidFile(in, "Enter source file name: ", true);

        // get valid destination file
        File file2 = getValidFile(in, "Enter new file name: ", false);

        // copy old file to new file
        copyFile(file, file2);

        // place number 5 after every 4th number in copied output file
        modifyFile(file2);

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

    // copy file method
    private static void copyFile(File fileSource, File fileTarget) {
        try(BufferedInputStream input = new BufferedInputStream(new FileInputStream(fileSource));
        BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream(fileTarget));) {
            // continuously read a byte from input and write it to output
            int r = 0;
            while((r = input.read()) != -1) {
                output.write((byte)r);
            }
        } catch(FileNotFoundException e) {
            System.out.println("File not found.");
            e.printStackTrace();
        } catch(IOException e) {
            System.out.println("An error occured.");
            e.printStackTrace();
        }
    }

    // modify file by adding 5 to every byte
    private static void modifyFile(File fileTarget) {
        try(RandomAccessFile raf = new RandomAccessFile(fileTarget, "rw")) {
            long originLength = raf.length();

            for(long i = 0; i < originLength; i++) {
                raf.seek(i);
                int originalByte = raf.read();
                raf.seek(i);
                raf.write(originalByte + 5);
            }
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
