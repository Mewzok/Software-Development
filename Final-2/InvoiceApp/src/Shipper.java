import java.io.Serializable;

public class Shipper extends Transport implements Serializable {
    protected long confirmationNumber;

    public Shipper() {
    }

    public Shipper(String companyName, String address, String phoneNumber, double reeferTemperature,
            String deliveryAddress, String pickupDateTime, double approximateWeight, long confirmationNumber) {
        super(companyName, address, phoneNumber, reeferTemperature, deliveryAddress, pickupDateTime, approximateWeight);
        this.confirmationNumber = confirmationNumber;
    }

    // getters
    public long getConfirmationNumber() {
        return confirmationNumber;
    }

    // setters
    public void setConfirmationNumber(long confirmationNumber) {
        this.confirmationNumber = confirmationNumber;
    }
}
