
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;



public class App extends Application {
    public void start(Stage stage){
        Label label=new Label("hello niggas");
        StackPane root=new StackPane(label);
        Scene scene=new Scene(root, 400,300);
        stage.setTitle("my first app AAAAAAAAA");
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) throws Exception {
        System.out.println("Now you'll see the window!");
        launch(args);
    }
}
//what if the window had a button that disappears when u press it and shows hello world instead
//what if there were a button that oppened a new window with hellow world in it
//typewriter
