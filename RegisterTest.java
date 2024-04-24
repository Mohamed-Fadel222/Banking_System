import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RegisterTest {

    private Register register;

    @BeforeEach
    public void setUp() {
        register = new Register();
    }

    @Test
    public void testRegisterAccount_NewUsername() {

        register.RegisterAccount("johndoe", "John", "Doe", "password", "1234567890", "123 Main St", "Savings", 1000.0);
        assertEquals(1, Customer.customers.size());
        assertTrue(Customer.logininfo.containsKey("johndoe"));
    }

    @Test
    public void testRegisterAccount_ExistingUsername() {

        Customer existingCustomer = new Customer("John", "Doe", "johndoe", "password", "1234567890", "123 Main St", "Savings", 1000.0);
        Customer.customers.add(existingCustomer);
        Customer.logininfo.put("johndoe", "password");

        register.RegisterAccount("johndoe", "Jane", "Smith", "newpassword", "9876543210", "456 Elm St", "Checking", 2000.0);
        assertEquals(1, Customer.customers.size());
    }
}
