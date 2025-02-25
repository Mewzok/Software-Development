import java.math.BigDecimal;
import java.util.Date;

public class Invoice {
    private String rkNumber;
    private String otbNumber;
    private BigDecimal gross;
    private Date pickupDate;
    private Date deliveryDate;
    private BigDecimal factorCost;
    private Date factorDate;
    private Date factorDueDate;
    private BigDecimal dispatchCost;
    private BigDecimal otbCost;
    private BigDecimal net;

    // no arg constructor
    public Invoice() {
        this.rkNumber = "";
        this.otbNumber = "";
        this.gross = BigDecimal.ZERO;
        this.pickupDate = null;
        this.deliveryDate = null;
        this.factorCost = BigDecimal.ZERO;
        this.factorDate = null;
        this.factorDueDate = null;
        this.dispatchCost = BigDecimal.ZERO;
        this.otbCost = BigDecimal.ZERO;
        this.net = BigDecimal.ZERO;
    }

    // all arg constructor
    public Invoice(String rkNumber, String otbNumber, BigDecimal gross, Date pickupDate, Date deliveryDate,
                   BigDecimal factorCost, Date factorDate, Date factorDueDate, BigDecimal dispatchCost,
                   BigDecimal otbCost, BigDecimal net) {
        this.rkNumber = rkNumber;
        this.otbNumber = otbNumber;
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
