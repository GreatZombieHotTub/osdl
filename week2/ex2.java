// i. Define the enum RoomType
enum type2{
    // Enum constants with associated base tariff values
    STANDARD(2000.0), 
    DELUXE(3500.0), 
    SUITE(5500.0);

    // Instance variable to store the tariff
    private final double baseTariff;

    // Enum constructor: Initializes the baseTariff for each constant
    // Note: Enum constructors are implicitly private
    type2(double baseTariff) {
        this.baseTariff = baseTariff;
    }

    // Method to return the base tariff
    public double getBaseTariff() {
        return baseTariff;
    }

    // Method to calculate total cost based on days stayed
    public double calculateTotalCost(int days) {
        return this.baseTariff * days;
    }
}

// ii. Main class to execute the application
public class ex2 {
    public static void main(String[] args) {
        // Selecting a room type and specifying days
        type2 selectedRoom = type2.SUITE;
        int daysStayed = 4;

        System.out.println("\n--- Hotel Booking Details ---");
        
        // Accessing data via enum methods
        System.out.println("Selected Room   : " + selectedRoom);
        System.out.println("Tariff per Night: " + selectedRoom.getBaseTariff());
        System.out.println("Stay Duration   : " + daysStayed + " days");
        
        // Computing final cost
        double totalCost = selectedRoom.calculateTotalCost(daysStayed);
        
        System.out.println("-----------------------------");
        System.out.println("Total Room Bill : " + totalCost);
    }
}