import java.io.Serializable;

public class Shipper extends Transport implements Serializable {
    protected String confirmationNumber;

    public Shipper() {
    }

    public Shipper(String companyName, String address, String phoneNumber, String reeferTemperature,
            String deliveryAddress, String pickupDateTime, String approximateWeight, String confirmationNumber) {
        super(companyName, address, phoneNumber, reeferTemperature, deliveryAddress, pickupDateTime, approximateWeight);
        this.confirmationNumber = confirmationNumber;
    }

    // getters
    public String getConfirmationNumber() {
        return confirmationNumber;
    }

    // setters
    public void setConfirmationNumber(String confirmationNumber) {
        this.confirmationNumber = confirmationNumber;
    }
}
