import java.util.HashMap;
import java.util.Map;

public class BankingApplication {
    Map<String, Double> accounts;

    public BankingApplication() {
        accounts = new HashMap<>();
    }

    public static void main(String args[]) {
        new BankingApplication();
    }

    public boolean createAccount(String accountNumber, double initialBalance) {
        if (!accounts.containsKey(accountNumber) && initialBalance > 0) {
            accounts.put(accountNumber, initialBalance);
            return true;
        } else
            return false;
    }

    public double checkBalance(String accountNumber) {
        if (accounts.containsKey(accountNumber))
            return accounts.get(accountNumber);
        else
            return -1.0;

    }

    // Method to deposit money
    public boolean deposit(String accountNumber, double amount) {
        if (accounts.containsKey(accountNumber) && amount >= 0) {
            double currentBalance = accounts.get(accountNumber);
            currentBalance += amount;
            accounts.put(accountNumber, currentBalance);
            return true;
        } else {
            return false;
        }
    }

    // Method to withdraw money
    public boolean withdraw(String accountNumber, double amount) {
        if (accounts.containsKey(accountNumber)) {
            double currentBalance = accounts.get(accountNumber);
            if (currentBalance >= amount) {
                currentBalance -= amount;
                accounts.put(accountNumber, currentBalance);
                return true;
            } else
                return false;
        } else
            return false;

    }

    // method to transfer from one account to another account
    public void transfer(String senderAccountNumber, String receiverAccountNumber, double amount) {
        if (senderAccountNumber == null) {
            System.out.print("sender account can not be null");
            return;
        }
        if (receiverAccountNumber == null) {
            System.out.print("reciver account can not be null");
            return;
        }
        if (amount <= 0) {
            System.out.print("amount can not be negative");
            return;
        }

        double senderBalance = checkBalance(senderAccountNumber);
        if (senderBalance < amount) {
            System.out.print("insufficent balance");
        }

        // Subtract the amount from the sender's account
        updateBalance(senderAccountNumber, senderBalance - amount);

        // Add the amount to the receiver's account
        double receiverBalance = checkBalance(receiverAccountNumber);
        updateBalance(receiverAccountNumber, receiverBalance + amount);

    }

    private void updateBalance(String accountNumber, double newBalance) {
        // Assuming accounts is a Map that stores account numbers as keys and their
        // balances as values
        if (accounts.containsKey(accountNumber)) {
            accounts.put(accountNumber, newBalance);
        } else {
            System.out.print("account can not found");
            return;
        }
    }

    public boolean closeAccount(String accountNumber) {
        if (accounts.containsKey(accountNumber)) {
            accounts.remove(accountNumber);
            return true;
        } else {
            return false;
        }
    }

}
