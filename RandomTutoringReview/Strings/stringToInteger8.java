package Strings;

public class stringToInteger8 {

    public static void main(String[] args) {
        
        System.out.println(myAtoi(" -042"));
        System.out.println(myAtoi("1337c0d3"));
        System.out.println(myAtoi("0-1"));
        System.out.println(myAtoi("words and 987"));
    }

    public static int myAtoi(String s) {

        char space = ' ';
        int index = 0;
        boolean isNegative = false;
        // int maxRange = Integer.MAX_VALUE;
        // int minRange = Integer.MIN_VALUE;

        for(;index < s.length(); index++){

            if(s.charAt(index) != space){

                break;
            }
        }

        if(index >= s.length()){

            return 0;
        }

        if(s.charAt(index) == '-'){

            isNegative = true;
            index++;
        } else if(s.charAt(index) == '+'){

            index++;
        }

        int runningTotal = 0;

        for(; index < s.length(); index++){

            int digit = s.charAt(index) - '0';

            if(digit >= 0 && digit <= 9){

                System.out.println("runningTotal = " + runningTotal + " * 10 + " + digit);
                runningTotal = (runningTotal*10) + digit;
                System.out.println("runningTotal = " + runningTotal);


            } else {

                break;
            }
        }

        if(isNegative){

            return -1 * runningTotal;
        }


        return runningTotal;
    }
}
