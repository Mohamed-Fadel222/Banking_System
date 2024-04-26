import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ManageAccountTest {

    private ManageAccount manageAccount;
    private Customer customer;

    @BeforeEach
    void setUp() {
        customer = new Customer("Mohamed", "Hany", "hany", "password", "1234567890", "Cairo", "Savings", 1500.0);
        manageAccount = new ManageAccount(customer);
    }

    @Test
    void testChangePassword() {
        manageAccount.changePassword("123");
        assertEquals("123", customer.getPassword());
    }

    @Test
    void testChangeUserName() {
        manageAccount.changeUserName("MohamedHany");
        assertEquals("MohamedHany", customer.getUsername());
    }

    @Test
    void testChangePhoneNumber() {
        manageAccount.changePhoneNumber("0987654321");
        assertEquals("0987654321", customer.getPhoneNo());
    }

    @Test
    void testChangeAddress() {
        manageAccount.changeAddress("Giza");
        assertEquals("Giza", customer.getAddress());
    }


}