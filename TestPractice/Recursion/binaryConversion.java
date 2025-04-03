package TestPractice.Recursion;

public class binaryConversion {

    public static void main(String[] args) {
        System.out.print(binary(20));
    }
    
    public static String binary(int n){
        if(n == 0 || n < 0){
            return "";
        } else if(n % 2 == 0){
            return binary(n/2) + "0";
        } else {
            return  binary(n/2) + "1";
        }
    }
}
