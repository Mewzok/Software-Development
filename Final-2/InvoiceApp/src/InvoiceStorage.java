import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;

public class InvoiceStorage {
    private static final String FILE_PATH = "invoices.txt";
    private static final Map<String, Broker> savedBrokers = new HashMap<>();

    // save invoices to file
    public static void saveInvoices(ArrayList<Invoice> invoices) {
        try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            output.writeObject(invoices);
        } catch (IOException e) {
            System.out.println("An error occurred when saving to file.");
            e.printStackTrace();
        }
    }

    // load invoices from file
    public static ArrayList<Invoice> loadInvoices() {
        File file = new File(FILE_PATH);
        if (!file.exists())
            return new ArrayList<Invoice>();

        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            return (ArrayList<Invoice>) input.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("An error occurred when loading from file.");
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    // save a previously used broker
    public static void saveBroker(Broker broker) {
        savedBrokers.put(broker.getCompanyName(), broker);
    }

    // retrieve broker if already exists
    public static Broker getBroker(String companyName) {
        return savedBrokers.get(companyName);
    }

    // get String array of all saved broker names
    public static String[] getSavedBrokerNames() {
        return savedBrokers.keySet().toArray(new String[0]); // automatically created array of correct size
    }
}
