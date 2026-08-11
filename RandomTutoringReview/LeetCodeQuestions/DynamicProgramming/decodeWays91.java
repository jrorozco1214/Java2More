package LeetCodeQuestions.DynamicProgramming;


public class decodeWays91{

    public static void main(String[] args) {

        System.out.println(numDecodings("2007"));
    }


    public static int numDecodings(String s) {

        int[] count = new int[s.length()+1];

        if(s.length() <= 0) {

            return 1;
        } else if(s.charAt(0) == '0') {

            return 0;
        }

        count[0] = 1;
        count[1] = 1;

        for(int i = 2; i < count.length; i++){

            int currentDigit = s.charAt(i-1) - '0';
            int previousDigit = s.charAt(i-2) - '0';

            int combined = previousDigit * 10 + currentDigit;

            if(currentDigit > 0) {

                count[i] += count[i-1];
            }

            if(previousDigit > 0 && combined <= 26) {

                count[i] += count[i-2];
            }
        }


        return count[s.length()];
    }
}