public class TestAccount {
    public static void main(String[] args) {
        // declare variables
        Account account = new Account(1122, 20000.0, 4.5);
        CheckingAccount checkingAccount = new CheckingAccount(151, 151.00, 7, 150.00);
        SavingsAccount savingsAccount = new SavingsAccount(160, 251.00, 9);

        // invoke toStrings
        System.out.println("Account:\n" + account.toString());
        System.out.println("Checking Account:\n" + checkingAccount.toString());
        System.out.println("Savings Account:\n" + savingsAccount.toString());
    }
}
