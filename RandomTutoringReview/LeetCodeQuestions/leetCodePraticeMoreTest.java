package LeetCodeQuestions;
import java.util.Collections;
import java.util.HashMap;

public class leetCodePraticeMoreTest {

    public static void main(String[] args) {

        maxRotateFunction(new int[] {4,3,2,6});
    }

    public static int maxRotateFunction(int[] nums){

        HashMap<Integer, Integer> results = new HashMap<>();
        int total = 0;
        int store;

        for(int i = 0; i < nums.length; i++){
            
            for(int j = 0; j < nums.length; j++){

                total += j * nums[j];
            }

            results.put(i, total);

            total = 0;
            
            store = nums[nums.length-1];

            for(int z = nums.length-1; z >= 0; z--){

                if(z == 0){
                    nums[0] = store;

                } else {
                    nums[z] = nums[z-1];

                }
            }
        }

        System.out.println(Collections.max(results.values()));


        return 0;
    }
    
}
