import java.util.ArrayList;

public class TransactionManager {
    private ArrayList<Transaction> transactions;

    public TransactionManager() {
        this.transactions = new ArrayList<>();
    }

    public void addTransaction(double amount, String date) {
        transactions.add(new Transaction(amount, date));
    }
}
