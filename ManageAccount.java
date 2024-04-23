public class ManageAccount
{
    Customer customer;

    public ManageAccount(Customer customer) {
        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void changePassword(String newPassword) {
        if (customer != null) {
            customer.setPassword(newPassword);
        } else {
            System.out.println("Error: Customer object is null.");
        }
    }


    public void changeUserName(String newUsername) {
        if (customer != null) {
            customer.setUsername(newUsername);
        } else {
            System.out.println("Error: Customer object is null.");
        }
    }

    public void changePhoneNumber(String newPhoneNumber) {
        if (customer != null) {
            customer.setPhoneNo(newPhoneNumber);
        } else {
            System.out.println("Error: Customer object is null.");
        }
    }


    public void changeFName(String newFName) {
        if (customer != null) {
            customer.setAddress(newFName);
        } else {
            System.out.println("Error: Customer object is null.");
        }
    }
    public void changeLName(String newLName) {
        if (customer != null) {
            customer.setAddress(newLName);
        } else {
            System.out.println("Error: Customer object is null.");
        }
    }

    public void changeAddress(String newAddress) {
        if (customer != null) {
            customer.setAddress(newAddress);
        } else {
            System.out.println("Error: Customer object is null.");
        }
    }

    /*
    TODO
     ChangePassword(String NewPassword)
     ChangeUserName(String NewUsername)
     ChangePhoneNumber(String number)
     ChangeAddress(String newaddress)
     */
}
