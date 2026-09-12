public class BankAccount {

    private final String accountId;
    private final String ownerEmail;
    private double balance;

    public BankAccount(String accountId, String ownerEmail, double balance) {
        this.accountId = accountId;
        this.ownerEmail = ownerEmail;
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive");
        }
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be positive");
        }
        if (amount > balance) {
            throw new IllegalStateException("Insufficient funds");
        }
        balance -= amount;
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountId() {
        return accountId;
    }

    public String getOwnerEmail() {
        return ownerEmail;
    }
}
