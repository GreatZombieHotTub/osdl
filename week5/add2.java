import java.io.File;
//Program: Check Whether Path is File or Directory
public class add2 {
    public static void main(String[] args) {

        File f = new File("input.txt");

        if (f.exists()) {
            if (f.isFile()) {
                System.out.println("It is a file.");
            } else if (f.isDirectory()) {
                System.out.println("It is a directory.");
            }
        } else {
            System.out.println("Path does not exist.");
        }
    }
}

