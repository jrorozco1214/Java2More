package FinalsPractice;

import java.util.Arrays;

public class selectionSorting {

    public static void main(String[] args) {
    int []ar = {4, 7, 11, 4, 9, 5};
    
    for(int i = 0; i < ar.length; i++){
        int max = 0;
        
        for(int j = 0; j < ar.length-i; j++){
            if(ar[max] > ar[j]){
                max = j;
            }
        }

        int temp = ar[ar.length-i-1];
        ar[ar.length-i-1] = ar[max];
        ar[max] = temp;
    }

    System.out.println(Arrays.toString(ar));
    



    }
    
}
