class RoomCharges<T extends Number> {

    private T price;
    private T discount;

    public RoomCharges(T price, T discount) {
        this.price = price;
        this.discount = discount;
    }

    public double totalPrice() {
        return price.doubleValue();
    }

    public double discountedPrice() {
        return price.doubleValue() - discount.doubleValue();
    }
}

public class Q3 {
    public static void main(String[] args) {

        RoomCharges<Double> obj = new RoomCharges<>(5000.0, 500.0);

        System.out.println("Total Price: " + obj.totalPrice());
        System.out.println("Discounted Price: " + obj.discountedPrice());

        // Compilation Error:
        // RoomCharges<String> obj2 = new RoomCharges<>("5000", "500");
    }
}