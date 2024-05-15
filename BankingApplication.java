// this is the comment session of the code
import java.util.HashMap;
import java.util.Map;

public class BankingApplication {
    private Map<String, Double> accounts;

    public BankingApplication() {
        accounts = new HashMap<>();
    }

    public void createAccount(String accountNumber, double initialBalance) {
        if (!accounts.containsKey(accountNumber)) {
            accounts.put(accountNumber, initialBalance);
        }
    }

    public double checkBalance(String accountNumber) {
        return accounts.getOrDefault(accountNumber, 0);
    }

    public void withdraw(String accountNumber, double amount) {
        if (accounts.containsKey(accountNumber)) {
            double currentBalance = accounts.get(accountNumber);
            if (currentBalance >= amount) {
                accounts.put(accountNumber, currentBalance - amount);
            }
        }
    }

    public void deposit(String accountNumber, double amount) {
        if (accounts.containsKey(accountNumber)) {
            double currentBalance = accounts.get(accountNumber);
            accounts.put(accountNumber, currentBalance + amount);
        }
    }

    public void withdraw(String accountNumber, double amount) {
        if (accounts.containsKey(accountNumber)) {
            double currentBalance = accounts.get(accountNumber);
            if (currentBalance >= amount) {
                accounts.put(accountNumber, currentBalance - amount);
            }
        }
    }

    public void closeAccount(String accountNumber) {
        accounts.remove(accountNumber);
    }

    public static void main(String args[]) {
        new BankingApplication();
    }

}