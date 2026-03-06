
import java.math.BigInteger;
import java.util.Scanner;
public class factorialTrailingZero {
    public static void main(String[] args) {
        
        Scanner s = new Scanner(System.in);

        String num = s.next();

        BigInteger b = new BigInteger(num);

        BigInteger store = BigInteger.ONE;
        

        for(int i = 1; i <= b.longValue(); i++){


            store = store.multiply(new BigInteger(i + "")); //automatically converts i to a string in which allows us to multiple and store as a bigInteger because 
        //BigInteger by default is a string

        }

        String number = store.toString();

        int numberOfZeroes = 0;

        for(int i = number.length()-1; i >= 0; i--){

            if(number.charAt(i) == '0'){
                numberOfZeroes++;
            } else {
                break;
            }
        }
        System.out.println(numberOfZeroes);
    }
}
