import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class CustomerTest {

    private Customer customer;
    private Customer recipient;

    @BeforeAll
    public static void setUpBeforeClass() {
        System.out.println("Setting up before all tests...");
    }

    @BeforeEach
    public void setUp() {
        customer = new Customer("John", "Doe", "johndoe", "password", "1234567890", "123 Main St", "Savings", 1000.0);
        recipient = new Customer("Recipient", "User", "recipientuser", "recipientpassword", "9876543210", "456 Elm St", "Checking", 2000.0);
        Customer.customers.add(customer);
        Customer.customers.add(recipient);
        Customer.logininfo.put(customer.getUsername(), customer.getPassword());
        Customer.logininfo.put(recipient.getUsername(), recipient.getPassword());
    }

    @Test
    @Order(1)
    public void testGetID() {
        assertNotNull(customer.getID());
    }

    @Test
    @Order(2)
    public void testGetFName() {
        assertEquals("John", customer.getFName());
    }

    @Test
    @Order(3)
    public void testGetLName() {
        assertEquals("Doe", customer.getLName());
    }

    @Test
    @Order(4)
    public void testGetUsername() {
        assertEquals("johndoe", customer.getUsername());
    }

    @Test
    @Order(5)
    public void testGetPhoneNo() {
        assertEquals("1234567890", customer.getPhoneNo());
    }

    @Test
    @Order(6)
    public void testGetAddress() {
        assertEquals("123 Main St", customer.getAddress());
    }

    @Test
    @Order(7)
    public void testDeposit() {
        customer.deposit(500.0);
        assertEquals(1500.0, customer.getAccount().getInitialBalance());
    }

    @Test
    @Order(8)
    public void testWithdraw() {
        customer.withdraw(300.0);
        assertEquals(700.0, customer.getAccount().getInitialBalance());
    }

    @Test
    @Order(9)
    public void testTransfer() {
        customer.transfer(200.0, recipient);
        assertEquals(800, customer.getAccount().getInitialBalance());
        assertEquals(2200, recipient.getAccount().getInitialBalance());
    }

    @Test
    @Order(10)
    public void testGetTransHistory() {
        String history = customer.gettranshistory();
        assertNotNull(history);
    }

    @Test
    @Order(11)
    public void testDisplayAccountDetails() {
        assertDoesNotThrow(() -> customer.displayaccountdetails());
    }

    @AfterAll
    public static void tearDownAfterClass() {
        System.out.println("Test finished");
    }
}
