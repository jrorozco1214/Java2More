package TestPractice.Recursion;

public class March24 {

    public static void main(String[] args) {
        
    System.out.println(replace(3, "elephants"));
    }

    public static String replace(int n, String s){
        if(n == 0){
            return s;
        }
        return "-" + replace(n-1,s.substring(1));
    }
    
}
