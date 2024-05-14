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

    @Test
    public void testCreateAccountWithExistingAccountNumber() {
        // Test creating an account with an existing account number
        // The account creation should fail and maintain the original balance
        bankingApp.createAccount("1234567890", 1000.0);
        bankingApp.createAccount("1234567890", 2000.0);
        double balance = bankingApp.checkBalance("1234567890");
        assertEquals(1000.0, balance, 0.01);
    }

    @Test
    public void testDepositIntoExistingAccount() {
        // Test depositing into an existing account
        bankingApp.createAccount("1234567890", 1000.0);
        bankingApp.deposit("1234567890", 500.0);
        double balance = bankingApp.checkBalance("1234567890");
        assertEquals(1500.0, balance, 0.01);
        assertNotNull(bankingApp.checkBalance("1234567890"));
    }

    @Test
    public void testDepositIntoNonExistingAccount() {
        bankingApp.deposit("1234567890", 500.0);
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