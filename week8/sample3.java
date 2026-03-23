import java.util.ArrayList; 
import java.util.Collections; 
public class sample3 { 
public static void main(String[] args) { 
// Creating a list 
ArrayList<Integer> numbers = new ArrayList<>(); 
// Adding elements to the list 
numbers.add(45); 
numbers.add(10); 
numbers.add(30); 
numbers.add(25); 
numbers.add(5); 
// Displaying original list 
System.out.println("Original List: " + numbers); 
// Sorting the list in ascending order 
Collections.sort(numbers); 
// Displaying sorted list 
System.out.println("Sorted List (Ascending): " + numbers); 
// Sorting the list in descending order 
Collections.sort(numbers, Collections.reverseOrder()); 
// Displaying descending order list 
System.out.println("Sorted List (Descending): " + numbers); 
System.out.println(numbers);
} 
}
