package LeetCodeQuestions.ArraysAndStrings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class repeatedDNASeqs187 {

    public static void main(String[] args) {

        System.out.println(findRepeatedDnaSequences("AAAAAAAAAAAAA"));
    }

    public static List<String> findRepeatedDnaSequences(String s) {

        HashSet<String> seen = new HashSet<>();
        HashSet<String> output = new HashSet<>();

        int left = 0;

        String addWord = "";

        for(int right = 0; right < s.length(); right++) {

            addWord = addWord + s.charAt(right);
            
            while(addWord.length() >= 10) {

                if(seen.contains(addWord)) {

                    output.add(addWord);
                }
                
                seen.add(addWord);
                addWord = addWord.substring(1);
                left++;
            }

        }

        return new ArrayList<String>(output);
    }
    
}
