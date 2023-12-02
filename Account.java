import java.util.ArrayList;

public class Account {
    private int accountNumber;
    private double balance;
    private ArrayList<Transaction> transactions;

    public Account(int accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.transactions = new ArrayList<>();
    }

    public void deposit(double amount, String date) {
        balance += amount;
        transactions.add(new Transaction(amount, date));
    }

    public void withdraw(double amount, String date) {
        balance -= amount;
        transactions.add(new Transaction(-amount, date));
    }

    public double getBalance() {
        return balance;
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public int getAccountNumber() {
        return accountNumber;
    }
    // Getter methods...
}
