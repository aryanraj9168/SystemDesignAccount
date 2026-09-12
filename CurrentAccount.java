public class CurrentAccount extends Account implements Withdrawable {

    public CurrentAccount(String accountId, String ownerEmail, double balance) {
        super(accountId, ownerEmail, balance);
    }
}
