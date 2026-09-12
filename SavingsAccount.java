public class SavingsAccount extends Account
        implements Depositable, Withdrawable, Transferable, StatementProvider {

    public SavingsAccount(String accountId, String ownerEmail, double balance) {
        super(accountId, ownerEmail, balance);
    }

    @Override
    public void transfer(double amount, String targetAccountId) {
        withdraw(amount);
        System.out.println("Transferred $" + amount + " from " + getAccountId()
                + " to " + targetAccountId);
    }

    @Override
    public String printStatement() {
        return "=== Statement for " + getAccountId() + " ===\n"
                + "Owner email: " + getOwnerEmail() + "\n"
                + "Balance: $" + getBalance() + "\n";
    }
}
