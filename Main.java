public class Main {

    public static void main(String[] args) {

        BankAccount account = new BankAccount("ACC-1001", "jane.doe@example.com", 500.00);

        AccountRepository repository = new AccountRepository();
        NotificationService notifier = new NotificationService();
        StatementGenerator statementGenerator = new StatementGenerator();

        account.deposit(150.00);
        repository.save(account);
        notifier.send("Deposit of $150.0 received. New balance: $" + account.getBalance());

        account.withdraw(75.00);
        repository.save(account);
        notifier.send("Withdrawal of $75.0 processed. New balance: $" + account.getBalance());

        account.withdraw(200.00);
        repository.save(account);
        notifier.send("Withdrawal of $200.0 processed. New balance: $" + account.getBalance());

        System.out.println();
        System.out.println(statementGenerator.generate(account));
    }
}
