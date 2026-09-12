public class ATM implements Depositable, Withdrawable {

    private double cashOnHand;

    public ATM(double cashOnHand) {
        this.cashOnHand = cashOnHand;
    }

    @Override
    public void deposit(double amount) {
        cashOnHand += amount;
    }

    @Override
    public void withdraw(double amount) {
        if (amount > cashOnHand) {
            throw new IllegalStateException("ATM out of cash");
        }
        cashOnHand -= amount;
    }

    public double getCashOnHand() {
        return cashOnHand;
    }
}
