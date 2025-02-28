public class Transport extends Logistic {
    protected String deliveryAddress;
    protected String pickupDateTime;
    protected double approximateWeight;

    public Transport() {
    }

    public Transport(String companyName, String address, String phoneNumber, double reeferTemperature,
            String deliveryAddress, String pickupDateTime, double approximateWeight) {
        super(companyName, address, phoneNumber, reeferTemperature);
        this.deliveryAddress = deliveryAddress;
        this.pickupDateTime = pickupDateTime;
        this.approximateWeight = approximateWeight;
    }

    // getters
    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public String getPickupDateTime() {
        return pickupDateTime;
    }

    public double getApproximateWeight() {
        return approximateWeight;
    }

    // setters
    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public void setPickupDateTime(String pickupDateTime) {
        this.pickupDateTime = pickupDateTime;
    }

    public void setApproximateWeight(double approximateWeight) {
        this.approximateWeight = approximateWeight;
    }
}
