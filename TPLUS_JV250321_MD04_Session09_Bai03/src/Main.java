import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập tên khách hàng: ");
        String name = scanner.nextLine();

        System.out.print("Nhập loại khách hàng (1 - VIP, 2 - Thường): ");
        int type = Integer.parseInt(scanner.nextLine());

        System.out.print("Nhập điểm tích lũy: ");
        int loyaltyPoints = Integer.parseInt(scanner.nextLine());

        System.out.print("Nhập số tiền nợ: ");
        int debit = Integer.parseInt(scanner.nextLine());

        Customer customer = new Customer(name, type, loyaltyPoints, debit);
        PromotionChecker.checkPromotion(customer);
    }
}