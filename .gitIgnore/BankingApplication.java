import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BankingApplication {
    private static Map<String, Double> accounts;

    public static void main(String[] args) {
        accounts = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        boolean isRunning = true;
        while (isRunning) {
            System.out.println("Welcome to the Banking Application!");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. Close Account");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    createAccount(scanner);
                    break;
                case 2:
                    deposit(scanner);
                    break;
                case 3:
                    withdraw(scanner);
                    break;
                case 4:
                    checkBalance(scanner);
                    break;
                case 5:
                    closeAccount(scanner);
                    break;
                case 6:
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }

        System.out.println("Thank you for using the Banking Application!");
        scanner.close();
    }

    private static void createAccount(Scanner scanner) {
        System.out.print("Enter the account number: ");
        String accountNumber = scanner.next();
        System.out.print("Enter the initial balance: ");
        double initialBalance = scanner.nextDouble();

        if (!accounts.containsKey(accountNumber)) {
            accounts.put(accountNumber, initialBalance);
            System.out.println("Account created successfully.");
        } else {
            System.out.println("Account already exists with the given account number.");
        }
    }

    private static void deposit(Scanner scanner) {
        System.out.print("Enter the account number: ");
        String accountNumber = scanner.next();
        System.out.print("Enter the amount to deposit: ");
        double amount = scanner.nextDouble();

        if (accounts.containsKey(accountNumber)) {
            double currentBalance = accounts.get(accountNumber);
            accounts.put(accountNumber, currentBalance + amount);
            System.out.println("Deposit successful.");
        } else {
            System.out.println("Account does not exist with the given account number.");
        }
    }

    private static void withdraw(Scanner scanner) {
        System.out.print("Enter the account number: ");
        String accountNumber = scanner.next();
        System.out.print("Enter the amount to withdraw: ");
        double amount = scanner.nextDouble();

        if (accounts.containsKey(accountNumber)) {
            double currentBalance = accounts.get(accountNumber);
            if (currentBalance >= amount) {
                accounts.put(accountNumber, currentBalance - amount);
                System.out.println("Withdrawal successful.");
            } else {
                System.out.println("Insufficient balance in the account.");
            }
        } else {
            System.out.println("Account does not exist with the given account number.");
        }
    }

    private static void checkBalance(Scanner scanner) {
        System.out.print("Enter the account number: ");
        String accountNumber = scanner.next();

        if (accounts.containsKey(accountNumber)) {
            double balance = accounts.get(accountNumber);
            System.out.println("Current balance: " + balance);
        } else {
            System.out.println("Account does not exist with the given account number.");
        }
    }

    private static void closeAccount(Scanner scanner) {
        System.out.print("Enter the account number: ");
        String accountNumber = scanner.next();

        if (accounts.containsKey(accountNumber)) {
            accounts.remove(accountNumber);
            System.out.println("Account closed successfully.");
        } else {
            System.out.println("Account does not exist with the given account number.");
        }
    }
}