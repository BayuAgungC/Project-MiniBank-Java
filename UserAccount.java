public class UserAccount extends Account {
    private User user;

    public UserAccount(int accountNumber, double balance, User user) {
        super(accountNumber, balance);
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    // Tambahan method sesuai kebutuhan
}
