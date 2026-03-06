
import java.math.BigInteger;
import java.util.Scanner;
public class factorialTrailingZeroOPT {
    public static void main(String[] args) {
        
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();

        int store = 0;

        for(int i = 1; i <= n; i++){
            if(i % 25 == 0){ //checking to see if factor of 25 if it is add 2 because you have 2 extra factors of 5 in 25
                store+=2;
            } else if(i % 5 == 0){
                store+=1;
            }
        }
        System.out.println(store);


        /*
        simplier way to do thsi is 
        int totalZeroes = n / 25 + n / 5
        the reason again that we're checking this is because for the factor of 25 it contributes one extra multiple of 5 and the factor 5 only contribute one
        but in this case we only want to take into consideration only the extras of 25 
        
        */
    }
}
