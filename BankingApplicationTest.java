import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

import static org.junit.Assert.*;

public class BankingApplicationTest {
    private BankingApplication bankingApp;
    private static int passedTests = 0;
    private static int failedTests = 0;
    @Rule
    public TestWatcher testWatcher = new TestWatcher() {
        @Override
        protected void succeeded(Description description) {
            passedTests++;
        }

        @Override
        protected void failed(Throwable e, Description description) {
            failedTests++;
        }
    };

    @Before
    public void setUp() {
        bankingApp = new BankingApplication();
    }

    @AfterClass
    public static void afterAllTests() {
        System.out.println("Number of passed tests: " + passedTests);
        System.out.println("Number of failed tests: " + failedTests);
    }

    // test create Account with intial balance
    @Test
    public void testCreateAccountWithInitialBalance() throws Exception {
        // Test creating an account with an initial balance
        bankingApp.createAccount("1234567890", 1000.0);
        double balance = bankingApp.checkBalance("1234567890");
        assertEquals(1000.0, balance, 0);
    }

    // test for transfer negative amount
    @Test
    public void testTransferNegativeAmount() {
        // Test transferring a negative amount between accounts
        bankingApp.createAccount("1234567890", 1000.0);
        bankingApp.createAccount("0987654321", 500.0);
        // // Attempt to transfer a negative amount should throw an
        // IllegalArgumentException

        bankingApp.transfer("1234567890", "0987654321", -300.0);
        assertEquals(1000.0, bankingApp.checkBalance("1234567890"), 0);
        assertEquals(500.0, bankingApp.checkBalance("0987654321"), 0);
    }

    // test for creating account with negative initial Balance
    @Test

    public void testCreateAccountNegativeInitialBalance() {
        // Test creating an account with a negative initial balance
        boolean result = bankingApp.createAccount("1234567890", -1000.0);
        assertFalse(result);

    }

    @Test
    public void testCloseAccount_AccountExists() {
        boolean result = bankingApp.createAccount("1234567890", 1000.0);
        assertTrue(result);
        assertTrue(bankingApp.closeAccount("1234567890"));
        assertNull(bankingApp.accounts.get("1234567890"));
        // Verifies that an existing account can be closed successfully.
    }
    import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

import static org.junit.Assert.*;

public class BankingApplicationTest {
    private BankingApplication bankingApp;
    private static int passedTests = 0;
    private static int failedTests = 0;
    @Rule
    public TestWatcher testWatcher = new TestWatcher() {
        @Override
        protected void succeeded(Description description) {
            passedTests++;
        }

        @Override
        protected void failed(Throwable e, Description description) {
            failedTests++;
        }
    };

    @Before
    public void setUp() {
        bankingApp = new BankingApplication();
    }

    @AfterClass
    public static void afterAllTests() {
        System.out.println("Number of passed tests: " + passedTests);
        System.out.println("Number of failed tests: " + failedTests);
    }

    // test create Account with intial balance
    @Test
    public void testCreateAccountWithInitialBalance() throws Exception {
        // Test creating an account with an initial balance
        bankingApp.createAccount("1234567890", 1000.0);
        double balance = bankingApp.checkBalance("1234567890");
        assertEquals(1000.0, balance, 0);
    }

    // test for transfer negative amount
    @Test
    public void testTransferNegativeAmount() {
        // Test transferring a negative amount between accounts
        bankingApp.createAccount("1234567890", 1000.0);
        bankingApp.createAccount("0987654321", 500.0);
        // // Attempt to transfer a negative amount should throw an
        // IllegalArgumentException

        bankingApp.transfer("1234567890", "0987654321", -300.0);
        assertEquals(1000.0, bankingApp.checkBalance("1234567890"), 0);
        assertEquals(500.0, bankingApp.checkBalance("0987654321"), 0);
    }

    // test for creating account with negative initial Balance
    @Test

    public void testCreateAccountNegativeInitialBalance() {
        // Test creating an account with a negative initial balance
        boolean result = bankingApp.createAccount("1234567890", -1000.0);
        assertFalse(result);

    }

    @Test
    public void testCloseAccount_AccountExists() {
        boolean result = bankingApp.createAccount("1234567890", 1000.0);
        assertTrue(result);
        assertTrue(bankingApp.closeAccount("1234567890"));
        assertNull(bankingApp.accounts.get("1234567890"));
        // Verifies that an existing account can be closed successfully.
    }

    @Test
    public void testCloseAccount_AccountDoesNotExist() {
        assertFalse(bankingApp.closeAccount("1234567890"));
        // Verifies that attempting to close a non-existent account returns false.
    }

    // test for creating account with null account number
    @Test

    public void testCreateAccountNullAccountNumber() {
        // Test creating an account with a null account number
        bankingApp.createAccount(null, 1000.0);
        assertFalse(bankingApp.createAccount(null, 1000));
    }

    @Test // test check balance for existing account
    public void testCheckBalance() throws Exception {
        BankingApplication bankingApp = new BankingApplication();
        bankingApp.createAccount("1234567890", 1000.0);
        assertEquals(1000.0, bankingApp.checkBalance("1234567890"), 0.01);
    }

    @Test
    // test deposit postive amount into existing account
    public void testDepositintoExistingAccount() {
        assertTrue(bankingApp.createAccount("1234567890", 1000.0));
        bankingApp.deposit("1234567890", 500.0);
        assertEquals(1500, bankingApp.checkBalance("1234567890"), 0);
    }

    // test for depositing null account number
    @Test
    public void testDepositNullAccountNumber() {
        // Test depositing money into an account with a null account number
        assertFalse(bankingApp.deposit(null, 500.0));
    }

    // testing depositing negative amount into an account
    @Test
    public void testDepositNegativeAmount() {
        // Test depositing a negative amount into an account
        assertTrue(bankingApp.createAccount("1234567890", 1000.0));
        boolean result = bankingApp.deposit("1234567890", -500.0);
        assertFalse(result);
    }

    // testing to withdraw money
    @SuppressWarnings("deprecation")
    @Test
    public void testWithdraw() throws Exception {

        String accountNumber = "1234567890";
        bankingApp.createAccount("1234567890", 1000.0);
        bankingApp.deposit(accountNumber, 1000.0);

        // Test withdrawing money from the existing account
        bankingApp.withdraw(accountNumber, 500.0);

        // Check if the balance is correct after withdrawal
        assertEquals(1500.0, bankingApp.checkBalance(accountNumber), 0);
    }

}

   
    // test for creating account with null account number
    @Test

    public void testCreateAccountNullAccountNumber() {
        // Test creating an account with a null account number
        bankingApp.createAccount(null, 1000.0);
        assertFalse(bankingApp.createAccount(null, 1000));
    }

    @Test // test check balance for existing account
    public void testCheckBalance() throws Exception {
        BankingApplication bankingApp = new BankingApplication();
        bankingApp.createAccount("1234567890", 1000.0);
        assertEquals(1000.0, bankingApp.checkBalance("1234567890"), 0.01);
    }

    @Test
    // test deposit postive amount into existing account
    public void testDepositintoExistingAccount() {
        assertTrue(bankingApp.createAccount("1234567890", 1000.0));
        bankingApp.deposit("1234567890", 500.0);
        assertEquals(1500, bankingApp.checkBalance("1234567890"), 0);
    }

    // test for depositing null account number
    @Test
    public void testDepositNullAccountNumber() {
        // Test depositing money into an account with a null account number
        assertFalse(bankingApp.deposit(null, 500.0));
    }

    // testing depositing negative amount into an account
    @Test
    public void testDepositNegativeAmount() {
        // Test depositing a negative amount into an account
        assertTrue(bankingApp.createAccount("1234567890", 1000.0));
        boolean result = bankingApp.deposit("1234567890", -500.0);
        assertFalse(result);
    }

    // testing to withdraw money
    @SuppressWarnings("deprecation")
    @Test
    public void testWithdraw() throws Exception {

        String accountNumber = "1234567890";
        bankingApp.createAccount("1234567890", 1000.0);
        bankingApp.deposit(accountNumber, 1000.0);

        // Test withdrawing money from the existing account
        bankingApp.withdraw(accountNumber, 500.0);

        // Check if the balance is correct after withdrawal
        assertEquals(1500.0, bankingApp.checkBalance(accountNumber), 0);
    }

}
