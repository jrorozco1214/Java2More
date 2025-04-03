package TestPractice.Recursion;

public class RecursionPractice {

    public static void main(String[] args) {
        System.out.println(printN(5));
    }

    public static int printN(int n){
        if(n == 1){
            return 1;
        }
        System.out.println(n);
        return printN(n-1);
    }
}
