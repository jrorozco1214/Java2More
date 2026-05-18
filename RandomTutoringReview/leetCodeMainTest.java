import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.*;

public class leetCodeMainTest {

    public static void main(String[] args) {

        int[] nums = {-1,0,1,2,-1,-4};

        ArrayList<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        int j = 1;
        int k = nums.length-1;

        for(int i = 0; i < nums.length; i++){

            while(j <= k){

                if(j == k){
                    j = 1;
                    break;
                }

                if(nums[i] + nums[j] + nums[k] == 0){

                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    
                } else if(nums[i] + nums[j] + nums[k] > 0) {
                    k--;
                } else {
                    j++;
                }
            }

            j = j+1;
        }

        System.out.println(result);
    }
}
