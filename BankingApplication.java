import java.util.HashMap;
import java.util.Map;

import javax.security.auth.login.AccountNotFoundException;

public class BankingApplication {
    private Map<String, Double> accounts;

    public BankingApplication() {
        accounts = new HashMap<>();
    }

    public static void main(String args[]) {
        new BankingApplication();
    }

    public void createAccount(String accountNumber, double initialBalance) {
        if (!accounts.containsKey(accountNumber)) {
            accounts.put(accountNumber, initialBalance);
        }
    }

    public double checkBalance(String accountNumber) throws Exception {
        if (accounts.containsKey(accountNumber)) {
            return accounts.get(accountNumber);
        } else {
            throw new Exception("Account does not exist.");
        }
    }

    // Method to deposit money
    public void deposit(String accountNumber, double amount) {
        if (accounts.containsKey(accountNumber)) {
            double currentBalance = accounts.get(accountNumber);
            currentBalance += amount;
            accounts.put(accountNumber, currentBalance);
            System.out.println("Deposit successful.");
        } else {
            System.out.println("Account does not exist.");
        }
    }

    // Method to withdraw money
    public void withdraw(String accountNumber, double amount) {
        if (accounts.containsKey(accountNumber)) {
            double currentBalance = accounts.get(accountNumber);
            if (currentBalance >= amount) {
                currentBalance -= amount;
                accounts.put(accountNumber, currentBalance);
                System.out.println("Withdrawal successful.");
            } else {
                System.out.println("Insufficient balance.");
            }
        } else {
            System.out.println("Account does not exist.");
        }
    }

    // method to transfer from one account to another account
    public void transfer(String senderAccountNumber, String receiverAccountNumber, double amount) throws Exception {
        if (senderAccountNumber == null) {
            throw new NullPointerException("Sender's account number cannot be null");
        }
        if (receiverAccountNumber == null) {
            throw new NullPointerException("Receiver's account number cannot be null");
        }
        if (amount <= 0) {
            throw new IllegalArgumentException("Transfer amount must be greater than zero");
        }

        double senderBalance = checkBalance(senderAccountNumber);
        if (senderBalance < amount) {
            throw new Exception("Insufficient balance in sender's account");
        }

        // Subtract the amount from the sender's account
        updateBalance(senderAccountNumber, senderBalance - amount);

        // Add the amount to the receiver's account
        double receiverBalance = checkBalance(receiverAccountNumber);
        updateBalance(receiverAccountNumber, receiverBalance + amount);

    }

    private void updateBalance(String accountNumber, double newBalance) throws Exception {
        // Assuming accounts is a Map that stores account numbers as keys and their
        // balances as values
        if (accounts.containsKey(accountNumber)) {
            accounts.put(accountNumber, newBalance);
        } else {
            throw new Exception("Account not found");
        }
    }

}
