package Hashing;

import java.util.HashMap;
import java.util.Random;

public class HashMapCustomInsertDeleteSearch {
    public static class CustomHashMap {

    private HashMap<Integer, Integer> table;
    private int tableSize;
    //private Random r;
    //private int[] randSeq;

    public CustomHashMap(int size) {
        tableSize = size;
        table = new HashMap<>();
        //r = new Random(42); 


        //This is pseduo random to pre generate random offsets
        // randSeq = new int[tableSize];
        //     Random random = new Random(42); // fixed seed for reproducibility
        //     for (int i = 0; i < tableSize; i++) {
        //         randSeq[i] = r.nextInt(tableSize); //r.nextInt(tableSize) will generate up to that table size
        //
        //the for loop will give you pregenerated indexs already such as 
        //randSeq = [10, 1, 0, 4, 3, 2, 7, 3, 2, 6, 5]
        // }
    }
    /* Double hashing functions
     * 
     * private int hash1(int key){
     * return key % tableSize;
     * }
     * 
     * private int hash2(int key){
     * return 7-(key % 7);
     * }
     */

    // Hash function formulas for all the collision resolution strats 
    private int hash(int key, int ci) {
        // H(k, ci) = (key + ci^2) % tableSize

        //linear probing
        //return (key + ci) % tableSize; 

        //pseudo random probing
        //return (key + randSeq[ci] % tableSize)

        //double hashing
        //return (hash1(key) + ci * hash2(key)) % tableSize;

        return (key + ci * ci) % tableSize; //this is for quadratic

        //when looking at the hashing we are only taking the value of the key not the hashcode
    }

    // Insert key using quadratic probing
    public void insert(int key) {
        for (int ci = 0; ci < tableSize; ci++) {
            int index = hash(key, ci);

            if (!table.containsKey(index)) { // if index is empty
                table.put(index, key); // store key at that index
                System.out.println("Inserted " + key + " at index " + index);
                return;
            }
        }
        System.out.println("Table is full! Cannot insert key: " + key);
    }

    // Search key using quadratic probing
    public boolean search(int key) {
        for (int ci = 0; ci < tableSize; ci++) {
            int index = hash(key, ci);

            if (!table.containsKey(index)) { 
                // Empty slot means key not found
                return false;
            }

            if (table.get(index) == key) {
                System.out.println("Found " + key + " at index " + index);
                return true;
            }
        }
        return false;
    }

    // Delete key using quadratic probing
    public void delete(int key) {
        for (int ci = 0; ci < tableSize; ci++) {
            int index = hash(key, ci);

            if (!table.containsKey(index)) {
                System.out.println("Key " + key + " not found!");
                return;
            }

            if (table.get(index) == key) {
                table.remove(index);
                System.out.println("Deleted " + key + " from index " + index);
                return;
            }
        }
        System.out.println("Key " + key + " not found!");
    }

    // Display current table
    public void display() {
        System.out.println("\nCurrent Hash Table:");
        for (int i = 0; i < tableSize; i++) {

            if (table.containsKey(i)){
                System.out.println("Index " + i + " : " + table.get(i));
            }
            else{
                System.out.println("Index " + i + " : -1");
            }
        }
        System.out.println();
    }
    public static void main(String[] args) {
        CustomHashMap ht = new CustomHashMap(11);

        System.out.println("=== INSERT ===");
        int[] keys = {21, 10, 32, 43, 54, 65, 87, 76};

        for (int key : keys) {
            ht.insert(key);
        }

        ht.display();

        System.out.println("=== SEARCH ===");
        ht.search(54);
        ht.search(99);

        System.out.println("=== DELETE ===");
        ht.delete(32);
        ht.delete(99);

        ht.display();
        }
    }  
}
