import java.util.Scanner;

public class BankApp {
    public static void main(String[] args) {
        Bank bank = new Bank();

        // Inisialisasi admin dan user
        Admin admin = new Admin("admin", "Kantorbank", "adminpass", bank);
        User user = new User("lucifer", "isekai", "nasabahpass", new UserAccount(123, 1000.0, new User("lucifer", "isekai", "nasabahpass", new Account(123, 1000.0))));

        bank.addAccount(user.getAccount());

        // Login
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter username: ");
        String username = scanner.next();
        System.out.print("Enter password: ");
        String password = scanner.next();

        if (username.equals(admin.getName()) && password.equals("adminpass")) {
            // Admin login
            boolean continueAdminOperation = true;
            while (continueAdminOperation) {
                System.out.println("1. View All Customers");
                System.out.println("2. Add Customers");
                System.out.println("3. Exit");
                System.out.print("Choose an option: ");
                int adminChoice = scanner.nextInt();

                switch (adminChoice) {
                    case 1:
                        admin.viewAllCustomers();
                        break;
                    case 2:
                        admin.addCustomersLoop();
                        break;
                    case 3:
                        continueAdminOperation = false;
                        break;
                    default:
                        System.out.println("Invalid option.");
                }
            }
        } else if (username.equals(user.getName()) && password.equals("nasabahpass")) {
            // User login
            boolean continueTransaction = true;
            while (continueTransaction) {
                System.out.println("1. Deposit");
                System.out.println("2. Withdraw");
                System.out.println("3. View Transaction History");
                System.out.println("4. View Balance");
                System.out.print("Choose an option: ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        user.deposit();
                        break;
                    case 2:
                        user.withdraw();
                        break;
                    case 3:
                        user.viewTransactionHistory();
                        break;
                    case 4:
                        user.viewBalance();
                        break;
                    default:
                        System.out.println("Invalid option.");
                }

                System.out.print("Do you want to continue? (1 for Yes, 0 for No): ");
                int continueChoice = scanner.nextInt();

                if (continueChoice == 0) {
                    continueTransaction = false;
                }
            }
        } else {
            System.out.println("Invalid username or password");
        }

        scanner.close();
    }
}
