package DataStructures;
import java.util.NoSuchElementException;

// Interface declaration (assumed)
interface List {
    void clear();
    boolean insert(Object it);
    boolean append(Object it);
    Object remove() throws NoSuchElementException;
    void moveToStart();
    void moveToEnd();
    void prev();
    void next();
    int length();
    int currPos();
    boolean moveToPos(int pos);
    boolean isAtEnd();
    Object getValue() throws NoSuchElementException;
    boolean isEmpty();
}

// AList implementation
public class AList implements List {
    private Object listArray[];             
    private static final int DEFAULT_SIZE = 10; 
    private int maxSize;                    
    private int listSize;                   
    private int curr;                       

    // Constructors
    AList(int size) {
        maxSize = size;
        listSize = curr = 0;
        listArray = new Object[size];
    }

    AList() {
        this(DEFAULT_SIZE);
    }

    public void clear() {
        listSize = curr = 0;
    }

    public boolean insert(Object it) {
        if (listSize >= maxSize) { //3 4
            return false;
        }
        for (int i = listSize; i > curr; i--) //4 > 1 
            listArray[i] = listArray[i - 1];
        listArray[curr] = it;
        listSize++;
        return true;
    }

    public boolean append(Object it) {
        if (listSize >= maxSize) {
            return false;
        }
        listArray[listSize++] = it;
        return true;
    }

    public Object remove() throws NoSuchElementException {
        if ((curr < 0) || (curr >= listSize))
            throw new NoSuchElementException("remove() in AList has current of " + curr + " and size of " + listSize);
        Object it = listArray[curr];
        for (int i = curr; i < listSize - 1; i++)
            listArray[i] = listArray[i + 1];
        listSize--;
        return it;
    }

    public void moveToStart() { 
        curr = 0; 
    }
    public void moveToEnd() { 
        curr = listSize; 
    }
    public void prev() { 
        if (curr != 0) 
        curr--; 
    }
    public void next() { 
        if (curr < listSize) 
        curr++; 
    }
    public int length() { 
        return listSize; 
    }
    public int currPos() { 
        return curr; 
    }

    public boolean moveToPos(int pos) {
        if ((pos < 0) || (pos > listSize)) return false;
        curr = pos;
        return true;
    }

    public boolean isAtEnd() { 
        return curr == listSize; 
    }

    public Object getValue() throws NoSuchElementException {
        if ((curr < 0) || (curr >= listSize))
            throw new NoSuchElementException("getValue() in AList has current of " + curr + " and size of " + listSize);
        return listArray[curr];
    }

    public boolean isEmpty() { 
        return listSize == 0; 
    }

    // ---------------- MAIN METHOD ----------------
    public static void main(String[] args) {
        AList myList = new AList(5);  // Create list with capacity 5

        System.out.println("Appending elements:");
        myList.append("A");
        myList.append("B");
        myList.append("C");
        printList(myList);

        System.out.println("\nInserting 'X' at current position:");
        myList.moveToPos(1);  // Move to position 1
        myList.insert("X");
        printList(myList);
      //  System.out.println("Current position: " + myList.currPos());
        
        System.out.println("\nRemoving current element:");
//     myList.moveToPos(1);
        Object removed = myList.remove();
        System.out.println("Removed: " + removed);
        printList(myList);

        System.out.println("\nMoving to end and appending 'D':");
        myList.moveToEnd();
        myList.append("D");
        printList(myList);

        System.out.println("\nMoving to start and displaying current value:");
        myList.moveToStart();
        System.out.println("Current value: " + myList.getValue());

        System.out.println("\nIs list empty? " + myList.isEmpty());
        System.out.println("Current position: " + myList.currPos());
        System.out.println("List length: " + myList.length());
    }

    // Helper method to print list contents
    private static void printList(AList list) {
        System.out.print("List: [");
        for (int i = 0; i < list.length(); i++) {
            list.moveToPos(i);
            System.out.print(list.getValue());
            if (i != list.length() - 1) System.out.print(", ");
        }
        System.out.println("]");
    }
}