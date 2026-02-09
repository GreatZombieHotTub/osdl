import java.io.FileInputStream; 
import java.io.IOException; 
public class FileInputStreamDemo { 
public static void main(String[] args) { 
FileInputStream fis = null; 

try { 
// Open the file 
fis = new FileInputStream("input.txt"); 
int data; 
System.out.println("File contents:"); 
// Read file byte by byte 
while ((data = fis.read()) != -1) { 
System.out.print((char)data); 
} 

} catch (IOException e) { 
    System.out.println("File error: " + e.getMessage()); 
    } finally { 
    try { 
    if (fis != null) { 
    fis.close(); // Close the file 
    } 
    } catch (IOException e) { 
    System.out.println("Error closing file"); 
    } 
    } 
    } 
    } 