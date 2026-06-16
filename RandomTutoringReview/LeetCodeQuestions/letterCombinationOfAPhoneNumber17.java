package LeetCodeQuestions;

import java.util.HashMap;
import java.util.List;

public class letterCombinationOfAPhoneNumber17 {
    public static void main(String[] args) {
        
        letterCombinations("23");
    }

    public static List<String> letterCombinations(String digits) {

        HashMap<Integer, String> letters = new HashMap<>();

        int keyIndex = 2;
        int counter = 0;

        String lettersTogether = "";

        for(char ch = 'a'; ch <= 'z'; ch++){

            if(keyIndex == 7){

                lettersTogether = "pqrs";
                ch = 't';
                letters.put(keyIndex, lettersTogether);
                keyIndex++;
                counter = 0;
                lettersTogether = "";
            } else if(keyIndex == 9){

                lettersTogether = "wxyz";
                ch = 'z';
                letters.put(keyIndex, lettersTogether);
                keyIndex++;
                counter = 0;
                lettersTogether = "";
            } else if(counter >= 3){

                letters.put(keyIndex, lettersTogether);
                lettersTogether = "";
                keyIndex++;
                counter = 0;
            }
        
            lettersTogether = lettersTogether + ch;

            counter++;
        }

        return null;
    }
    
}
