import java.io.*;
import java.util.*;

public class Exercise12_15 {
    public static void main(String[] args) throws Exception {
        // delcare variables
        File numFile = new File("Exercise12_15.txt");
        ArrayList<Integer> hundredNumbers = new ArrayList<>();
        ArrayList<Integer> hundredNumbersRead = new ArrayList<>();

        // fill array with random numbers
        generateNumbers(hundredNumbers);

        // print numbers array to new file or overwrite current file
        writeToFile(numFile, hundredNumbers);

        // read numbers from file
        readFromFile(numFile, hundredNumbersRead);
        
        // sort read array
        Collections.sort(hundredNumbersRead);

        // display contents of array
        System.out.println(hundredNumbersRead.toString());
    }

    public static void generateNumbers(ArrayList<Integer> numbers) {
        // assign random numbers to array
        for(int i = 0; i < 100; i++) {
            numbers.add((int)(Math.random() * 100));
        }
    }

    public static void writeToFile(File file, ArrayList<Integer> numbers) {
        try(PrintWriter output = new PrintWriter(file)) {
            // write array contents to file
            for(int i = 0; i < 100; i++) {
                output.print(numbers.get(i) + " ");
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public static void readFromFile(File file, ArrayList<Integer> numsRead) {
        // declare variables
        try {
            Scanner input = new Scanner(file);
            while(input.hasNext()) {
                numsRead.add(input.nextInt());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
