import java.io.Serializable;

public abstract class Logistic implements Serializable {

    protected String companyName;
    protected String address;
    protected String phoneNumber;
    protected double reeferTemperature;

    public Logistic() {
    }

    public Logistic(String companyName, String address, String phoneNumber, double reeferTemperature) {
        this.companyName = companyName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.reeferTemperature = reeferTemperature;
    }

    // getters
    public String getCompanyName() {
        return companyName;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public double getReeferTemperature() {
        return reeferTemperature;
    }

    // setters
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setReeferTemperature(double reeferTemperature) {
        this.reeferTemperature = reeferTemperature;
    }
}
