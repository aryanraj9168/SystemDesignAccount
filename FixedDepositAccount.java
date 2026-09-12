public class FixedDepositAccount extends Account {

    public FixedDepositAccount(String accountId, String ownerEmail, double balance) {
        super(accountId, ownerEmail, balance);
    }

    @Override
    public void withdraw(double amount) {
        throw new UnsupportedOperationException("Fixed Deposit accounts cannot be withdrawn early");
    }
}
