class RoomCleaning extends Thread {
    public void run() {
        for (int i = 1; i <= 2; i++) {
            System.out.println("Room Cleaning - Step " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("Room Cleaning interrupted");
            }
        }
    }
}
class FoodDelivery extends Thread {
    public void run() {
        for (int i = 1; i <= 4; i++) {
            System.out.println("Food Delivery - Step " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("Food Delivery interrupted");
            }
        }
    }
}
class Maintenance extends Thread {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Maintenance - Step " + i);
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                System.out.println("Maintenance interrupted");
            }
        }
    }
}

// Main class
public class Q1 {
    public static void main(String[] args) {

        RoomCleaning rc = new RoomCleaning();
        FoodDelivery fd = new FoodDelivery();
        Maintenance mt = new Maintenance();

        rc.start();
        fd.start();
        mt.start();

        System.out.println("All hotel services are running concurrently...");
    }
}


