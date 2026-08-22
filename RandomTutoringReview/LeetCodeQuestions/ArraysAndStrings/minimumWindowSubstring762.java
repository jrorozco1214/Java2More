package LeetCodeQuestions.ArraysAndStrings;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

import javax.xml.stream.events.Characters;

public class minimumWindowSubstring762 {

    public static void main(String[] args) {

        System.out.println(minWindow("a", "aa"));
    }

    public static String minWindow(String s, String t) {

        ArrayList<Character> seen = new ArrayList<>();
        ArrayList<Character> targetChars = new ArrayList<>();
        
        for(int i = 0; i < t.length(); i++){

            targetChars.add(t.charAt(i));
        }
        
        int left = 0;

        int minSize = Integer.MAX_VALUE;

        StringBuilder result = new StringBuilder();

        for(int right = 0; right < s.length(); right++){

            if(targetChars.contains(s.charAt(right)) && !seen.contains(s.charAt(right))) {
                
                seen.add(s.charAt(right));

            } else if(targetChars.contains(s.charAt(right)) && seen.contains(s.charAt(right))) {

                char needToRemove = s.charAt(right);

                for(int i = 0; i < seen.size(); i++){

                    if(seen.get(i) == needToRemove){

                        seen.remove(i);
                        break;
                    }
                }

                left++;

                while(!seen.contains(s.charAt(left))){

                    left++;
                }

                seen.add(needToRemove);
            }

            if(seen.size() >= t.length()){

                int resultLength = result.length();

                if(result.length() <= 0) {

                    result.append(s.substring(left, right+1));
                    minSize = Math.min(minSize, result.length());
                } else if(right - left + 1 < minSize) {

                    result.delete(0, result.length());
                    result.append(s.substring(left, right+1));
                    minSize = Math.min(minSize, resultLength);
                }

                for(int i = 0; i < seen.size(); i++){

                    if(seen.get(i) == s.charAt(left)){

                        seen.remove(i);
                    }
                }

                boolean keepGoing = true;
                left++;

                if(left >= s.length()) {

                    break;
                }

                while(keepGoing) {

                    if(targetChars.contains(s.charAt(left))){

                        keepGoing = false;
                    } else {

                        left++;
                    }
                }
            }
        }

        if(result.length() <= 0) {

            return "";
        }

        return result.substring(0);
    }
}
