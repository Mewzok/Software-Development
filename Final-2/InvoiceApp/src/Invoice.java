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
    private Date pickupDate;
    private Date deliveryDate;
    private BigDecimal factorCost;
    private Date factorDate;
    private Date factorDueDate;
    private BigDecimal dispatchCost;
    private BigDecimal otbCost;
    private BigDecimal net;

    // all arg constructor
    public Invoice(String rkNumber, String otbNumber, Broker broker, Shipper shipper, Receiver receiver,
            BigDecimal gross, Date pickupDate, Date deliveryDate, BigDecimal factorCost, Date factorDate,
            Date factorDueDate, BigDecimal dispatchCost,
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

    public Date getPickupDate() {
        return pickupDate;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public BigDecimal getFactorCost() {
        return factorCost;
    }

    public Date getFactorDate() {
        return factorDate;
    }

    public Date getFactorDueDate() {
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

    public void setPickupDate(Date pickupDate) {
        this.pickupDate = pickupDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public void setFactorCost(BigDecimal factorCost) {
        this.factorCost = factorCost;
    }

    public void setFactorDate(Date factorDate) {
        this.factorDate = factorDate;
    }

    public void setFactorDueDate(Date factorDueDate) {
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
}
