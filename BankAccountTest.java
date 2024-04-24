import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class BankAccountTest {

    private BankAccount bankAccount;

    @BeforeAll
    public static void setUpBeforeClass() {
        System.out.println("Setting up before all tests...");
    }

    @BeforeEach
    public void setUp() {
        bankAccount = new BankAccount("Savings", 1000.0);
    }

    @Test
    @Order(1)
    public void testGetAccountType() {
        assertEquals("Savings", bankAccount.getAccountType());
    }

    @Test
    @Order(2)
    public void testSetAccountType() {
        bankAccount.setAccountType("Checking");
        assertEquals("Checking", bankAccount.getAccountType());
    }

    @Test
    @Order(3)
    public void testGetInitialBalance() {
        assertEquals(1000.0, bankAccount.getInitialBalance());
    }

    @Test
    @Order(4)
    public void testSetInitialBalance() {
        bankAccount.setInitialBalance(1500.0);
        assertEquals(1500.0, bankAccount.getInitialBalance());
    }

    @Test
    @Order(5)
    public void testPerformTransaction_Deposit() {
        bankAccount.PerformTransaction("deposit", 500.0);
        assertEquals(1500.0, bankAccount.getInitialBalance());
    }

    @Test
    @Order(6)
    public void testPerformTransaction_Withdraw() {
        bankAccount.PerformTransaction("withdraw", 300.0);
        assertEquals(700.0, bankAccount.getInitialBalance());
    }

    @Test
    @Order(7)
    public void testPerformTransaction_Transfer() {
        Customer recipient = new Customer("youssef", "mahmoud", "yo", "123", "0100398", "dff", "checking", 800);
        bankAccount.PerformTransaction("transfer", 200.0, recipient);
        assertEquals(1000.0, bankAccount.getInitialBalance());
    }

    @Test
    @Order(8)
    public void testPerformTransaction_Inquiry() {
        bankAccount.PerformTransaction("inquiry", 0.0);
        // No change in balance, so it should remain the same
        assertEquals(1000.0, bankAccount.getInitialBalance());
    }

    @AfterAll
    public static void tearDownAfterClass() {
        System.out.println("Test case sequence done");
    }
}
