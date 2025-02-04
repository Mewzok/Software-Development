import java.util.Date;

public class Account {
    private int id;
    private double balance;
    private double annualInterestRate;
    private Date dateCreated;

    Account() {
        this(0, 0, 0);
    }

    Account(int id, double balance) {
        this(id, balance, 4.5);
    }

    Account(int id, double balance, double annualInterestRate) {
        this.id = id;
        this.balance = balance;
        this.annualInterestRate = annualInterestRate;

        dateCreated = new java.util.Date();
    }

    // id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // balance
    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    // annual interest rate
    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    // calculate monthly interest rate
    public double getMonthlyInterestRate() {
        return (annualInterestRate / 100) / 12;
    }

    // calculate montly interest
    public double getMonthlyInterest() {
        double monthlyInterestRate = getMonthlyInterestRate();

        return balance * monthlyInterestRate;
    }

    // withdraw
    public void withdraw(double amount) {
        balance -= amount;
    }

    // deposit
    public void deposit(double amount) {
        balance += amount;
    }

    // date
    public Date getDate() {
        return dateCreated;
    }
}
