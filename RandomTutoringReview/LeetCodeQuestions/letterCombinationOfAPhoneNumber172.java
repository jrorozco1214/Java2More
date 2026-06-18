package LeetCodeQuestions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class letterCombinationOfAPhoneNumber172 {
    public static void main(String[] args) {
        
    }

    public List<String> letterCombinations(String digits) {

        Map<Character, String> letters = Map.of(
            '2',
            "abc",
            '3',
            "def",
            '4',
            "ghi",
            '5',
            "jkl",
            '6',
            "mno",
            '7',
            "pqrs",
            '8',
            "tuv",
            '9',
            "wxyz"
        );

        int index = 0;
        ArrayList<String> current = new ArrayList<>();
        ArrayList<String> result = new ArrayList<>();

        StringBuilder path = null;
        backTrack(index, path, result, digits, letters);
        return result;
    }

    public void backTrack(int index, StringBuilder path, ArrayList<String> result, String digits, Map<Character,String> letters){


        if(path.length() == digits.length()){

            result.add(path.toString());

            return;
        }
        String pLetters = letters.get(digits.charAt(index));

        for(Character x: pLetters.toCharArray()){

            path.append(x);
            backTrack(index+1, path, result, digits, letters);

            path.deleteCharAt(path.length()-1);
        }
    }
}
