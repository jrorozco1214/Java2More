import java.util.ArrayList;
import java.math.BigInteger;

public class testMain {
    public static void main(String[] args) {

        System.out.println(fact(21));
    }

    public static BigInteger fact(int n){

        BigInteger fact = BigInteger.ONE;
        BigInteger total = BigInteger.valueOf(n);

        if(n <= 1){
            return fact;
        }

        return total.multiply(fact(n-1));
    }
}
                                         