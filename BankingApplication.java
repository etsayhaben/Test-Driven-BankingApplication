
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
//checking balance fixed
    public double checkBalance(String accountNumber) {
        return accounts.getOrDefault(accountNumber, 0.0);
    }
    

    public static void main(String args[]) {
        new BankingApplication();
    }

}
