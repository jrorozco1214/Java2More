package LeetCodeQuestions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class longestConsecutiveSeq128 {

    public static void main(String[] args) {

        System.out.println(longestConsecutive(new int[]{
            
        }));
    }

    // public static int longestConsecutive(int[] nums) {

    //     HashMap<Integer, Boolean> map = new HashMap<>();

    //     for(Integer x: nums){

    //         map.put(x, false);
    //     }

    //     int maxRange = 0;

    //     for(Integer x: nums){
            

    //         if(map.get(x)){ //guard clause

    //             continue;
    //         }

    //         int lowest = x;

    //         while(map.containsKey(lowest-1)){

    //             map.put(lowest-1, true);
    //             lowest-=1;
    //         }

    //         int highest = x;

    //         while(map.containsKey(highest+1)){

    //             map.put(highest+1, true);
    //             highest+=1;
    //         }

    //         int range = highest+1-lowest;

    //         if(range > maxRange){
    //             maxRange = range;
    //         }
    //     }

    //     return maxRange;
    // }

    public static int longestConsecutive(int[] nums) {

        Set<Integer> set = new HashSet<>();

        for(Integer x: nums){

            set.add(x);
        }

        int maxRange = 0;

        for(Integer x: nums){
            

            if(set.contains(x-1)){ //guard clause

                continue;
            }

            int highest = x;

            while(set.contains(highest+1)){

                highest+=1;
            }

            int range = highest+1-x;

            if(range > maxRange){
                maxRange = range;
            }
        }

        return maxRange;
    } 
}
