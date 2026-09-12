import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileAccountRepository implements AccountRepository {

    private final String filePath;

    public FileAccountRepository(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void save(Account account) {
        List<Account> accounts = findAll();
        accounts.removeIf(existing -> existing.getAccountId().equals(account.getAccountId()));
        accounts.add(account);

        try (FileWriter writer = new FileWriter(filePath)) {
            for (Account current : accounts) {
                writer.write(current.getAccountId() + "," + current.getOwnerEmail()
                        + "," + current.getBalance() + "\n");
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to save accounts to file", e);
        }
    }

    @Override
    public List<Account> findAll() {
        List<Account> accounts = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.isBlank()) {
                    continue;
                }
                String[] parts = line.split(",");
                accounts.add(new Account(parts[0], parts[1], Double.parseDouble(parts[2])));
            }
        } catch (IOException e) {
            return accounts;
        }

        return accounts;
    }
}
