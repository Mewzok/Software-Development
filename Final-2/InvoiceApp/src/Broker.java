import java.io.Serializable;

public class Broker extends Logistic implements Serializable {
    protected String email;
    protected String brokerName;
    protected String poNumber;

    public Broker() {
    }

    public Broker(String companyName, String address, String phoneNumber, String reeferTemperature, String email,
            String brokerName, String poNumber) {
        super(companyName, address, phoneNumber, reeferTemperature);
        this.email = email;
        this.brokerName = brokerName;
        this.poNumber = poNumber;
    }

    // getters
    public String getEmail() {
        return email;
    }

    public String getBrokerName() {
        return brokerName;
    }

    public String getPoNumber() {
        return poNumber;
    }

    // setters
    public void setEmail(String email) {
        this.email = email;
    }

    public void setBrokerName(String brokerName) {
        this.brokerName = brokerName;
    }

    public void setPoNumber(String poNumber) {
        this.poNumber = poNumber;
    }
}
