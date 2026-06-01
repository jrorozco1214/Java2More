package LeetCodeQuestions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.*;

public class leetCodeMainTest {

    public static void main(String[] args) {

        int []test = {-1,0,1,2,-1,4};

        System.out.println(threeSum(test));

    }

    public static List<List<Integer>> threeSum(int[] nums) {

        ArrayList<List<Integer>> result = new ArrayList<>();

        for(int i =  0; i < nums.length; i++){

            for(int j = i + 1; j < nums.length; j++){

                for(int k = j + 1; k < nums.length; k++){

                    if(nums[i] + nums[j] + nums[k] == 0){

                        result.add(List.of(nums[i], nums[j], nums[k]));
                    }
                }
            }
        }


        //lambda function that will compare each using comparator 
        Comparator <List<Integer>> compare =  (List<Integer> l1, List<Integer> l2) -> {
            
            for(int i = 0; i < 3; i++){

                if(l1.get(i) == l2.get(i)){
                    continue;
                } else if(l1.get(i) > l2.get(i)){
                    return 1;
                } else {
                    return -1;
                }
            }

            return 0;
        };

        Collections.sort(result, compare);


        return result;
    }
}
