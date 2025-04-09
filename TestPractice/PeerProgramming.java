package TestPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class PeerProgramming {
        public static void main(String[] args)
        {
           int[] arr1 = {1, 5, 2, 4, 2, 3, 5, 1, 4, 6};
           int[] arr2 = uniqueElements(arr1);
           System.out.println(Arrays.toString(arr1) );
           System.out.println(Arrays.toString(arr2) );
        }
     
     
        public static int[] uniqueElements(int[] arr)
        {
           ArrayList<Integer> uniques = new ArrayList<>();
     
             uniques.add(0);
     
             for (int i = 1; i < arr.length; i++) {
                 boolean there = false;
                 for (int j = 0; j < i; j++) {
                     if (arr[i] == arr[j]) {
                         there = true;
                         break; 
                     }
                 }
                 if (!there) {
                     uniques.add(arr[i]);
                 }
             }
     
             int[] finalArray = new int[uniques.size()];
     
             for (int i = 0; i < uniques.size(); i++) {
                 finalArray[i] = uniques.get(i);
             }
     
             return finalArray;
           
        }

    }
