public interface BankServiceFat {
    void deposit(double amount);
    void withdraw(double amount);
    void transfer(double amount, String targetAccountId);
    String printStatement();
    void applyForLoan(double amount);
}
