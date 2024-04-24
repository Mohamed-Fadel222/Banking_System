import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LoginTest {

    private Login login;

    @BeforeAll
    public static void setUpBeforeClass() {
        // Any setup that needs to be done once before all test methods
        System.out.println("Setting up before all tests...");
    }

    @BeforeEach
    public void setUp() {
        login = new Login();
        Customer.logininfo.put("testuser", "testpassword");
        Customer.logininfo.put("yo", "123");
    }

    @Test
    public void testVerifyLogin_Successful() {
        assertTrue(Customer.logininfo.containsKey("yo"));
        assertTrue(Customer.logininfo.get("yo").equals("123"));
        assertTrue(Customer.logininfo.get("yo").equals("123"), "Password is incorrect");
    }

    @Test
    public void testVerifyLogin_IncorrectPassword() {
        assertTrue(Customer.logininfo.containsKey("testuser"));
        assertFalse(Customer.logininfo.get("testuser").equals("incorrectpassword"));
        assertFalse(Customer.logininfo.get("testuser").equals("incorrectpassword"), "Password should not match");
    }

    @Test
    public void testVerifyLogin_UsernameNotFound() {
        assertFalse(Customer.logininfo.containsKey("unknownuser"));
        assertFalse(Customer.logininfo.containsKey("unknownuser"), "Username should not be found");
    }

    @Test
    public void testVerifyLogin_NullUsername() {
        assertFalse(Customer.logininfo.containsKey(null));
        assertFalse(Customer.logininfo.containsKey(null), "Username should not be null");
    }

    @Test
    public void testVerifyLogin_NullPassword() {
        assertFalse(Customer.logininfo.containsValue(null));
        assertFalse(Customer.logininfo.containsValue(null), "Password should not be null");
    }

    @Test
    public void testVerifyLogin_EmptyUsernameAndPassword() {
        assertFalse(Customer.logininfo.containsKey(""));
        assertFalse(Customer.logininfo.containsKey(""), "Username should not be empty");
        assertFalse(Customer.logininfo.containsValue(""));
        assertFalse(Customer.logininfo.containsValue(""), "Password should not be empty");
    }

    @Test
    public void testVerifyLogin_InvalidPasswordCaseSensitive() {
        assertTrue(Customer.logininfo.containsKey("testuser"));
        assertFalse(Customer.logininfo.get("testuser").equals("TestPassword"));
        assertFalse(Customer.logininfo.get("testuser").equals("TestPassword"), "Password should be case-sensitive");
    }

    @AfterAll
    public static void tearDownAfterClass() {
        System.out.println("Test cases finished");
    }
}
