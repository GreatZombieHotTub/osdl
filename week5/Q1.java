import java.io.FileInputStream;
import java.io.FileOutputStream; 
import java.io.IOException;

public class Q1{
    public static void main(String[] args){

        FileInputStream fi=null;
        FileOutputStream fo=null;

        try {
            fi=new FileInputStream("input.txt");
            fo=new FileOutputStream("output.txt");
            int data;
            // Read byte by byte and write to destination
            while ((data = fi.read()) != -1) {
                fo.write(data);
            }


        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        finally{
            try {
                if (fi != null) {
                    fi.close();}
                    
                if(fo!=null){ 
                    fo.close();}
            } catch (IOException e){
             System.out.println("error closing file");
            }
        }
    }}
