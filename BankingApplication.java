import java.util.HashMap;
import java.util.Map;

public class BankingApplication {
    private Map<String, Double> accounts;

    public BankingApplication() {
        this.accounts = new HashMap<>();
    }

    // Method to create a new account
    public void createAccount(String accountNumber, double initialBalance) {
        if (!accounts.containsKey(accountNumber)) {
            accounts.put(accountNumber, initialBalance);
        }
    }

    // Method to check balance of an account
    public double checkBalance(String accountNumber) {
        return accounts.getOrDefault(accountNumber, 0.0);
    }

    // Method to withdraw funds from an account
    public void withdraw(String accountNumber, double amount) {
        if (accounts.containsKey(accountNumber)) {
            double currentBalance = accounts.get(accountNumber);
            if (currentBalance >= amount) {
                accounts.put(accountNumber, currentBalance - amount);
            }
        }
    }

    // Method to deposit funds into an account
    public void deposit(String accountNumber, double amount) {
        if (accounts.containsKey(accountNumber)) {
            double currentBalance = accounts.get(accountNumber);
            accounts.put(accountNumber, currentBalance + amount);
        }
    }

    // Method to close an account
    public void closeAccount(String accountNumber) {
        accounts.remove(accountNumber);
    }

    // Method to transfer funds from one account to another
    public void transfer(String fromAccount, String toAccount, double amount) {
        if (accounts.containsKey(fromAccount) && accounts.containsKey(toAccount)) {
            double fromBalance = accounts.get(fromAccount);
            double toBalance = accounts.get(toAccount);
            if (fromBalance >= amount) {
                accounts.put(fromAccount, fromBalance - amount);
                accounts.put(toAccount, toBalance + amount);
            } else {
                System.out.println("Insufficient balance to transfer " + amount);
            }
        } else {
            System.out.println("One or both accounts do not exist.");
        }
    }

    public static void main(String args[]) {
        new BankingApplication();
    }
}
