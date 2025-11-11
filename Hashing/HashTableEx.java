package Hashing;
import java.util.*;

public class HashTableEx {
    public static void main(String[] args) {
        
        // Hashtable<Integer, String> table = new Hashtable<>(10);

        // table.put(100, "Spongebob");
        // table.put(123, "Patrick");
        // table.put(321, "Sandy");
        // table.put(555, "Squidward");
        // table.put(777, "Gary");
        
        // System.out.println(table.get(321)); //allows you get the key

        // for(Integer keys: table.keySet()){ //the table.keySet() makes the table iterable for the for loop
        //     System.out.println(keys.hashCode() % 10 + " " + keys + " " + table.get(keys));
        // }
        Hashtable<String, String> table = new Hashtable<>(10);
        table.put("100", "Spongebob");
        table.put("123", "Patrick");
        table.put("321", "Sandy");
        table.put("555", "Squidward");
        table.put("777", "Gary");

        

        for(String keys: table.keySet()){ //the table.keySet() makes the table iterable for the for loop
            System.out.println(keys.hashCode() % 10 + " " + keys + " " + table.get(keys));
        }

        System.out.println(table.get("777"));

        



    }
    
}
