import java.io.File;
//Program: List All Files in a Directory
public class add3 {
    public static void main(String[] args) {

        File dir = new File(".");

        String[] files = dir.list();

        if (files != null) {
            for (String name : files) {
                System.out.println(name);
            }
        }
    }
}
