class Hotel {

    private int availableRooms;

    Hotel(int rooms) {
        this.availableRooms = rooms;
    }

    // Book room method
    synchronized void bookRoom(String customerName) {

        System.out.println(customerName + " is trying to book a room");

        while (availableRooms == 0) {
            System.out.println(customerName + " is waiting (No rooms available)");
            try {
                wait(); // Wait until a room is released
            } catch (InterruptedException e) {
                System.out.println("Booking interrupted");
            }
        }

        availableRooms--;
        System.out.println(customerName + " booked a room. Rooms left: " + availableRooms);
    }

    // Release room method
    synchronized void releaseRoom(String customerName) {

        availableRooms++;
        System.out.println(customerName + " released a room. Rooms available: " + availableRooms);

        notify(); // Notify waiting booking thread
    }
}
class Customer extends Thread {

    private Hotel hotel;
    private String customerName;

    Customer(Hotel hotel, String name) {
        this.hotel = hotel;
        this.customerName = name;
    }

    @Override
    public void run() {

        hotel.bookRoom(customerName);

        try {
            Thread.sleep(2000); // Customer stays in room
        } catch (InterruptedException e) {
            System.out.println("Stay interrupted");
        }

        hotel.releaseRoom(customerName);
    }
}

public class Q1b {

    public static void main(String[] args) {

        Hotel hotel = new Hotel(2); // Only 2 rooms available

        Customer c1 = new Customer(hotel, "Customer-1");
        Customer c2 = new Customer(hotel, "Customer-2");
        Customer c3 = new Customer(hotel, "Customer-3");
        Customer c4 = new Customer(hotel, "Customer-4");

        c1.start();
        c2.start();
        c3.start();
        c4.start();
    }
}
