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

    public void testCreateAccountNegativeInitialBalance() {
        // Test creating an account with a negative initial balance
        bankingApp.createAccount("1234567890", -1000.0);
        assertNotNull(bankingApp.checkBalance("1234567890"));
        assertEquals(0.0, bankingApp.checkBalance("1234567890"), 0.01);
        fail("Creating an account with a negative initial balance should throw an exception");
    }

    @Test

    public void testCreateAccountNullAccountNumber() {
        // Test creating an account with a null account number
        bankingApp.createAccount(null, 1000.0);
        assertNull(bankingApp.checkBalance(null));
        fail("Creating an account with a null account number should throw an exception");
    }

    @Test // test check balance for existing account
    public void testCheckBalance() {
        BankingApplication bankingApp = new BankingApplication();
        bankingApp.createAccount("1234567890", 1000.0);
        assertEquals(1000.0, bankingApp.checkBalance("1234567890"), 0.01);
    }

    @Test
    public void testCheckBalanceNullAccountNumber() {
        // Test checking the balance of an account with a null account number
        assertNull(bankingApp.checkBalance(null));
        fail("Checking the balance of an account with a null account number should throw an exception");
    }
}
