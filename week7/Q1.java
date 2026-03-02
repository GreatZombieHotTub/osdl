// Generic class
class Room<T, U> {
    private T roomId;
    private U roomAttribute;

    public Room(T roomId, U roomAttribute) {
        this.roomId = roomId;
        this.roomAttribute = roomAttribute;
    }

    public void displayRoom() {
        System.out.println("Room ID: " + roomId);
        System.out.println("Room Attribute: " + roomAttribute);
        System.out.println("-------------------------");
    }
}

public class Q1 {
    public static void main(String[] args) {

        // Integer & String
        Room<Integer, String> r1 = new Room<>(101, "Deluxe");
        r1.displayRoom();

        // String & Double
        Room<String, Double> r2 = new Room<>("A102", 4500.75);
        r2.displayRoom();
    }
}