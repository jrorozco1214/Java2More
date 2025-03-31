package TestPractice.Recursion;

public class binaryConversion {

    public static void main(String[] args) {
        System.out.print(binary(45));
    }
    
    public static String binary(int n){
        if(n == 0 || n < 0){
            return "";
        } else if(n % 2 == 0){
            return "0" + binary(n/2);
        } else {
            return "1" + binary(n/2);
        }
    }
}
