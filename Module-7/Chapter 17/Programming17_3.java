import java.io.*;

public class Programming17_3 {
    public static void main(String[] args) {
        // declare variables
        File file = new File("Exercise17_03.dat");
        int readNum = 0;
        int sum = 0;

        // check if file exists, assign result to boolean variable
        boolean append = file.exists();

        // create or append to file
        try (DataOutputStream output = new DataOutputStream(new BufferedOutputStream(
            new FileOutputStream(file, append)))) {
            for(int i = 0; i < 100; i++) {
                output.writeInt((int)(Math.random() * 101)); // write 100 random numbers
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // read numbers from file
        try (DataInputStream input = new DataInputStream(new BufferedInputStream(
            new FileInputStream(file)))) {
                // loop through entire file, displaying read integer and adding to total sum
                while (true) {
                    readNum = input.readInt();
                    sum += readNum;

                    System.out.print(readNum + " ");
                }
            } catch (EOFException e) { 
                // when end of file error is thrown, display total sum
                System.out.print("Total sum: " + sum);
            } catch (IOException e) {
                e.printStackTrace();
            }

    }
}
