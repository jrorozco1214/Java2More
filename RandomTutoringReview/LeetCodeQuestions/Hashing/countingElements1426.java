package LeetCodeQuestions.Hashing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class countingElements1426 {

    public static void main(String[] args) {

        System.out.println(countElements(new int[]{1,3,2,3,5,0}));
    }

    public static int countElements(int[] arr){
    
        Set<Integer> hashSet = new HashSet<>();
        for (int x : arr) {
            hashSet.add(x);
        }
        int count = 0;
        for (int x : arr) {
            if (hashSet.contains(x + 1)) {
                count++;
            }
        }
        return count;
    }
}
