import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LoanProcessingTest {

    private Customer customer;
    private LoanProcessing loanProcessing;

    @BeforeEach
    public void setUp() {
        customer = new Customer("John", "Doe", "johndoe", "password", "1234567890", "123 Main St", "Savings", 1500.0);
        loanProcessing = new LoanProcessing(customer);
    }

    @Test
    public void testApplyForLoan_Eligible() {
        loanProcessing.ApplyForLoan(customer, 5.0, true, "5 years", "Education");
        assertEquals("Pending", loanProcessing.status);
    }

    @Test
    public void testApplyForLoan_Ineligible() {
        // Set initial balance below the minimum required for eligibility
        customer.getAccount().setInitialBalance(500.0);
        loanProcessing.ApplyForLoan(customer, 5.0, true, "5 years", "Education");
        assertNotEquals("Pending", loanProcessing.status);
    }

    @Test
    public void testCheckEligibility_Eligible() {
        assertTrue(loanProcessing.CheckEligibility(customer, 5.0, true, "5 years", "Education"));
    }

    @Test
    public void testCheckEligibility_Ineligible() {
        // Set initial balance below the minimum required for eligibility
        customer.getAccount().setInitialBalance(500.0);
        assertFalse(loanProcessing.CheckEligibility(customer, 5.0, true, "5 years", "Education"));
    }
}
