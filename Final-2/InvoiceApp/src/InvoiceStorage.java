import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;

public class InvoiceStorage {
    private static final String FILE_PATH = "invoices.txt";

    // save invoices to a file
    public static void saveInvoices(ArrayList<Invoice> invoices) {
        try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            output.writeObject(invoices);
        } catch (IOException e) {
            System.out.println("An error occured when saving to file.");
            e.printStackTrace();
        }
    }

    public static ArrayList<Invoice> loadInvoices() {
        File file = new File(FILE_PATH);
        if (!file.exists())
            return new ArrayList<>();

        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            return (ArrayList<Invoice>) input.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("An error occured when loading from file.");
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
