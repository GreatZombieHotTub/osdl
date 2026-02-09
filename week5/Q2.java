import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Q2 {
    public static void main(String[] args) {

        try (FileReader fr = new FileReader("input.txt");
             FileWriter fw = new FileWriter("output.txt")) {

            int ch;
            // Read character by character and write to destination
            while ((ch = fr.read()) != -1) {
                fw.write(ch);
            }

            System.out.println("Text file copied successfully using character streams.");

        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
        }
    }
}
