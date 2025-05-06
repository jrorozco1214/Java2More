package FinalsPractice;
import java.util.ArrayList;


public class ArrayListPractice {
    public static void main(String[] args) {
    ArrayList <Integer> in = new ArrayList<>();

    for(int i = 1; i < 21; i++){
        in.add(i);
    }
    in.remove(0);
    for(Integer is: in){
        System.out.print(is + " ");
    }
    /* 
    System.out.println();
    in.remove(0);
    in.add(0, 15);

    for(Integer is: in){
        System.out.print(is + " ");
    }
    */
    }
    
}
