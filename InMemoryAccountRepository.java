import java.util.ArrayList;
import java.util.List;

public class InMemoryAccountRepository implements AccountRepository {

    private final List<Account> accounts = new ArrayList<>();

    @Override
    public void save(Account account) {
        accounts.removeIf(existing -> existing.getAccountId().equals(account.getAccountId()));
        accounts.add(account);
    }

    @Override
    public List<Account> findAll() {
        return new ArrayList<>(accounts);
    }
}
