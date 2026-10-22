package competitiveClub;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class wordOrdering{

    public static void main(String[] args) {
        


        Scanner sc = new Scanner(System.in);
        String input1 = "xyzabcopqrstuvwdefghijklmn";
        ArrayList<String> inputList = new ArrayList<>();
        inputList.add("pokemon");
        inputList.add("pokemons");

        HashMap<Character, ArrayList<String>> tracker = new HashMap<>();


        for(Character x: input1.toCharArray()){

            tracker.put(x, new ArrayList<>());
        }

        for(int i = 0; i < inputList.size(); i++){

            if(input.get(i).charAt(0))
        }
    }
}