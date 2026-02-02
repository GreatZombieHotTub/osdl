class Hotel {
    private int rooms = 2; // Total rooms available

    // Method to book a room
    synchronized void book(String name) {
        while (rooms == 0) {
            try {
                System.out.println(name + " is waiting... No rooms available.");
                wait(); // Release lock and wait
            } catch (InterruptedException e) {
                System.out.println("Interrupted");
            }
        }
        rooms--;
        System.out.println(name + " booked a room. Remaining: " + rooms);
    }

    // Method to release a room
    synchronized void release(String name) {
        rooms++;
        System.out.println(name + " checked out. Available now: " + rooms);
        notify(); // Wake up one waiting thread
    }
}

// Following your example style: Class extends Thread
class Guest extends Thread {
    Hotel hotel;
    String action;

    Guest(Hotel hotel, String name, String action) {
        super(name); // Pass name to Thread constructor
        this.hotel = hotel;
        this.action = action;
    }

    @Override
    public void run() {
        if (action.equals("BOOK")) {
            hotel.book(getName());
        } else {
            hotel.release(getName());
        }
    }
}

public class Q1 {
    public static void main(String[] args) {
        Hotel sharedHotel = new Hotel();

        // Creating threads that extend Thread
        Guest g1 = new Guest(sharedHotel, "Customer-1", "BOOK");
        Guest g2 = new Guest(sharedHotel, "Customer-2", "BOOK");
        Guest g3 = new Guest(sharedHotel, "Customer-3", "BOOK");

        g1.start();
        g2.start();
        g3.start();

        // After a delay, someone checks out
        try { Thread.sleep(2000); } catch(Exception e) {}
        
        Guest checkout = new Guest(sharedHotel, "Customer-1", "RELEASE");
        checkout.start();
    }
}