package LeetCodeQuestions.ArraysAndStrings;

import TestPractice.Recursion.ar;

public class stringTest {

    public static void main(String[] args) {
        

        // String s = "oewurweiour";

        // //System.out.println(isPal(s));

        // int[] ar1 = {1,4,7,20};
        // int[] ar2 = {3,5,6};

        // int[] result = combineArr(ar1, ar2);

        // for(Integer x: result){

        //     System.out.println(x);
        // }

        //System.out.println(combineArr(new int[]{1,4,7,20}, new int[]{3,5,6}));

        System.out.println(findLength(new int[]{3,1,2,7,4,2,1,1,5}, 8));

        
    }


    public static boolean isPal(String s){

        int i = 0;
        int j = s.length()-1;

        while(i <= j){

            if(s.charAt(i) != s.charAt(j)){

                return false;
            }

            ++i;
            --j;
        }

        return true;
    }

    public static int[] combineArr(int[] ar1, int[] ar2){

        int[] result = new int[ar1.length + ar2.length];

        int i = 0;
        int j = 0;
        int index = 0;

        while(i < ar1.length && j < ar2.length){

            if(ar1[i] < ar2[j]){

                result[index] = ar1[i];
                index++;
                i++;
            }

            if(ar1[i] > ar2[j]) {

                result[index] = ar2[j];
                index++;
                j++;
            }
        }

        while(i < ar1.length){

            result[index] = ar1[i];
            i++;
            index++;
        }

        while(j < ar2.length){

            result[index] = ar2[j];
            j++;
            index++;
        }

        return result;
    }

    public static int findLength(int[]nums, int k){

        int left = 0;
        int curr = 0;
        int answer = 0;

        for(int right = 0; right < nums.length; right++){

            curr += nums[right];

            while (curr > k) {

                curr -= nums[left];
                left++;
            }

            answer = Math.max(answer, right - left + 1);
        }

        return answer;
    }
}
