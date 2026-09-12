import java.time.LocalDateTime;

public class BankAccountMessy {

    private String accountId;
    private String ownerEmail;
    private double balance;

    public BankAccountMessy(String accountId, String ownerEmail, double balance) {
        this.accountId = accountId;
        this.ownerEmail = ownerEmail;
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive");
        }
        balance += amount;
        saveToDatabase();
        sendEmail("Deposit of $" + amount + " received. New balance: $" + balance);
        System.out.println("[LOG] Deposit processed for " + accountId);
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be positive");
        }
        if (amount > balance) {
            throw new IllegalStateException("Insufficient funds");
        }
        balance -= amount;
        saveToDatabase();
        sendEmail("Withdrawal of $" + amount + " processed. New balance: $" + balance);
        System.out.println("[LOG] Withdrawal processed for " + accountId);
    }

    private void saveToDatabase() {
        System.out.println("Saving account to database");
    }

    private void sendEmail(String message) {
        System.out.println("Sending: " + message + " (to " + ownerEmail + ")");
    }

    public String printStatement() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== Statement for ").append(accountId).append(" ===\n");
        sb.append("Owner email: ").append(ownerEmail).append("\n");
        sb.append("Balance: $").append(balance).append("\n");
        sb.append("Generated at: ").append(LocalDateTime.now()).append("\n");
        return sb.toString();
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
