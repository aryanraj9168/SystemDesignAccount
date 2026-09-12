public class InterestCalculatorOld {

    public double calculateInterest(String accountType, double balance) {
        if (accountType.equals("SAVINGS")) {
            return balance * 0.04;
        } else if (accountType.equals("CURRENT")) {
            return balance * 0.01;
        } else {
            throw new IllegalArgumentException("Unknown account type: " + accountType);
        }
    }
}
