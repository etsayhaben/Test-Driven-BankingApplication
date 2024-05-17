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

    @Test
    // test deposit postive amount into existing account
    public void testDepositintoExistingAccount() {
        bankingApp.createAccount("1234567890", 0.0);
        bankingApp.deposit("1234567890", 500.0);
        assertEquals(500, bankingApp.checkBalance("1234567890"), 0.01);
    }

    @Test
    public void testDepositNullAccountNumber() {
        // Test depositing money into an account with a null account number
        bankingApp.deposit(null, 500.0);
        assertNull(bankingApp.checkBalance(null));
        fail("Depositing money into an account with a not existing account number should throw an exception");
    }

    @Test
    public void testDepositNegativeAmount() {
        // Test depositing a negative amount into an account
        bankingApp.createAccount("1234567890", 1000.0);
        bankingApp.deposit("1234567890", -500.0);
        assertNotNull(bankingApp.checkBalance("1234567890"));
        assertEquals(1000.0, bankingApp.checkBalance("1234567890"), 0.01);
        fail("Depositing a negative amount into an account should throw an exception");
    }

    @Test
    public void testWithdraw() {

        String accountNumber = "1234567890";
        bankingApp.createAccount("1234567890", 1000.0);
        bankingApp.deposit(accountNumber, 1000.0);

        // Test withdrawing money from the existing account
        bankingApp.withdraw(accountNumber, 500.0);

        // Check if the balance is correct after withdrawal
        assertEquals(500.0, bankingApp.checkBalance(accountNumber));
    }
    @Test
public void testTransferNullSenderAccountNumber() {
    // Test transferring money from a null sender account number
    bankingApp.createAccount("0987654321", 500.0);
    bankingApp.transfer(null, "0987654321", 300.0);
    assertNull(bankingApp.checkBalance(null));
    assertNotNull(bankingApp.checkBalance("0987654321"));
    assertEquals(500.0, bankingApp.checkBalance("0987654321"), 0.01);
    fail("Transferring money from a null sender account number should throw an exception");
}
}
