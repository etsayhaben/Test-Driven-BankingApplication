Test Driven Banking Application
Introduction
The BankingApplication class provides methods for:
===Creating a new account
===Checking account balance
===Depositing money
===Withdrawing money
===Transferring money between accounts
===Closing an account
Requirements
Java Development Kit (JDK) 8 or later
JUnit 4 or later
Usage
Run the BankingApplicationTest class using an IDE like IntelliJ IDEA or Eclipse, or from the command line.
javac -cp .;lib/* BankingApplication.java BankingApplicationTest.java 
java -cp .;lib/* org.junit.runner.JUnitCore BankingApplicationTest
to compile
Test Cases
testCreateAccountWithInitialBalance: Verify account creation with initial balance.
testTransferNegativeAmount: Verify IllegalArgumentException for negative transfer.
testTransferNullReceiverAccountNumber: Verify NullPointerException for null receiver account.
testCreateAccountNegativeInitialBalance: Verify IllegalArgumentException for negative initial balance.
testCreateAccountNullAccountNumber: Verify NullPointerException for null account number.
testCheckBalance: Verify balance retrieval for existing account.
testCheckBalanceNullAccountNumber: Verify NullPointerException for null account number.
testDepositIntoExistingAccount: Verify deposit into existing account.
testDepositNullAccountNumber: Verify NullPointerException for null account number deposit.
testDepositNegativeAmount: Verify IllegalArgumentException for negative deposit.
testWithdraw: Verify money withdrawal from existing account.
testTransferNullSenderAccountNumber: Verify NullPointerException
