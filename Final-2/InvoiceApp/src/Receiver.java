import java.io.Serializable;

public class Receiver extends Transport implements Serializable {
    protected String pickupNumber;

    public Receiver() {
    }

    public Receiver(String companyName, String address, String phoneNumber, String reeferTemperature,
            String deliveryAddress, String pickupDateTime, String approximateWeight, String confirmationNumber) {
        super(companyName, address, phoneNumber, reeferTemperature, deliveryAddress, pickupDateTime, approximateWeight);
        this.pickupNumber = confirmationNumber;
    }

    // getters
    public String getPickupNumber() {
        return pickupNumber;
    }

    // setters
    public void setPickupNumber(String pickupNumber) {
        this.pickupNumber = pickupNumber;
    }
}
