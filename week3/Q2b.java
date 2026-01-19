// Thread class for Order Processing
class OrderProcessingThread extends Thread {

    private String orderName;

    OrderProcessingThread(String orderName) {
        this.orderName = orderName;
    }

    @Override
    public void run() {

        System.out.println(orderName + " - Order validation started");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }

        System.out.println(orderName + " - Payment processing");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }

        System.out.println(orderName + " - Order shipment");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }

        System.out.println(orderName + " completed successfully.");
    }
}

// Main class
public class Q2b {
    public static void main(String[] args) {

        // Creating multiple orders
        OrderProcessingThread order1 = new OrderProcessingThread("Order #101");
        OrderProcessingThread order2 = new OrderProcessingThread("Order #102");
        OrderProcessingThread order3 = new OrderProcessingThread("Order #103");

        // Starting order processing concurrently
        order1.start();
        order2.start();
        order3.start();

        try {
            // Main thread waits until all order threads complete
            order1.join();
            order2.join();
            order3.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted");
        }

        System.out.println("All orders processed. Main thread completed.");
    }
}
