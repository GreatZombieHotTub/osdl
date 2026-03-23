import java.util.ArrayList; 
import java.util.Iterator; 
 
public class sample2 { 
 
    public static void main(String[] args) { 
 
        // Creating a collection 
        ArrayList<Integer> numbers = new ArrayList<>(); 
 
        // Adding elements to the collection 
        numbers.add(10); 
        numbers.add(20); 
        numbers.add(30); 
        numbers.add(40); 
 
        // Obtaining an Iterator 
        Iterator<Integer> itr = numbers.iterator(); 
 
        // Accessing elements using Iterator 
        System.out.println("Elements in the ArrayList:"); 
        while (itr.hasNext()) { 
            Integer value = itr.next(); 
            System.out.println(value); 
        } 
    } 
} 

