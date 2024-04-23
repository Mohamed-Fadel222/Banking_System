import java.util.Scanner;

public class LoanProcessing {

    int LoanId;
    String term;
    String status; // approved, rejected, etc.
    boolean IsRateFixed; // If false, then variable
    double rate;
    String Purpose;
    Customer customer;

    public LoanProcessing(Customer customer) {
        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void ApplyForLoan(Customer customer, double rate, boolean ratetype, String Term, String Purpose) {
        // Check eligibility before applying for a loan
        if (CheckEligibility(customer, rate, ratetype, Term, Purpose)) {
            // Proceed with loan application
            this.customer = customer;
            this.rate = rate;
            this.IsRateFixed = ratetype;
            this.term = Term;
            this.Purpose = Purpose;
            this.status = "Pending"; // Assume loan application status starts as pending
            System.out.println("Loan application submitted successfully.");
        } else {
            System.out.println("Sorry, you are not eligible for the loan.");
        }
    }

	public double CalculateInterest(Customer customer, double rate, boolean ratetype) {
		double interest = 0.0;
		// Calculate interest based on customer's account balance and the loan rate
		double accountBalance = customer.getAccount().getInitialBalance();

		if (ratetype) {
			// Fixed rate
			interest = rate * accountBalance;
		} else {
			// Variable rate (for demonstration purposes, let's assume a simple calculation)
			// Assuming variable rate as 2% of account balance
			interest = 0.02 * accountBalance;
		}

		return interest;
	}


	public boolean CheckEligibility(Customer customer, double rate, boolean ratetype, String Term, String Purpose) {
		// Basic eligibility criteria: check account balance
		double minBalance = 1000.0; // Minimum balance required for eligibility (assumed value)

		if (customer.getAccount().getInitialBalance() >= minBalance) {
			// Customer meets the minimum balance requirement
			return true;
		} else {
			// Customer does not meet the minimum balance requirement
			return false;
		}
	}


}
