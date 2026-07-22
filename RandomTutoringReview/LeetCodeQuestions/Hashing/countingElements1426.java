package LeetCodeQuestions.Hashing;

import java.util.HashMap;
import java.util.HashSet;

import TestPractice.Recursion.ar;

public class countingElements1426 {

    public static void main(String[] args) {

        System.out.println(countElements(new int[]{1,3,2,3,5,0}));
    }

    public static int countElements(int[] arr){

        HashMap<Integer,Integer> countOfVal = new HashMap<>();

        for(int i = 0; i < arr.length; i++){

            countOfVal.put(arr[i], 0);
        }
        
        for(int i = 0; i < countOfVal.size();i++){

            if(countOfVal.containsKey(arr[i])){

                countOfVal.get(arr[i]+1);
            }
        }


        return 0;
    }
}
