import java.io.Serializable;

public class Receiver extends Transport implements Serializable {
    protected long pickupNumber;

    public Receiver() {
    }

    public Receiver(String companyName, String address, String phoneNumber, double reeferTemperature,
            String deliveryAddress, String pickupDateTime, double approximateWeight, long confirmationNumber) {
        super(companyName, address, phoneNumber, reeferTemperature, deliveryAddress, pickupDateTime, approximateWeight);
        this.pickupNumber = confirmationNumber;
    }

    // getters
    public long getPickupNumber() {
        return pickupNumber;
    }

    // setters
    public void setPickupNumber(long pickupNumber) {
        this.pickupNumber = pickupNumber;
    }
}
