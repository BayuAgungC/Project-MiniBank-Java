import java.util.Scanner;

public class User extends Person {
    private Account account;

    public User(String name, String address, String password, Account account) {
        super(name, address, password);
        this.account = account;
    }

    public void deposit() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter deposit amount: ");
        double amount = scanner.nextDouble();
        account.deposit(amount, "Deposit");
        System.out.println("Deposit successful. New balance: " + account.getBalance());
    }

    public void withdraw() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter withdrawal amount: ");
        double amount = scanner.nextDouble();
        if (amount > account.getBalance()) {
            System.out.println("Insufficient funds.");
        } else {
            account.withdraw(amount, "Withdrawal");
            System.out.println("Withdrawal successful. New balance: " + account.getBalance());
        }
    }

    public void viewOwnInfo() {
        System.out.println("Name: " + getName());
        System.out.println("Address: " + getAddress());
        System.out.println("Account Number: " + account.getAccountNumber());
        System.out.println("Balance: " + account.getBalance());
    }

    public void viewTransactionHistory() {
        for (Transaction transaction : account.getTransactions()) {
            // Tampilkan riwayat transaksi sendiri
        }
    }

    public void viewBalance() {
        System.out.println("Your current balance: " + account.getBalance());
    }

    public Account getAccount() {
        return account;
    }

}
