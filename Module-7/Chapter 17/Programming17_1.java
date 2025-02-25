import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Programming17_1 {
    public static void main(String[] args) {
        // declare variables
        File file = new File("Exercise17_01.txt");

        // check if file exists, assign result to boolean variable
        boolean append = file.exists();

        // create writer, append if file exists
        try (FileWriter fw = new FileWriter(file, append)) {
            for(int i = 0; i < 100; i++) {
                fw.write(((int) (Math.random() * 101)) + " "); // write random number + space 100 times
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
