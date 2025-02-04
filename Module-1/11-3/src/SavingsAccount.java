public class SavingsAccount extends Account {
    // constructors
    public SavingsAccount() {
        this(0, 0.0, 0.0);
    }

    public SavingsAccount(int id, double balance, double annualInterestRate) {
        super(id, balance, annualInterestRate);
    }

    // withdraw, deny if insufficient funds
    @Override
    public void withdraw(double amount) {
        if(amount > getBalance()) {
            System.out.println("Withdrawal denied. Insufficient funds.");
        } else {
            setBalance(getBalance() - amount);
        }
    }

    // overridden toString
    @Override
    public String toString() {
        return super.toString() + "Cannot be overdrawn.\n";
    }
}
