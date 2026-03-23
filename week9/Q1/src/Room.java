import javafx.beans.property.*;

public class Room {

    private IntegerProperty roomNumber;
    private StringProperty roomType;
    private DoubleProperty price;
    private StringProperty status;

    public Room(int number,String type,double price,String status){
        this.roomNumber = new SimpleIntegerProperty(number);
        this.roomType = new SimpleStringProperty(type);
        this.price = new SimpleDoubleProperty(price);
        this.status = new SimpleStringProperty(status);
    }

    public IntegerProperty roomNumberProperty(){ return roomNumber; }
    public StringProperty roomTypeProperty(){ return roomType; }
    public DoubleProperty priceProperty(){ return price; }
    public StringProperty statusProperty(){ return status; }

    public String getStatus(){ return status.get(); }
    public void setStatus(String s){ status.set(s); }
}