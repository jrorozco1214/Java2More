package TestPractice.Recursion;

public class RecursionPractice {

    public static void main(String[] args) {
        System.out.println(factor(20, 1));
    }

    public static int factor(int n, int f){
        if(n == f){
            return n;
        } else if(n % f == 0){
            System.out.println(f);
            return factor(n, f+1);
        } else {
            return factor(n, f+1);
        }
    }
}
