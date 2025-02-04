public class CheckingAccount extends Account {
    // declare variables
    private double overdraftLimit = 0.0;

    // constructors
    public CheckingAccount() {
        this(0, 0.0, 0.0, 0.0);
    }

    public CheckingAccount(int id, double balance, double annualInterestRate, double overdraftLimit) {
        super(id, balance, annualInterestRate);
        this.overdraftLimit = overdraftLimit;
    }

    // getters and setters
    public double getOverdraftLimit() {
        return overdraftLimit;
    }

    public void setOverdraftLimit(double overdraftLimit) {
        this.overdraftLimit = overdraftLimit;
    }

    // overridden toString
    @Override
    public String toString() {
        return super.toString() + String.format("Overdraft limit: %.2f\n", overdraftLimit);
    }
}
