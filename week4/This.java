class HotelCapacity {
    private boolean[] rooms = new boolean[5]; // Assume 5 rooms

    // Method to book a specific room
    synchronized void roomBook(int roomNo) {
        // If the room is already true (booked), wait
        while (rooms[roomNo]) {
            try {
                System.out.println(Thread.currentThread().getName() + " waiting for Room " + roomNo);
                wait();
            } catch (InterruptedException e) {
                System.out.println("Interrupted while booking!");
            }
        }
        
        rooms[roomNo] = true;
        System.out.println(Thread.currentThread().getName() + " booked Room " + roomNo);
        notifyAll(); // Notify other threads (like the Releaser)
    }

    // Method to release a specific room
    synchronized void roomRelease(int roomNo) {
        // If the room is false (already empty), wait
        while (!rooms[roomNo]) {
            try {
                System.out.println(Thread.currentThread().getName() + " waiting to release Room " + roomNo);
                wait();
            } catch (InterruptedException e) {
                System.out.println("Interrupted while releasing!");
            }
        }

        rooms[roomNo] = false;
        System.out.println(Thread.currentThread().getName() + " emptied Room " + roomNo);
        notifyAll(); // Notify other threads (like the Booker)
    }
}

class RoomBook extends Thread {
    HotelCapacity capacity;

    public RoomBook(HotelCapacity capacity, String name) {
        super(name);
        this.capacity = capacity;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            capacity.roomBook(i);
            try {
                Thread.sleep(500); // Small delay to see output clearly
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

class RoomRelease extends Thread {
    HotelCapacity capacity;

    public RoomRelease(HotelCapacity capacity, String name) {
        super(name);
        this.capacity = capacity;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            capacity.roomRelease(i);
            try {
                Thread.sleep(1200); // Releasing takes longer than booking
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

public class This { // Renamed from 'This' to 'HotelDemo'
    public static void main(String[] args) {
        HotelCapacity hotel = new HotelCapacity();

        // One thread for booking, one for releasing
        RoomBook booker = new RoomBook(hotel, "Booker-Thread");
        RoomRelease releaser = new RoomRelease(hotel, "Releaser-Thread");

        booker.start();
        releaser.start();
    }
}