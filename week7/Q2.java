class Q2 {

    // Generic Method
    public static <T> void display(T data) {
        System.out.println("Room Info: " + data);
    }

    public static void main(String[] args) {

        display(101);            // Integer
        display("Suite");        // String
        display(5500.50);        // Double
        display(true);           // Boolean
    }
}