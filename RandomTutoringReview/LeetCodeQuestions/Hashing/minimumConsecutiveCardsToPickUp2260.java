package LeetCodeQuestions.Hashing;

import java.util.ArrayList;
import java.util.HashMap;

public class minimumConsecutiveCardsToPickUp2260 {

    public static void main(String[] args) {

        System.out.println(minimumCardPickup(new int[]{77,10,11,51,69,83,33,94,0,42,86,41,65,40,72,8,53,31,43,22,9,94,45,80,40,0,84,34,76,28,7,79,80,93,20,82,36,74,82,89,74,77,27,54,44,93,98,44,39,74,36,9,22,57,70,98,19,68,33,68,49,86,20,50,43}));
    }

    public static int minimumCardPickup(int[] cards) {

        HashMap<Integer, ArrayList<Integer>> cardCount = new HashMap<>();

        int ans = Integer.MAX_VALUE;
    

        for(int i = 0; i < cards.length; i++){

            if(!cardCount.containsKey(cards[i])){

                cardCount.put(cards[i], new ArrayList<>());
            }
            cardCount.get(cards[i]).add(i);

        }

        System.out.println(cardCount);

        for(Integer keys: cardCount.keySet()){

            ArrayList<Integer> keyList = new ArrayList<>(cardCount.get(keys));

            if(keyList.size() > 1){

                for(int j = 0; j < keyList.size()-1; j++){
                    
                    ans = Math.min(ans, keyList.get(j+1)-keyList.get(j)+1);
                }
            }
        }

        if(ans == Integer.MAX_VALUE){

            return -1;
        }

        System.out.println(ans);

        return ans;
    }
}
