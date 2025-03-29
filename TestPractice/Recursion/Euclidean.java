package TestPractice.Recursion;

public class Euclidean {

    public static void main(String[] args) {
        
    System.out.println(GCD(48, 18));


    }

    public static int GCD(int n1, int n2){
        if(n1 % n2 == 0){
            return n2;
        } else {
            int n3 = n1 % n2;

            return GCD(n1 = n2, n2 = n3);
        }
    }
    
}
