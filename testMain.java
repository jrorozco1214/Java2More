import java.util.ArrayList;
import java.math.BigInteger;
import java.util.Scanner;

public class testMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Please enter in a number: ");
        int n = sc.nextInt();

        System.out.println(fact(n));

        sc.close();
    }

    public static BigInteger fact(int n){

        BigInteger fact = BigInteger.ONE; //this by default will be 1
        BigInteger total = BigInteger.valueOf(n); //this will be your factorial and when it gets to the if 
        //then it will return the fact which is 1

        if(n <= 1){
            return fact;
        }

        return total.multiply(fact(n-1));
    }
}
                                         