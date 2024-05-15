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
        bankingApp.createAccount("1234567890", 1000.0);
        double balance = bankingApp.checkBalance("1234567890");
        assertEquals(1000.0, balance, 0.01);
    }

    @Test
    public void testCreateAccountWithExistingAccountNumber() {
        bankingApp.createAccount("1234567890", 1000.0);
        bankingApp.createAccount("1234567890", 2000.0);
        double balance = bankingApp.checkBalance("1234567890");
        assertEquals(1000.0, balance, 0.01);
    }

    @Test
    public void testCheckBalanceOfExistingAccount() {
        bankingApp.createAccount("1234567890", 1000.0);
        double balance = bankingApp.checkBalance("1234567890");
        assertEquals(1000.0, balance, 0.01);
    }

    @Test
    public void testCheckBalanceOfNonExistingAccount() {
        double balance = bankingApp.checkBalance("1234567890");
        assertEquals(0, balance, 0.01);
    }

    @Test
    public void testCloseExistingAccount() {
        bankingApp.createAccount("1234567890", 1000.0);
        bankingApp.closeAccount("1234567890");
        double balance = bankingApp.checkBalance("1234567890");
        assertEquals(0.0, balance, 0.01);
    }

    @Test
    public void testCloseNonExistingAccount() {
        bankingApp.closeAccount("1234567890");
        double balance = bankingApp.checkBalance("1234567890");
        assertEquals(0.0, balance, 0.01);
    }

    @After
    public void tearDown() {
        // Clean up resources after each test
    }

    @AfterClass
    public static void tearDownAll() {
        // Clean up resources once after all tests have been executed
    }
}