class Room{
    int rno;
    String type;
    double price;
    Room(int x, String y){
        this.rno=x;
        this.type=y;
        this.price=-1;
    }
    Room(int x, String y, double z){
        this.rno=x;
        this.type=y;
        this.price=z;
    }
    public void display(){
        System.out.println("\nRoom Details");
        System.out.println("==========================================================================");
        System.out.println("room number:" + rno);
        System.out.println("room type: " + type);
        System.out.println("base price: "+ price);
    }
}

class DeluxeRoom extends Room{
    String wa;
    String cb;
    DeluxeRoom(int a, String b, double c, String d, String e){
        super(a,b,c);
        this.wa=d;
        this.cb=e;
    }

    public void display(){
        super.display();
        System.out.println("Wifi availability: "+ wa);
        System.out.println("Complimentary breakfast: "+ cb);
    }
}



public class Ex2 {
    public static void main(String[] args) {
        Room r1=new Room(612,"DA");
        Room r2=new Room(417, "SA", 10000.5);
        Room r3= new DeluxeRoom(108, "TA", 5000.75, "Y", "non veg");

        r1.display();
        r2.display();
        r3.display();
    }
}
