import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ATM_Application {

    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000.0);
        
        ATM atm = new ATM(account, "user123", "1234");
        
        atm.start();
    }
}

class BankAccount {
    private double balance;
    private List<String> transactionHistory;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
        this.transactionHistory = new ArrayList<>();
        transactionHistory.add("Initial deposit: $" + initialBalance);
    }

    public void addTransactionNote(String note) {
        this.transactionHistory.add(note);
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactionHistory.add("Deposited: $" + amount);
            System.out.println("Successfully deposited $" + amount);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    public boolean withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive.");
            return false;
        }
        if (amount > balance) {
            System.out.println("Error: Insufficient funds.");
            return false;
        }
        balance -= amount;
        transactionHistory.add("Withdrew: $" + amount);
        System.out.println("Successfully withdrew $" + amount);
        return true;
    }

    public void printTransactionHistory() {
        System.out.println("\n--- Transaction History ---");
        for (String transaction : transactionHistory) {
            System.out.println(transaction);
        }
        System.out.println("-------------------------");
    }
}

class ATM {
    private BankAccount userAccount;
    private String userId;
    private String userPin;
    private Scanner scanner;

    public ATM(BankAccount account, String userId, String userPin) {
        this.userAccount = account;
        this.userId = userId;
        this.userPin = userPin;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("Welcome to the ATM!");
        if (authenticateUser()) {
            showMenu();
        } else {
            System.out.println("Authentication failed. Exiting...");
        }
        scanner.close();
    }

    private boolean authenticateUser() {
        System.out.print("Enter User ID: ");
        String enteredId = scanner.nextLine();
        System.out.print("Enter PIN: ");
        String enteredPin = scanner.nextLine();

        return userId.equals(enteredId) && userPin.equals(enteredPin);
    }

    private void showMenu() {
        int choice;
        do {
            System.out.println("\n--- ATM Menu ---");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. View Transaction History");
            System.out.println("5. Change PIN");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            try {
                choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        checkBalance();
                        break;
                    case 2:
                        deposit();
                        break;
                    case 3:
                        withdraw();
                        break;
                    case 4:
                        viewTransactionHistory();
                        break;
                    case 5:
                        changePin();
                        break;
                    case 6:
                        System.out.println("Thank you for using the ATM. Goodbye! 👋");
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();
                choice = 0;
            }
        } while (choice != 6);
    }
    
    private void changePin() {
        System.out.print("Enter your current PIN for verification: ");
        String currentPin = scanner.nextLine();

        if (this.userPin.equals(currentPin)) {
            System.out.print("Enter your new PIN: ");
            String newPin = scanner.nextLine();
            System.out.print("Confirm your new PIN: ");
            String confirmPin = scanner.nextLine();

            if (newPin.equals(confirmPin)) {
                if (newPin.length() >= 4 && newPin.matches("\\d+")) {
                    this.userPin = newPin;
                    System.out.println("PIN changed successfully!");
                    userAccount.addTransactionNote("User changed their PIN.");
                } else {
                    System.out.println("Invalid PIN format. PIN must be at least 4 digits.");
                }
            } else {
                System.out.println("PINs do not match. Please try again.");
            }
        } else {
            System.out.println("Incorrect current PIN. Action cancelled.");
        }
    }


    private void checkBalance() {
        System.out.printf("Your current balance is: $%.2f\n", userAccount.getBalance());
    }

    private void deposit() {
        System.out.print("Enter amount to deposit: ");
        try {
            double amount = scanner.nextDouble();
            scanner.nextLine(); 
            userAccount.deposit(amount);
        } catch (Exception e) {
            System.out.println("Invalid amount. Please enter a valid number.");
            scanner.nextLine();
        }
    }

    private void withdraw() {
        System.out.print("Enter amount to withdraw: ");
        try {
            double amount = scanner.nextDouble();
            scanner.nextLine();
            userAccount.withdraw(amount);
        } catch (Exception e) {
            System.out.println("Invalid amount. Please enter a valid number.");
            scanner.nextLine();
        }
    }

    private void viewTransactionHistory() {
        userAccount.printTransactionHistory();
    }
}