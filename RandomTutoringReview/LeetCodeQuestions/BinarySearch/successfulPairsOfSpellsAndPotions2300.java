package LeetCodeQuestions.BinarySearch;

import java.util.Arrays;

public class successfulPairsOfSpellsAndPotions2300 {
    
    public static void main(String[] args) {

        System.out.println(successfulPairs(new int[]{5,1,3}, new int[]{1,2,3,4,5}, 7));
    }

    public static int[] successfulPairs(int[] spells, int[] potions, long success) {

        Arrays.sort(potions);
        int[] ans = new int[spells.length];
        int m = potions.length;
        
        for (int i = 0; i < spells.length; i++) {

            int j = binarySearch(potions, success / (double) spells[i]);
            ans[i] = m - j;
        }
        
        return ans;
    }

    public static int binarySearch(int[] potions, double target) {
        int left = 0;
        int right = potions.length;

        while (left < right) {

            int mid = left + (right - left) / 2;

            if (potions[mid] >= target) {

                right = mid;
            } else {

                left = mid + 1;
            }
        }

        return left;
    }
    
}
