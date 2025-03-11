import java.io.Serializable;

public class Receiver extends Transport implements Serializable {
    protected String pickupNumber;

    public Receiver() {
    }

    public Receiver(String companyName, String address, String phoneNumber, String reeferTemperature, String extraInfo,
            String deliveryAddress, String pickupDateTime, String approximateWeight, String pickupNumber) {
        super(companyName, address, phoneNumber, reeferTemperature, extraInfo, deliveryAddress, pickupDateTime,
                approximateWeight);
        this.pickupNumber = pickupNumber;
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
