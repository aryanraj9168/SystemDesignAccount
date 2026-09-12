import java.util.List;

public interface AccountRepository {
    void save(Account account);
    List<Account> findAll();
}
