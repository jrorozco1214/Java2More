package LeetCodeQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class letterCombinationOfAPhoneNumber17 {
    public static void main(String[] args) {
        
        letterCombinations("47");
    }

    public static List<String> letterCombinations(String digits) {

        String[] possibleLetter = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        int[] maxIndices = {3,4};

        ArrayList<String> result = new ArrayList<>();

        String firstWord = "";


        int[] indexArr = new int[digits.length()];

        boolean keepGoing = true;

        while(keepGoing){

            System.out.println(Arrays.toString(indexArr));

            int i = digits.length()-1;

            keepGoing = incrementIndexArray(indexArr, maxIndices, i);

        }

        return null;
    }

    public static boolean incrementIndexArray(int[] currentIndex, int[] maxIndices, int i){

        if(i < 0){

            return false;
        }

        if(currentIndex[i]+1 < maxIndices[i]){

            currentIndex[i]++;
            return true;
        }
        

        currentIndex[i] = 0;

        return incrementIndexArray(currentIndex, maxIndices, i-1);
    }
    
}
