package TestPractice.Recursion;

import java.util.ArrayList;

public class primeFactorsList {
    public static void main(String[] args) {
    
    factors(16, 1);    
    
    }

    public static void  factors(int n, int start){

        if(start == n){
           return;
        } else if (n % start == 0){
            System.out.println(start);
        }
        factors(n, start+1);
    }
    
}
