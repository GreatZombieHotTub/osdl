// Generic Pair Class
class Pair<T, U> {
    private T roomNumber;
    private U guestName;

    public Pair(T roomNumber, U guestName) {
        this.roomNumber = roomNumber;
        this.guestName = guestName;
    }

    public void displayBooking() {
        System.out.println("Room Number: " + roomNumber);
        System.out.println("Guest Name: " + guestName);
        System.out.println("----------------------");
    }
}

public class Q5 {
    public static void main(String[] args) {

        Pair<Integer, String> booking1 = new Pair<>(101, "Amit");
        Pair<Integer, String> booking2 = new Pair<>(102, "Neha");

        booking1.displayBooking();
        booking2.displayBooking();
    }
}
