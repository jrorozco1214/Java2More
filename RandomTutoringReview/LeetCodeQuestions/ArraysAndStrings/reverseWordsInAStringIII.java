package LeetCodeQuestions.ArraysAndStrings;

import java.util.ArrayList;

public class reverseWordsInAStringIII {

    public static void main(String[] args) {


        System.out.println(reverseWords("Let's take LeetCode contest"));
    }

    public static String reverseWords(String s) {

        int left = 0;

        ArrayList<String> allWords = new ArrayList<>();

        for(int right = left; right < s.length(); right++){

            if(s.charAt(right) == ' ') {

                String resultString = "";

                while(left < right) {

                    resultString = s.charAt(left) + resultString;
                    left++;
                }

                resultString = resultString + " ";

                allWords.add(resultString);
                left++;
            } else if(right == s.length() - 1) {

                String resultString = "";

                while(left <= right) {

                    if(left == ' ') {

                        resultString = " ";
                    }

                    resultString =  s.charAt(left) + resultString;
                    left++;
                }

                allWords.add(resultString);
            }
        }

        String finalResult = "";

        for(String x: allWords) {

            finalResult = finalResult + x;
        }
        

        return finalResult;
    }
}
