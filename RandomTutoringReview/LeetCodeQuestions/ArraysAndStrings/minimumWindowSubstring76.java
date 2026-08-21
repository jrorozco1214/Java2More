package LeetCodeQuestions.ArraysAndStrings;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

import javax.xml.stream.events.Characters;

public class minimumWindowSubstring76 {

    public static void main(String[] args) {

        minWindow("ADOBECODEBANC", "ABC");
    }

    public static String minWindow(String givenString, String target) {

        ArrayList<Character> seen = new ArrayList<>();
        int left = 0;

        int minSize = Integer.MAX_VALUE;

        StringBuilder result = new StringBuilder();
        StringBuilder leftLetterCheck = new StringBuilder();
        StringBuilder rightLetterCheck = new StringBuilder();

        for(int right = 0; right < givenString.length(); right++){

            rightLetterCheck.append(givenString.charAt(right));

            if(target.contains(rightLetterCheck) && !seen.contains(givenString.charAt(right))) {
                
                rightLetterCheck.deleteCharAt(0);
                seen.add(givenString.charAt(right));

            } else if(target.contains(rightLetterCheck) && seen.contains(givenString.charAt(right))) {

                char needToRemove = rightLetterCheck.charAt(0);
                seen.remove(needToRemove);
                rightLetterCheck.deleteCharAt(0);
            } else {

                rightLetterCheck.deleteCharAt(0);

            }

            if(seen.size() >= target.length()){

                int resultLength = result.length();

                if(resultLength <= 0) {

                    result.append(givenString.substring(left, right+1));
                    minSize = Math.min(minSize, resultLength);
                } else if(resultLength < minSize) {

                    result.delete(0, result.length());
                    result.append(givenString.substring(left, right+1));
                    minSize = Math.min(minSize, resultLength);
                }

                while(seen.size() >= target.length()) {

                    leftLetterCheck.append(givenString.charAt(left));

                    if(target.contains(leftLetterCheck) && seen.contains(givenString.charAt(right))){

                        for(int i = 0; i < seen.size(); i++){

                            if(seen.get(i) == leftLetterCheck.charAt(0)){

                                seen.remove(i);
                                break;
                            }
                        }
                        leftLetterCheck.deleteCharAt(0);
                        left++;
                    } else {

                        left++;
                    }
                }
            }
        }

        return result.substring(0);
    }
    
}
