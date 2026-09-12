import java.util.ArrayList;
import java.util.List;

public class AccountListDemo {

    public static void main(String[] args) {
        List<Account> accounts = new ArrayList<>();
        accounts.add(new SavingsAccount("SAV-001", "alice@example.com", 1000.00));
        accounts.add(new FixedDepositAccount("FD-001", "bob@example.com", 5000.00));

        for (Account account : accounts) {
            account.withdraw(100.00);
            System.out.println(account.getAccountId() + " new balance: $" + account.getBalance());
        }
    }
}
