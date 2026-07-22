package LeetCodeQuestions.Hashing;

import java.util.HashSet;

public class checkIfTheSentenceIsPangram1832 {

    public static void main(String[] args) {
        
        System.out.println(checkIfPangram("leetcode"));
    }

    public static boolean checkIfPangram(String sentence){

        HashSet<Character> letters = new HashSet<>();

        for(Character x: sentence.toCharArray()){

            letters.add(x);
        }
        

        return letters.size() == 26;
    }
    
}
