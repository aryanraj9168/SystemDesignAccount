public class Bank {

    private final NotificationService notificationService;

    public Bank(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    public void applyInterest(Account account, InterestPolicy policy) {
        double interest = policy.calculate(account.getBalance());
        account.deposit(interest);
        notificationService.send(
                "Interest of $" + interest + " applied to " + account.getAccountId()
                        + ". New balance: $" + account.getBalance());
    }
}
