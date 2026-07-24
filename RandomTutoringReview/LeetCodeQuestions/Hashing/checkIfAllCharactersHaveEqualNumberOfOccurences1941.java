package LeetCodeQuestions.Hashing;

import java.util.HashMap;
import java.util.HashSet;

public class checkIfAllCharactersHaveEqualNumberOfOccurences1941 {

    public static void main(String[] args) {

        System.out.println(areOccurrencesEqual("abcabc"));
    }

    public static boolean areOccurrencesEqual(String s) {

        HashMap<Character, Integer> map = new HashMap<>();

        for(Character ch: s.toCharArray()){

            map.put(ch, map.getOrDefault(ch, 0)+1);
        }

        HashSet<Integer> freq = new HashSet<>(map.values());

        return freq.size() == 1;
    }
}
