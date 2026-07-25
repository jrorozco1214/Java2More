package LeetCodeQuestions.Hashing;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public class maximumNumberOfBallons1189 {

    public static void main(String[] args) {

        System.out.println(maxNumberOfBalloons("balon"));
    }

    public static int maxNumberOfBalloons(String text) {

        HashMap<Character,Integer> charCount = new HashMap<>();
        charCount.put('b', 0);
        charCount.put('a', 0);
        charCount.put('l', 0);
        charCount.put('o', 0);
        charCount.put('n', 0);

        int otherL = 0;
        int otherO = 0;

        for(Character x: text.toCharArray()){

            if(charCount.containsKey(x)){

                if(x == 'l' && charCount.get(x) > otherL) {

                    otherL++;
                } else if(x == 'o' && charCount.get(x) > otherO){

                    otherO++;
                } else {

                    charCount.put(x, charCount.getOrDefault(x, 0)+1);
                }
            }
        }

        HashSet<Integer> appeareance = new HashSet<>();

        for(Integer x: charCount.values()){

            appeareance.add(x);
        }

        appeareance.add(otherL);
        appeareance.add(otherO);

        return Collections.min(appeareance);
    }
}
