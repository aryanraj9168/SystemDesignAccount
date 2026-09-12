import java.util.ArrayList;
import java.util.List;

public class BankBeforeDIP {

    private InMemoryAccountRepository accountRepository = new InMemoryAccountRepository();

    public void openAccount(Account account) {
        accountRepository.save(account);
    }

    public List<Account> listAccounts() {
        return new ArrayList<>(accountRepository.findAll());
    }
}
