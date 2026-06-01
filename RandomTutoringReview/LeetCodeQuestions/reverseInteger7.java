package LeetCodeQuestions;
public class reverseInteger7 {

    public static void main(String[] args) {


        System.out.println(reverse(-2147483648));
    }


    public static int reverse(int x) {


        long conversion = x;

        String stringCopy = Long.toString(conversion);

        long copyInt = x;
        
        if(x < 0) {

            copyInt = -1 * copyInt;
            stringCopy = stringCopy.substring(1);
        }

        String temp = "";
        int loop = stringCopy.length();

        for(int i = 0; i < loop; i++){
            long y = copyInt % 10;
            temp+= y;
            copyInt = copyInt / 10;
        }

        long result;
        int newReturn;

        if(x < 0){

            result = -1 * (Long.parseLong(temp));
            
        } else {
            result = Long.parseLong(temp);
        }

        if(result > Math.pow(2, 31)-1 || result < Math.pow(-2, 31)){

            return 0;
        } else {
            newReturn = (int)result;
        }
        

        return newReturn;
    }
}