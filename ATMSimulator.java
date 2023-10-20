import java.util.*;

public class ATMSimulator {
    private double balance; // Balance in the account
    private String password;

    public ATMSimulator(double initialBalance, String password) {
        balance = initialBalance;
        this.password = password;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println(amount + " deposited successfully.");
    }

    // Method to withdraw money
    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println(amount + " withdrawn successfully.");
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    // Method to check balance
    public void checkBalance() {
        System.out.println("Current balance: " + balance);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Creating an instance of ATMSimulator with an initial balance of 1000 and a password
        ATMSimulator atm = new ATMSimulator(1000, "Chaitanya@123");

        boolean exit = false;

        while (!exit) {
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    atm.deposit(depositAmount);
                    break;
                case 2:
                    System.out.print("Enter Password: ");
                    String cpass = scanner.next();
                    if (cpass.equals(atm.password)) {
                        System.out.print("Enter amount to withdraw: ");
                        double withdrawAmount = scanner.nextDouble();
                        atm.withdraw(withdrawAmount);
                    } else {
                        System.out.println("XXXXX !Wrong Password! XXXXX");
                    }
                    break;
                case 3:
                    System.out.print("Enter Password: ");
                    String checkPassword = scanner.next();
                    if (checkPassword.equals(atm.password)) {
                        atm.checkBalance();
                    } else {
                        System.out.println("XXXXX !Wrong Password! XXXXX");
                    }
                    break;
                case 4:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

            System.out.println();
        }

        scanner.close();
        System.out.println("Thank you for using our ATM. Goodbye!");
    }
}
