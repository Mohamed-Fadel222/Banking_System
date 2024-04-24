public class Register {

    public Register() {}

    public void RegisterAccount(String username, String fName, String lName, String password, String phoneNo, String address, String accountType, double initialBalance) {
        if (!Customer.logininfo.containsKey(username.toLowerCase())) {
            BankAccount account = new BankAccount(accountType, initialBalance);
            Customer newCustomer = new Customer(fName, lName, username.toLowerCase(), password, phoneNo, address, accountType, initialBalance);
            newCustomer.setAccount(account);
            Customer.customers.add(newCustomer);
            Customer.logininfo.put(username.toLowerCase(), password);
            newCustomer.setID(newCustomer.getID());
        } else {
            System.out.println("Username already registered");
        }
    }
}
