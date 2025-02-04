import java.util.Scanner;

public class TestAccount {
    public static void main(String[] args) {
        // declare variables
        int userId = -1;
        int userInput = -1;
        Account[] accounts = new Account[10];
        Scanner input = new Scanner(System.in);

        // initialize accounts
        for(int i = 0; i < accounts.length; i++) {
            accounts[i] = new Account(i, 100);
        }

        while(true) { // infinitely loop program
            // reset user input
            userInput = -1;

            // check for and receive valid ID number
            while(true) { // loop until valid ID received, return when main menu exited
                System.out.println("\nEnter valid ID number: ");
                userId = input.nextInt();

                if(userId >= 0 && userId <= 9) {
                    break;
                }

                System.out.println("Invalid ID number.");
            }


            while(userInput != 4) { // loop until menu exited
                // display main menu
                userInput = displayMainMenu();

                switch(userInput) {
                    case 1:
                    checkBalance(accounts[userId]);
                    break;

                    case 2:
                    withdraw(accounts[userId]);
                    break;

                    case 3:
                    deposit(accounts[userId]);
                    break;
                }
            }
        }
    }

    public static int displayMainMenu() {
        int userInput = 0;
        Scanner input = new Scanner(System.in);

        while(true) {
            // display menu and options
            System.out.println("\nMain menu");
            System.out.println("1: check balance");
            System.out.println("2: withdraw");
            System.out.println("3: deposit");
            System.out.println("4: exit");
            System.out.print("Enter a choice: ");
            userInput = input.nextInt();

            if(userInput > 0 && userInput < 5) {
                return userInput;
            } else {
                userInput = 0;
                System.out.println("Invalid input.");
            }
        }
    }

    public static void checkBalance(Account account) {
        // declare variables
        Scanner in = new Scanner(System.in);

        // display current balance
        System.out.printf("\nThe balance is $%.2f\n", account.getBalance());
        System.out.print("Press enter to continue...");
        in.nextLine(); // wait for user
    }

    public static void withdraw(Account account) {
        // declare variables
        Scanner in = new Scanner(System.in);
        double amount = 0.0;

        // prompt user for amount to withdraw
        System.out.print("Enter an amount to withdraw: $");
        amount = in.nextDouble();

        // withdraw from account
        account.withdraw(amount);

        // display updated information
        System.out.printf("Successfully withdrew $%.2f.\n", amount);
        System.out.printf("Remaining balance: $%.2f.\n", account.getBalance());
        in.nextLine(); // consume newline
        System.out.print("Press enter to continue...");
        in.nextLine(); // wait for user
    }

    public static void deposit(Account account) {
        //declare variables
        Scanner in = new Scanner(System.in);
        double amount = 0.0;

        // prompt user for amount to deposit
        System.out.print("Enter an amount to deposit: $");
        amount = in.nextDouble();

        // deposit to account
        account.deposit(amount);

        // display updated information
        System.out.printf("Successfully deposited $%.2f.\n", amount);
        System.out.printf("Current balance: $%.2f.\n", account.getBalance());
        in.nextLine(); // consume newline
        System.out.print("Press enter to continue...");
        in.nextLine(); // wait for user
    }
}
