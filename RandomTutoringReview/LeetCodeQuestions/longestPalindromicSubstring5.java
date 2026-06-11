package LeetCodeQuestions;

import java.util.Collections;
import java.util.HashMap;

public class longestPalindromicSubstring5 {

    public static void main(String[] args) {

        System.out.println(longestPalindrome("ac"));
    }

    public static String longestPalindrome(String s) {

        if(s.length() <= 1) {
            
            return s;
        }

        HashMap<Integer, String> result = new HashMap<>();

        for(int i = 0; i < s.length(); i++){

            for(int j = i+1; j < s.length(); j++){

                if(s.charAt(i) == s.charAt(j)){

                    String temp = s.substring(i, j+1);

                    int end = temp.length()-1;

                    for(int k = 0; k < temp.length(); k++){

                        if(k >= end){
                            result.put(temp.length(), temp);
                            break;

                        } else if(temp.charAt(k) == temp.charAt(end)) {

                            end--;
                        } else if(temp.charAt(k) != temp.charAt(end)){

                            break;
                        }
                    }
                }
            }
        }

        if(result.keySet().isEmpty()){
            return s.substring(0, 1);
        }

        int maxValue = Collections.max(result.keySet());

        return result.get(maxValue);
    } 
}
