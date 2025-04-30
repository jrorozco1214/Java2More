package FilesPractice;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class FinalPractice {

    public static void main(String[] args) {
    
    int ar[] = {6, 3 , 9, 2, 1, 5};
    
    for(int i = 0; i < ar.length; i ++){
        int max = 0;

        for(int j = 0; j < ar.length-i; j++){
            if(ar[max] < ar[j]){
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
