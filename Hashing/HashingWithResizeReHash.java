package Hashing;

import java.util.HashMap;
import java.util.Random;

public class HashingWithResizeReHash {

    /* ================= LINEAR PROBING ================= */
    public static class LinearProbingHashMap {
        private HashMap<Integer, Integer> table;
        private int tableSize;
        private int size;
        private double loadFactor;

        public LinearProbingHashMap(int size) {
            tableSize = size;
            table = new HashMap<>();
            this.size = 0;
            this.loadFactor = 0.7;
        }

        private int hash(int key, int ci) {
            return (key + ci) % tableSize; // linear probing
        }

        public void insert(int key) {
            if (size + 1 > tableSize * loadFactor) { //the size will always be 0 this is watch is keeping track of hte size of the map and once it > the tableSize * loadFactor
                resizeAndRehash();
            }
            for (int ci = 0; ci < tableSize; ci++) {
                int index = hash(key, ci);
                if (!table.containsKey(index)) {
                    table.put(index, key);
                    size++; //this is the new thing that is added to keep track of the size
                    System.out.println("Inserted " + key + " at index " + index);
                    return;
                }
            }
            System.out.println("Table is full! Cannot insert key: " + key);
        }

        private void resizeAndRehash() {
            int oldSize = tableSize;
            HashMap<Integer, Integer> oldTable = table;
            tableSize *= 2;
            table = new HashMap<>();
            size = 0;
            System.out.println("Linear Probing Resizing: " + oldSize + " -> " + tableSize);

            for (int idx : oldTable.keySet()) { //made the oldTable iterable
                this.insert(oldTable.get(idx)); //after the rehashing they will not be in the same indices, it will go back into the insert function (IMPORTANT)
                //the this is refering to the current table that we named in the class which is table
            }


            /*
             * The program by default will do the array and resize and rehash it accordinly and that's when it will stop
             * However, if you want to insert a new key into the map then it will check to see if it needs to be
             * resized.
             * If we needs to be resized, then it will resize and rehash the map
             * In addition, when you rehash the keys, they will not be in the same indices as we have a bigger size now
             * this will result in different calculation to place in the map (IMPORTANT)
             */
        }

        public boolean search(int key) {
            for (int ci = 0; ci < tableSize; ci++) {
                int index = hash(key, ci);
                if (!table.containsKey(index)) return false;
                if (table.get(index) == key) {
                    System.out.println("Found " + key + " at index " + index);
                    return true;
                }
            }
            return false;
        }

        public void delete(int key) {
            for (int ci = 0; ci < tableSize; ci++) {
                int index = hash(key, ci);
                if (!table.containsKey(index)) return;
                if (table.get(index) == key) {
                    table.remove(index);
                    size--;
                    System.out.println("Deleted " + key + " from index " + index);
                    return;
                }
            }
        }

        public void display() {
            System.out.println("\nLinear Probing Table:");
            for (int i = 0; i < tableSize; i++)
                System.out.println("Index " + i + " : " + table.getOrDefault(i, -1));
            System.out.println();
        }
    }

    /* ================= QUADRATIC PROBING ================= */
    public static class QuadraticProbingHashMap {
        private HashMap<Integer, Integer> table;
        private int tableSize;
        private int size;
        private double loadFactor;

        public QuadraticProbingHashMap(int size) {
            tableSize = size;
            table = new HashMap<>();
            this.size = 0;
            this.loadFactor = 0.7;
        }

        private int hash(int key, int ci) {
            return (key + ci * ci) % tableSize; // quadratic probing
        }

        public void insert(int key) {
            if (size + 1 > tableSize * loadFactor) resizeAndRehash();
            for (int ci = 0; ci < tableSize; ci++) {
                int index = hash(key, ci);
                if (!table.containsKey(index)) {
                    table.put(index, key);
                    size++;
                    System.out.println("Inserted " + key + " at index " + index);
                    return;
                }
            }
            System.out.println("Table is full! Cannot insert key: " + key);
        }

        private void resizeAndRehash() {
            int oldSize = tableSize;
            HashMap<Integer, Integer> oldTable = table;
            tableSize *= 2;
            table = new HashMap<>();
            size = 0;
            System.out.println("Quadratic Probing Resizing: " + oldSize + " -> " + tableSize);
            for (int idx : oldTable.keySet()) insert(oldTable.get(idx));
        }

        public boolean search(int key) {
            for (int ci = 0; ci < tableSize; ci++) {
                int index = hash(key, ci);
                if (!table.containsKey(index)) return false;
                if (table.get(index) == key) {
                    System.out.println("Found " + key + " at index " + index);
                    return true;
                }
            }
            return false;
        }

        public void delete(int key) {
            for (int ci = 0; ci < tableSize; ci++) {
                int index = hash(key, ci);
                if (!table.containsKey(index)) return;
                if (table.get(index) == key) {
                    table.remove(index);
                    size--;
                    System.out.println("Deleted " + key + " from index " + index);
                    return;
                }
            }
        }

        public void display() {
            System.out.println("\nQuadratic Probing Table:");
            for (int i = 0; i < tableSize; i++)
                System.out.println("Index " + i + " : " + table.getOrDefault(i, -1));
            System.out.println();
        }
    }

    /* ================= DOUBLE HASHING ================= */
    public static class DoubleHashingHashMap {
        private HashMap<Integer, Integer> table;
        private int tableSize;
        private int size;
        private double loadFactor;

        public DoubleHashingHashMap(int size) {
            tableSize = size;
            table = new HashMap<>();
            this.size = 0;
            this.loadFactor = 0.7;
        }

        private int hash1(int key) { return key % tableSize; }
        private int hash2(int key) { return 7 - (key % 7); }

        private int hash(int key, int ci) {
            return (hash1(key) + ci * hash2(key)) % tableSize;
        }

        public void insert(int key) {
            if (size + 1 > tableSize * loadFactor) resizeAndRehash();
            for (int ci = 0; ci < tableSize; ci++) {
                int index = hash(key, ci);
                if (!table.containsKey(index)) {
                    table.put(index, key);
                    size++;
                    System.out.println("Inserted " + key + " at index " + index);
                    return;
                }
            }
            System.out.println("Table is full! Cannot insert key: " + key);
        }

        private void resizeAndRehash() {
            int oldSize = tableSize;
            HashMap<Integer, Integer> oldTable = table;
            tableSize *= 2;
            table = new HashMap<>();
            size = 0;
            System.out.println("Double Hashing Resizing: " + oldSize + " -> " + tableSize);
            for (int idx : oldTable.keySet()) insert(oldTable.get(idx));
        }

        public boolean search(int key) {
            for (int ci = 0; ci < tableSize; ci++) {
                int index = hash(key, ci);
                if (!table.containsKey(index)) return false;
                if (table.get(index) == key) {
                    System.out.println("Found " + key + " at index " + index);
                    return true;
                }
            }
            return false;
        }

        public void delete(int key) {
            for (int ci = 0; ci < tableSize; ci++) {
                int index = hash(key, ci);
                if (!table.containsKey(index)) return;
                if (table.get(index) == key) {
                    table.remove(index);
                    size--;
                    System.out.println("Deleted " + key + " from index " + index);
                    return;
                }
            }
        }

        public void display() {
            System.out.println("\nDouble Hashing Table:");
            for (int i = 0; i < tableSize; i++)
                System.out.println("Index " + i + " : " + table.getOrDefault(i, -1));
            System.out.println();
        }
    }

    /* ================= PSEUDO-RANDOM PROBING ================= */
    public static class PseudoRandomProbingHashMap {
        private HashMap<Integer, Integer> table;
        private int tableSize;
        private int size;
        private double loadFactor;
        private int[] randSeq;

        public PseudoRandomProbingHashMap(int size) {
            tableSize = size;
            table = new HashMap<>();
            this.size = 0;
            this.loadFactor = 0.7;
            randSeq = new int[tableSize];
            Random r = new Random(42);
            for (int i = 0; i < tableSize; i++) randSeq[i] = r.nextInt(tableSize);
        }

        private int hash(int key, int ci) {
            return (key + randSeq[ci % tableSize]) % tableSize;
        }

        public void insert(int key) {
            if (size + 1 > tableSize * loadFactor) resizeAndRehash();
            for (int ci = 0; ci < tableSize; ci++) {
                int index = hash(key, ci);
                if (!table.containsKey(index)) {
                    table.put(index, key);
                    size++;
                    System.out.println("Inserted " + key + " at index " + index);
                    return;
                }
            }
            System.out.println("Table is full! Cannot insert key: " + key);
        }

        private void resizeAndRehash() {
            int oldSize = tableSize;
            HashMap<Integer, Integer> oldTable = table;
            tableSize *= 2;
            table = new HashMap<>();
            size = 0;
            randSeq = new int[tableSize];
            Random r = new Random(42);
            for (int i = 0; i < tableSize; i++) randSeq[i] = r.nextInt(tableSize);
            System.out.println("Pseudo-Random Resizing: " + oldSize + " -> " + tableSize);
            for (int idx : oldTable.keySet()) insert(oldTable.get(idx));
        }

        public boolean search(int key) {
            for (int ci = 0; ci < tableSize; ci++) {
                int index = hash(key, ci);
                if (!table.containsKey(index)) return false;
                if (table.get(index) == key) {
                    System.out.println("Found " + key + " at index " + index);
                    return true;
                }
            }
            return false;
        }

        public void delete(int key) {
            for (int ci = 0; ci < tableSize; ci++) {
                int index = hash(key, ci);
                if (!table.containsKey(index)) return;
                if (table.get(index) == key) {
                    table.remove(index);
                    size--;
                    System.out.println("Deleted " + key + " from index " + index);
                    return;
                }
            }
        }

        public void display() {
            System.out.println("\nPseudo-Random Table:");
            for (int i = 0; i < tableSize; i++)
                System.out.println("Index " + i + " : " + table.getOrDefault(i, -1));
            System.out.println();
        }
    }

    /* ================= DEMO ================= */
    public static void main(String[] args) {
        int[] keys = {21, 10, 32, 43, 54, 65, 87, 76};

        LinearProbingHashMap linear = new LinearProbingHashMap(5);
        QuadraticProbingHashMap quadratic = new QuadraticProbingHashMap(5);
        DoubleHashingHashMap doubleHash = new DoubleHashingHashMap(5);
        PseudoRandomProbingHashMap pseudoRandom = new PseudoRandomProbingHashMap(5);

        System.out.println("=== LINEAR PROBING ===");
        for (int k : keys) linear.insert(k);
        linear.display();

        System.out.println("=== QUADRATIC PROBING ===");
        for (int k : keys) quadratic.insert(k);
        quadratic.display();

        System.out.println("=== DOUBLE HASHING ===");
        for (int k : keys) doubleHash.insert(k);
        doubleHash.display();

        System.out.println("=== PSEUDO-RANDOM PROBING ===");
        for (int k : keys) pseudoRandom.insert(k);
        pseudoRandom.display();
    }
}
