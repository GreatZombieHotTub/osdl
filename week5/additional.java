import java.io.File;

public class additional {
    public static void main(String[] args) {

        File file = new File("input.txt");

        if (file.exists()) {
            System.out.println("File Name: " + file.getName());
            System.out.println("Absolute Path: " + file.getAbsolutePath());
            System.out.println("File Size (bytes): " + file.length());
            System.out.println("Readable: " + file.canRead());
            System.out.println("Writable: " + file.canWrite());
            System.out.println("Executable: " + file.canExecute());
        } else {
            System.out.println("File does not exist.");
        }
    }
}
