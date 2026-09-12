public class ATMBefore implements BankServiceFat {

    private double cashOnHand;

    public ATMBefore(double cashOnHand) {
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

    @Override
    public void transfer(double amount, String targetAccountId) {
        throw new UnsupportedOperationException("ATM cannot transfer between accounts");
    }

    @Override
    public String printStatement() {
        throw new UnsupportedOperationException("ATM cannot print statements");
    }

    @Override
    public void applyForLoan(double amount) {
        throw new UnsupportedOperationException("ATM cannot process loan applications");
    }

    public double getCashOnHand() {
        return cashOnHand;
    }
}
