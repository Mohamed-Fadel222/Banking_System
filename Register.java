public class Register {

    public Register() {}

    public Customer RegisterAccount(String username, String fName, String lName, String password, String phoneNo, String address, String accountType, double initialBalance) {
        if (!Customer.logininfo.containsKey(username.toLowerCase())) {
            BankAccount account = new BankAccount(accountType, initialBalance);
            Customer newCustomer = new Customer(fName, lName, username.toLowerCase(), password, phoneNo, address, accountType, initialBalance);
            newCustomer.setAccount(account);
            newCustomer.setID(newCustomer.getID());
            return newCustomer;
        } else {
            System.out.println("Username already registered");
            return null;
        }

    }
}
