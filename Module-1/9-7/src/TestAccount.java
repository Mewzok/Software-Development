public class TestAccount {
    public static void main(String[] args) {
        Account account = new Account(1122, 20000.0, 4.5);

        // withdraw
        account.withdraw(2500);
        System.out.printf("New balance after withdrawal is: $%.2f\n", account.getBalance());

        // deposit
        account.deposit(3000);
        System.out.printf("New balance after deposit is: $%.2f\n", account.getBalance());

        // display current properties
        System.out.printf("Account balance: $%.2f\n", account.getBalance());
        System.out.printf("Monthly interest: $%.2f\n", account.getMonthlyInterest());
        System.out.println("Account date created: " + account.getDate());
    }
}
