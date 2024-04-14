import java.util.ArrayList;
import java.util.Scanner;

public class BankAccount
{

    String AccountType;
    double InitialBalance;

    ArrayList<Transactions> transactions ;//Transaction Log

    public BankAccount(String accountType,double initialBalance) {
        AccountType = accountType;
        transactions = new ArrayList<>();
        InitialBalance   = initialBalance;
    }

    public String getAccountType() {
        return AccountType;
    }

    public void setAccountType(String accountType) {
        AccountType = accountType;
    }

    public double getInitialBalance() {
        return InitialBalance;
    }

    public void setInitialBalance(double initialBalance) {
        InitialBalance = initialBalance;
    }

    public void PerformTransaction( String TransactionType, double amount){
Transactions currenttransaction;
        if(TransactionType.equals("deposit")){
            InitialBalance+= amount;
            currenttransaction = new Transactions(TransactionType, amount);
           transactions.add(currenttransaction);

        }
        if(TransactionType.equals("withdraw")){
            if(InitialBalance > amount) {


                InitialBalance -= amount;
                currenttransaction = new Transactions(TransactionType, amount);
                transactions.add(currenttransaction);
            }
            else{
                System.out.println("Insufficient amount for withdrawal");
            }
        }
       if(TransactionType.equals("transfer"))
       {

           Scanner scanner = new Scanner(System.in);
           String RecipientName = scanner.nextLine().toLowerCase(); // = (Name taken from input in GUI, make sure it to use .toLowerCase() after


           Customer recipient = new Customer();


           if(InitialBalance >= amount)
           {
               if(Customer.logininfo.containsKey(RecipientName))
               {
                   recipient.getCustomerByName(RecipientName).deposit(amount);
                   InitialBalance -= amount;
                   currenttransaction = new Transactions(TransactionType, amount);
                   transactions.add(currenttransaction);
                   System.out.println("Success");
               }
               else
                   System.out.println("Customer not Found");

           } else
           {
               System.out.println("Insufficient funds");
           }
       }
       {

       }

    }



}
/*
TODO:
 PerformTransaction(Transactions transaction, double amount);
 GetTransactionHistory()
 DisplayAccountDetails()
 */
