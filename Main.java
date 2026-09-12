public class Main {

    public static void main(String[] args) {

        Bank bank = new Bank(new InMemoryAccountRepository(), new EmailNotificationService());

        bank.openAccount(new SavingsAccount("SAV-001", "alice@example.com", 1000.00));
        bank.openAccount(new SavingsAccount("SAV-002", "bob@example.com", 2000.00));

        for (Account account : bank.listAccounts()) {
            System.out.println(account.getAccountId() + " balance: $" + account.getBalance());
        }

        Bank fileBackedBank = new Bank(
                new FileAccountRepository("accounts.txt"), new EmailNotificationService());

        fileBackedBank.openAccount(new SavingsAccount("SAV-003", "carol@example.com", 3000.00));

        for (Account account : fileBackedBank.listAccounts()) {
            System.out.println(account.getAccountId() + " balance: $" + account.getBalance());
        }
    }
}
