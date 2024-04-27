import java.util.Scanner;

public class LoanProcessing {

    int LoanId;
    String term;
    String status; 
    boolean IsRateFixed; 
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
        if (CheckEligibility(customer, rate, ratetype, Term, Purpose)) {
            this.customer = customer;
            this.rate = rate;
            this.IsRateFixed = ratetype;
            this.term = Term;
            this.Purpose = Purpose;
            this.status = "Pending";
            System.out.println("Loan application submitted successfully.");
        } else {
            System.out.println("Sorry, you are not eligible for the loan.");
        }
    }




	public boolean CheckEligibility(Customer customer, double rate, boolean ratetype, String Term, String Purpose) {
		double minBalance = 1000.0;

		if (customer.getAccount().getInitialBalance() >= minBalance) {
		
			return true;
		} else {
			
			return false;
		}
	}


}
