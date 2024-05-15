import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class BankingApplicationTest {
    private BankingApplication bankingApp;

    @Before
    public void setUp() {
        bankingApp = new BankingApplication();
    }

    @Test
    public void testCreateAccountWithInitialBalance() {
        // Test creating an account with an initial balance
        bankingApp.createAccount("1234567890", 1000.0);
        double balance = bankingApp.checkBalance("1234567890");
        assertEquals(1000.0, balance, 0.01);
    }

    public double checkBalance(String accountNumber) {
        return bankingApp.getOrDefault(accountNumber, 0.0);
    }

}