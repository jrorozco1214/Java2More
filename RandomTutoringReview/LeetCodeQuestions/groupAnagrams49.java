package LeetCodeQuestions;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class groupAnagrams49 {
    public static void main(String[] args) {
        
        String[] input = {"eat","tea","tan","ate","nat","bat"};

        System.out.println(groupAnagrams(input));

    }

    public static List<List<String>> groupAnagrams(String[] strs) {

        char[][] cArray = new char[strs.length][];

        for(int i = 0; i < strs.length; i++){

            cArray[i] = strs[i].toCharArray();
            
            Arrays.sort(cArray[i]);
        }

        HashMap<String, ArrayList<String>> result = new HashMap<>();

        for(int i = 0; i < strs.length; i++){

            String s = new String(cArray[i]);

            if(!result.containsKey(s)) {
                ArrayList<String> temp = new ArrayList<>();
                temp.add(strs[i]);
                result.put(s, temp);
            } else {

                result.get(s).add(strs[i]);
            }
        }

        ArrayList<List<String>> result2 = new ArrayList<>(result.values());

        return result2;
    }
}