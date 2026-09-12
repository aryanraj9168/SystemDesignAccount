import java.util.List;

public class Bank {

    private final AccountRepository accountRepository;
    private final NotificationService notificationService;

    public Bank(AccountRepository accountRepository, NotificationService notificationService) {
        this.accountRepository = accountRepository;
        this.notificationService = notificationService;
    }

    public void openAccount(Account account) {
        accountRepository.save(account);
        notificationService.send("Account " + account.getAccountId() + " opened");
    }

    public List<Account> listAccounts() {
        return accountRepository.findAll();
    }
}
