public class PromotionChecker {

    public static void checkPromotion(Customer customer) {
        if (customer.isEligibleForPromotion()) {
            System.out.println("Khách " + customer.getName() + " là VIP và đủ điều kiện nhận khuyến mãi.");
        } else {
            System.out.println("Khách " + customer.getName() + " là khách thường hoặc không đủ điều kiện.");
        }
    }
}
