import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.collections.*;

public class App extends Application {

    TableView<Room> table = new TableView<>();
    ObservableList<Room> roomList = FXCollections.observableArrayList();

    TextField txtRoom = new TextField();
    ComboBox<String> cmbType = new ComboBox<>();
    TextField txtPrice = new TextField();
    Label lblMessage = new Label();

    @Override
    public void start(Stage stage) {

        // Table Columns
        TableColumn<Room,Integer> colNumber = new TableColumn<>("Room No");
        colNumber.setCellValueFactory(c -> c.getValue().roomNumberProperty().asObject());

        TableColumn<Room,String> colType = new TableColumn<>("Type");
        colType.setCellValueFactory(c -> c.getValue().roomTypeProperty());

        TableColumn<Room,Double> colPrice = new TableColumn<>("Price");
        colPrice.setCellValueFactory(c -> c.getValue().priceProperty().asObject());

        TableColumn<Room,String> colStatus = new TableColumn<>("Status");
        colStatus.setCellValueFactory(c -> c.getValue().statusProperty());

        table.getColumns().addAll(colNumber,colType,colPrice,colStatus);
        table.setItems(roomList);

        // Controls
        cmbType.getItems().addAll("Single","Double","Deluxe");

        Button btnAdd = new Button("Add Room");
        Button btnBook = new Button("Book Room");
        Button btnCheckout = new Button("Checkout");

        // Add Room
        btnAdd.setOnAction(e -> {
            int number = Integer.parseInt(txtRoom.getText());
            String type = cmbType.getValue();
            double price = Double.parseDouble(txtPrice.getText());

            roomList.add(new Room(number,type,price,"Available"));
            lblMessage.setText("Room Added");
            clearFields();
        });

        // Book Room
        btnBook.setOnAction(e -> {
            Room r = table.getSelectionModel().getSelectedItem();
            if(r != null && r.getStatus().equals("Available")){
                r.setStatus("Occupied");
                table.refresh();
                lblMessage.setText("Room Booked");
            }
            else{
                lblMessage.setText("Room already occupied");
            }
        });

        // Checkout
        btnCheckout.setOnAction(e -> {
            Room r = table.getSelectionModel().getSelectedItem();
            if(r != null){
                r.setStatus("Available");
                table.refresh();
                lblMessage.setText("Checkout Successful");
            }
        });

        // Form Layout
        GridPane form = new GridPane();
        form.setHgap(10);
        form.setVgap(10);

        form.add(new Label("Room Number"),0,0);
        form.add(txtRoom,1,0);

        form.add(new Label("Room Type"),0,1);
        form.add(cmbType,1,1);

        form.add(new Label("Price"),0,2);
        form.add(txtPrice,1,2);

        form.add(btnAdd,1,3);

        // Buttons
        HBox buttons = new HBox(10,btnBook,btnCheckout);

        VBox root = new VBox(15,form,buttons,table,lblMessage);

        Scene scene = new Scene(root,600,400);

        stage.setTitle("Hotel Management System");
        stage.setScene(scene);
        stage.show();
    }

    void clearFields(){
        txtRoom.clear();
        txtPrice.clear();
        cmbType.setValue(null);
    }

    public static void main(String[] args){
        launch(args);
    }
}