import java.util.Scanner;

public class Admin extends Person {
    private Bank bank;

    public Admin(String name, String address, String password, Bank bank) {
        super(name, address, password);
        this.bank = bank;
    }

    public void addCustomer() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter customer name: ");
        String name = scanner.next();
        System.out.print("Enter customer address: ");
        String address = scanner.next();
        System.out.print("Enter customer password: ");
        String password = scanner.next();

        // ... tambahkan input untuk informasi tambahan yang dibutuhkan ...

        // Generate account number secara otomatis (sesuai dengan kebutuhan)
        int accountNumber = bank.generateAccountNumber();

        // Tambahkan nasabah baru ke bank
        User newUser = new User(name, address, password, new UserAccount(accountNumber, 0.0, new User(name, address, password, new Account(accountNumber, 0.0))));
        bank.addAccount(newUser.getAccount());

        System.out.println("Customer added successfully. Account Number: " + accountNumber);
    }

    public void viewCustomerDetails(User user) {
        System.out.println("Customer Name: " + user.getName());
        System.out.println("Customer Address: " + user.getAddress());
        System.out.println("Account Number: " + user.getAccount().getAccountNumber());
        System.out.println("Account Balance: " + user.getAccount().getBalance());

        // Tambahan informasi sesuai kebutuhan
    }

    public void viewAllCustomers() {
        for (Account account : bank.getAccounts()) {
            if (account instanceof UserAccount) {
                User user = ((UserAccount) account).getUser();
                viewCustomerDetails(user);
                System.out.println("=============================");
            }
        }
    }

    public void addCustomersLoop() {
        boolean continueAddingCustomers = true;
        while (continueAddingCustomers) {
            addCustomer();

            System.out.print("Do you want to add another customer? (1 for Yes, 0 for No): ");
            int continueChoice = new Scanner(System.in).nextInt();

            if (continueChoice == 0) {
                continueAddingCustomers = false;
            }
        }
    }
}
