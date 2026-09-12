public class Main {

    public static void main(String[] args) {

        Bank bank = new Bank(new EmailNotificationService());

        SavingsAccount savingsAccount = new SavingsAccount("SAV-001", "alice@example.com", 1000.00);
        CurrentAccount currentAccount = new CurrentAccount("CUR-001", "bob@example.com", 2000.00);
        SalaryAccount salaryAccount = new SalaryAccount("SAL-001", "carol@example.com", 3000.00);

        bank.applyInterest(savingsAccount, new SavingsInterestPolicy());
        bank.applyInterest(currentAccount, new CurrentInterestPolicy());
        bank.applyInterest(salaryAccount, new SalaryInterestPolicy());

        System.out.println();
        System.out.println(savingsAccount.getAccountId() + " balance: $" + savingsAccount.getBalance());
        System.out.println(currentAccount.getAccountId() + " balance: $" + currentAccount.getBalance());
        System.out.println(salaryAccount.getAccountId() + " balance: $" + salaryAccount.getBalance());

        Bank smsBank = new Bank(new SMSNotificationService());
        smsBank.applyInterest(salaryAccount, new SalaryInterestPolicy());
        System.out.println(salaryAccount.getAccountId() + " balance: $" + salaryAccount.getBalance());
    }
}
