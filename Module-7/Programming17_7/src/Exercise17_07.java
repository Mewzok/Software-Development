/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rmazorow
 */
import java.io.*;

public class Exercise17_07 {
    public static void main(String[] args) throws FileNotFoundException {
        Loan loan1 = new Loan();
        Loan loan2 = new Loan(1.8, 10, 10000);
        
        try (
                ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("Exercise17_07.dat"));
        ) {
            output.writeObject(loan1);
            output.writeObject(loan2);
        } 
        catch (IOException ex) {
            System.out.println("File could not be opened");
        }

        // display loan data
        outputData();
    }

    public static void outputData() {
        // declare variables
        int increment = 1;

        // loop through Loan objects until end of file
        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream("Exercise17_07.dat"))) {
            while(true) {
                Loan tempLoan = (Loan)input.readObject();
                System.out.println("Loan #" + increment + " $" + tempLoan.getLoanAmount());
                increment++;
            }
        } catch (EOFException ex) {
            System.out.println("End of file reached.");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            System.out.println("File could not be opened");
        }
    }
}
