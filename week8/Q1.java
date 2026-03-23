import java.util.*;

// Room Class
class Room {
    int roomNumber;
    String type;
    double price;
    boolean isAvailable;

    Room(int roomNumber, String type, double price) {
        this.roomNumber = roomNumber;
        this.type = type;
        this.price = price;
        this.isAvailable = true;
    }
}

// Customer Class
class Customer {
    int customerId;
    String name;
    String contact;
    int roomNumber;

    Customer(int customerId, String name, String contact, int roomNumber) {
        this.customerId = customerId;
        this.name = name;
        this.contact = contact;
        this.roomNumber = roomNumber;
    }
}

// Main Class
public class Q1 {

    static ArrayList<Room> rooms = new ArrayList<>();
    static ArrayList<Customer> customers = new ArrayList<>();
    static HashMap<Integer, Customer> bookings = new HashMap<>();

    static Scanner sc = new Scanner(System.in);

    // Add Room
    static void addRoom() {
        System.out.print("Enter Room Number: ");
        int num = sc.nextInt();

        System.out.print("Enter Room Type: ");
        String type = sc.next();

        System.out.print("Enter Price: ");
        double price = sc.nextDouble();

        rooms.add(new Room(num, type, price));
        System.out.println("Room added successfully!");
    }

    // Display Available Rooms
    static void displayRooms() {
        System.out.println("Available Rooms:");

        Iterator<Room> itr = rooms.iterator();
        while (itr.hasNext()) {
            Room r = itr.next();
            if (r.isAvailable) {
                System.out.println(r.roomNumber + " | " + r.type + " | " + r.price);
            }
        }
    }

    // Add Customer
    static void addCustomer() {
        System.out.print("Enter Customer ID: ");
        int id = sc.nextInt();

        System.out.print("Enter Name: ");
        String name = sc.next();

        System.out.print("Enter Contact: ");
        String contact = sc.next();

        customers.add(new Customer(id, name, contact, -1));
        System.out.println("Customer added!");
    }

    // Book Room
    static void bookRoom() {
        System.out.print("Enter Customer ID: ");
        int id = sc.nextInt();

        Customer customer = null;
        for (Customer c : customers) {
            if (c.customerId == id) {
                customer = c;
                break;
            }
        }

        if (customer == null) {
            System.out.println("Customer not found!");
            return;
        }

        System.out.print("Enter Room Number to Book: ");
        int roomNo = sc.nextInt();

        for (Room r : rooms) {
            if (r.roomNumber == roomNo && r.isAvailable) {
                r.isAvailable = false;
                customer.roomNumber = roomNo;
                bookings.put(roomNo, customer);

                System.out.println("Room booked successfully!");
                return;
            }
        }

        System.out.println("Room not available!");
    }

    // Checkout Customer
    static void checkout() {
        System.out.print("Enter Room Number: ");
        int roomNo = sc.nextInt();

        if (bookings.containsKey(roomNo)) {
            Customer c = bookings.get(roomNo);
            bookings.remove(roomNo);

            for (Room r : rooms) {
                if (r.roomNumber == roomNo) {
                    r.isAvailable = true;
                }
            }

            c.roomNumber = -1;
            System.out.println("Checkout successful!");
        } else {
            System.out.println("No booking found!");
        }
    }

    // Display Customers
    static void displayCustomers() {
        System.out.println("Customer List:");

        Iterator<Customer> itr = customers.iterator();
        while (itr.hasNext()) {
            Customer c = itr.next();
            System.out.println(c.customerId + " | " + c.name + " | Room: " + c.roomNumber);
        }
    }

    // Sort Rooms by Price
    static void sortRooms() {
        Collections.sort(rooms, (a, b) -> Double.compare(a.price, b.price));
        System.out.println("Rooms sorted by price!");
    }

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n--- HOTEL MANAGEMENT SYSTEM ---");
            System.out.println("1. Add Room");
            System.out.println("2. Display Available Rooms");
            System.out.println("3. Add Customer");
            System.out.println("4. Book Room");
            System.out.println("5. Checkout");
            System.out.println("6. Display Customers");
            System.out.println("7. Sort Rooms by Price");
            System.out.println("8. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1: addRoom(); break;
                case 2: displayRooms(); break;
                case 3: addCustomer(); break;
                case 4: bookRoom(); break;
                case 5: checkout(); break;
                case 6: displayCustomers(); break;
                case 7: sortRooms(); break;
                case 8: System.out.println("Exiting..."); break;
                default: System.out.println("Invalid choice!");
            }

        } while (choice != 8);
    }
}