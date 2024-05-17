import java.util.HashMap;
import java.util.Map;

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

}
