public class ex1 {
    public static void main(String[] args) {
        
        double primitiveTariff = 1500.50;
        int primitiveDays = 3;
        double primitiveServiceCharge = 250.75;

       
        Double roomTariff = primitiveTariff; 
        Integer daysStayed = primitiveDays;
        Double serviceCharges = primitiveServiceCharge;

        
        double totalBill = (roomTariff * daysStayed) + serviceCharges;

       
        System.out.println("--- Hotel Bill Summary ---");
        System.out.println("Room Tariff (per day): $" + roomTariff);
        System.out.println("Days Stayed: " + daysStayed);
        System.out.println("Additional Service Charges: $" + serviceCharges);
        System.out.println("---------------------------");
        System.out.println("Total Amount Payable: $" + totalBill);
    }
}