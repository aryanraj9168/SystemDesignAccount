import java.util.ArrayList;
import java.util.List;

public class WithdrawableListDemo {

    public static void main(String[] args) {
        List<Withdrawable> withdrawables = new ArrayList<>();
        withdrawables.add(new SavingsAccount("SAV-001", "alice@example.com", 1000.00));
        withdrawables.add(new CurrentAccount("CUR-001", "carol@example.com", 2000.00));

        for (Withdrawable withdrawable : withdrawables) {
            withdrawable.withdraw(100.00);
            Account account = (Account) withdrawable;
            System.out.println(account.getAccountId() + " new balance: $" + account.getBalance());
        }

        FixedDepositAccount fixedDepositAccount =
                new FixedDepositAccount("FD-001", "bob@example.com", 5000.00);
        System.out.println(fixedDepositAccount.getAccountId()
                + " balance stays locked: $" + fixedDepositAccount.getBalance());
    }
}
