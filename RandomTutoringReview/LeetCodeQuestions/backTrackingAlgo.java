package LeetCodeQuestions;
import java.util.ArrayList;
import java.util.List;

public class backTrackingAlgo {

    public static void main(String[] args) {

        System.out.println(subsets(new int[]{1,2,3}));
    }

    public static List<List<Integer>> subsets(int[] nums){

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        backTrack(0, current, nums, result);

        return result;
    }

    public static void backTrack(int index, List<Integer> current, int[] nums, List<List<Integer>> result){

        if(index == nums.length){
            result.add(new ArrayList<>(current));
            return;
        }

        current.add(nums[index]);
        backTrack(index+1, current, nums, result);
        current.remove(current.size()-1);
        backTrack(index+1, current, nums, result);
    }
}
