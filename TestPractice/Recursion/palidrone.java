package TestPractice.Recursion;

public class palidrone {

    public static void main(String[] args) {
    
    System.out.priln(Pal("racecar"));

    }

    public static boolean Pal(String s){
        if(s.length() == 0 || s.length() == 1){
            return true;
        } else if(s.charAt(0) != s.charAt(s.length() - 1)){
            return false;
        } 
        return Pal(s.substring(1, s.length()-1));
    }    
}
