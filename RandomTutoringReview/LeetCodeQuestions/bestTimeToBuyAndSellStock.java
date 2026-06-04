package LeetCodeQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class bestTimeToBuyAndSellStock {

    public static void main(String[] args) {

        System.out.println(maxProfit(new int[]{1}));
    }

    public static int maxProfit(int[] prices) {

        ArrayList<Integer> sell = new ArrayList<>();

        int last = prices[prices.length-1];
        sell.add(last);

        if(prices.length <= 1){
            return prices[0];
        }

        for(int i = prices.length-2; i >= 0; i--){

            if(last <= prices[i]){

                last = prices[i];
                sell.add(last);
            } else {

                sell.add(last);
            }
        }

        Collections.reverse(sell);
        sell.remove(0);

        System.out.println(Arrays.toString(prices));

        System.out.println(sell);
        
        ArrayList<Integer> result = new ArrayList<>();

        for(int i = 0; i < prices.length-1; i++){

            result.add(sell.get(i) - prices[i]);
        }

        System.out.println(result);
        
        int maxNum = Collections.max(result);

        if(maxNum <= 0){
            return 0;
        }

        return maxNum;
    }
}
