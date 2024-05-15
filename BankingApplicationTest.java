import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

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
        assertEquals(1000, balance, 0.01);
    }

    @Test
    public void testDepositIntoExistingAccount() {
        // Test depositing into an existing account
        bankingApp.createAccount("1234567890", 1000.0);
        bankingApp.deposit("1234567890", 500.0);
        double balance = bankingApp.checkBalance("1234567890");
        assertEquals(1500.0, balance, 0.01);
    }

    @Test
    public void testWithdrawFromExistingAccount() {
        // Test withdrawing from an existing account
        bankingApp.createAccount("1234567890", 1000.0);
        bankingApp.withdraw("1234567890", 500.0);
        double balance = bankingApp.checkBalance("1234567890");
        assertEquals(500.0, balance, 0.01);
    }

    @Test
    public void testTransferBetweenAccounts() {
        // Test transferring funds from one account to another
        bankingApp.createAccount("1234567890", 2000.0);
        bankingApp.createAccount("0987654321", 1000.0);

        bankingApp.transfer("1234567890", "0987654321", 500.0);

        double fromBalance = bankingApp.checkBalance("1234567890");
        double toBalance = bankingApp.checkBalance("0987654321");

        assertEquals(1500.0, fromBalance, 0.01);
        assertEquals(1500.0, toBalance, 0.01);
    }

    @After
    public void tearDown() {
        // Clean up resources after each test
    }

    @AfterClass
    public static void tearDownAll() {
        // Clean up resources once after all tests have been executed
    }

    // Class definition for BankingApplication
    private class BankingApplication {
        private Map<String, Double> accounts;

        public BankingApplication() {
            this.accounts = new HashMap<>();
        }

        public void createAccount(String accountNumber, double initialBalance) {
            if (!accounts.containsKey(accountNumber)) {
                accounts.put(accountNumber, initialBalance);
            }
        }

        public double checkBalance(String accountNumber) {
            return accounts.getOrDefault(accountNumber, 0.0);
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

        public void transfer(String fromAccount, String toAccount, double amount) {
            if (accounts.containsKey(fromAccount) && accounts.containsKey(toAccount)) {
                double fromBalance = accounts.get(fromAccount);
                double toBalance = accounts.get(toAccount);
                if (fromBalance >= amount) {
                    accounts.put(fromAccount, fromBalance - amount);
                    accounts.put(toAccount, toBalance + amount);
                } else {
                    System.out.println("Insufficient balance to transfer " + amount);
                }
            } else {
                System.out.println("One or both accounts do not exist.");
            }
        }
    }
}
