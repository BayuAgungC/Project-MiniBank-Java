import java.util.ArrayList;

public class Bank {
    private ArrayList<Account> accounts;
    private static int accountNumberCounter = 1000; // Contoh awal, sesuaikan dengan kebutuhan

    public Bank() {
        this.accounts = new ArrayList<>();
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    // Tambahkan method untuk generate nomor akun baru
    public int generateAccountNumber() {
        return accountNumberCounter++;
    }
}
