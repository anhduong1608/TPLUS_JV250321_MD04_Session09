public class Customer {
    private String name;
    private int type;
    private int loyaltyPoints;
    private int debit;

    public Customer(String name, int type, int loyaltyPoints, int debit) {
        this.name = name;
        this.type = type;
        this.loyaltyPoints = loyaltyPoints;
        this.debit = debit;
    }

    public String getName() {
        return name;
    }

    public boolean isVip() {
        return type == 1;
    }

    public boolean hasLoyaltyPoints() {
        return loyaltyPoints > 0;
    }

    public boolean hasNoDebt() {
        return debit == 0;
    }

    public boolean isEligibleForPromotion() {
        return isVip() && hasLoyaltyPoints() && hasNoDebt();
    }
}
