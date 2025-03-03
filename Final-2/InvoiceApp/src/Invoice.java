import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Invoice implements Serializable {
    private String rkNumber;
    private String otbNumber;
    private Broker broker;
    private Shipper shipper;
    private Receiver receiver;
    private BigDecimal gross;
    private String pickupDate;
    private String deliveryDate;
    private BigDecimal factorCost;
    private String factorDate;
    private String factorDueDate;
    private BigDecimal dispatchCost;
    private BigDecimal otbCost;
    private BigDecimal net;
    private boolean validInvoice;

    public Invoice() {
        this.rkNumber = "";
        this.otbNumber = "";
        this.broker = null;
        this.shipper = null;
        this.receiver = null;
        this.gross = new BigDecimal(0);
        this.pickupDate = "";
        this.deliveryDate = "";
        this.factorCost = new BigDecimal(0);
        this.factorDate = "";
        this.factorDueDate = "";
        this.dispatchCost = new BigDecimal(0);
        this.otbCost = new BigDecimal(0);
        this.net = new BigDecimal(0);
        this.validInvoice = false;
    };

    // all arg constructor
    public Invoice(String rkNumber, String otbNumber, Broker broker, Shipper shipper, Receiver receiver,
            BigDecimal gross, String pickupDate, String deliveryDate, BigDecimal factorCost, String factorDate,
            String factorDueDate, BigDecimal dispatchCost,
            BigDecimal otbCost, BigDecimal net) {
        this.rkNumber = rkNumber;
        this.otbNumber = otbNumber;
        this.broker = broker;
        this.shipper = shipper;
        this.receiver = receiver;
        this.gross = gross;
        this.pickupDate = pickupDate;
        this.deliveryDate = deliveryDate;
        this.factorCost = factorCost;
        this.factorDate = factorDate;
        this.factorDueDate = factorDueDate;
        this.dispatchCost = dispatchCost;
        this.otbCost = otbCost;
        this.net = net;
        this.validInvoice = true;
    }

    // Getters
    public String getRkNumber() {
        return rkNumber;
    }

    public String getOtbNumber() {
        return otbNumber;
    }

    public Broker getBroker() {
        return broker;
    }

    public Shipper getShipper() {
        return shipper;
    }

    public Receiver getReceiver() {
        return receiver;
    }

    public BigDecimal getGross() {
        return gross;
    }

    public String getPickupDate() {
        return pickupDate;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public BigDecimal getFactorCost() {
        return factorCost;
    }

    public String getFactorDate() {
        return factorDate;
    }

    public String getFactorDueDate() {
        return factorDueDate;
    }

    public BigDecimal getDispatchCost() {
        return dispatchCost;
    }

    public BigDecimal getOtbCost() {
        return otbCost;
    }

    public BigDecimal getNet() {
        return net;
    }

    public boolean isValidInvoice() {
        return validInvoice;
    }

    // Setters
    public void setRkNumber(String rkNumber) {
        this.rkNumber = rkNumber;
    }

    public void setOtbNumber(String otbNumber) {
        this.otbNumber = otbNumber;
    }

    public void setBroker(Broker broker) {
        this.broker = broker;
    }

    public void setShipper(Shipper shipper) {
        this.shipper = shipper;
    }

    public void setReceiver(Receiver receiver) {
        this.receiver = receiver;
    }

    public void setGross(BigDecimal gross) {
        this.gross = gross;
    }

    public void setPickupDate(String pickupDate) {
        this.pickupDate = pickupDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public void setFactorCost(BigDecimal factorCost) {
        this.factorCost = factorCost;
    }

    public void setFactorDate(String factorDate) {
        this.factorDate = factorDate;
    }

    public void setFactorDueDate(String factorDueDate) {
        this.factorDueDate = factorDueDate;
    }

    public void setDispatchCost(BigDecimal dispatchCost) {
        this.dispatchCost = dispatchCost;
    }

    public void setOtbCost(BigDecimal otbCost) {
        this.otbCost = otbCost;
    }

    public void setNet(BigDecimal net) {
        this.net = net;
    }

    public void setValidInvoice(boolean validInvoice) {
        this.validInvoice = validInvoice;
    }
}
