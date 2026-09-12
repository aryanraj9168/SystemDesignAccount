import java.time.LocalDateTime;

public class StatementGenerator {

    public String generate(BankAccount account) {
        StringBuilder sb = new StringBuilder();
        sb.append("=== Statement for ").append(account.getAccountId()).append(" ===\n");
        sb.append("Owner email: ").append(account.getOwnerEmail()).append("\n");
        sb.append("Balance: $").append(account.getBalance()).append("\n");
        sb.append("Generated at: ").append(LocalDateTime.now()).append("\n");
        return sb.toString();
    }
}
