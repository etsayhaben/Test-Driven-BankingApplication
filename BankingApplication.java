
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

    public double checkBalance(String accountNumber) {
        try {
            if (accountNumber.startsWith('-'))
                ;

        }

        catch (Exception e) {
            throw new Exception("account number can not be negative");
        }
        return accounts.getOrDefault(accountNumber, 0.0);
    }

}
