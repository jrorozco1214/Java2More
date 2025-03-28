package TestPractice.Recursion;

import java.util.Arrays;

public class FoldBalance {
    public static void main(String[] args) {
        
        int []ar = {1, 2, 3, 1, 2, 3};

        System.out.println(in(ar));

    }

    public static boolean in(int[] ar){
        return read(ar, 0, ar.length-1);
    }

    public static boolean read(int []ar, int start, int end){
    
    int total1 = ar[start] + ar[end-1];
    int total2 = ar[ar.length/2];

    if(start >= end || start == end){
        return true;
    } else if(ar.length % 2 == 0){
        if(ar[start] + ar[end-1] == total1){
            return read(ar, start+1, end-1);
        }
    } else {
        if(ar[start] + ar[end-1] == total2){
            return read(ar, start+1, end-1);
            }
        }
    return false;
    }  
}
