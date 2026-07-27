package LeetCodeQuestions.Hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class groupAnagrams49 {

    public static void main(String[] args) {

        System.out.println(groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"}));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String, ArrayList<String>> anagrams = new HashMap<>();

        for(String x: strs){

            char[] characterOfWord = x.toCharArray();

            Arrays.sort(characterOfWord);

            String word = String.valueOf(characterOfWord);

            if(!anagrams.containsKey(word)){

                ArrayList<String> temp = new ArrayList<>();
                temp.add(x);
                anagrams.put(word, temp);
            } else {
                
                anagrams.get(word).add(x);
            }
        }

        List<List<String>> result = new ArrayList<>(anagrams.values());
        

        return result;
    }
}
