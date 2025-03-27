package TestPractice.Recursion;

public class ReverseString {

    public static void main(String[] args) {
        
        System.out.println(reverse("Hello!"));

    }

    public static String reverse(String str){

        if(str.length() == 0){
            return str;
        } else {

            return str.charAt(str.length()-1) + reverse(str.substring(0, str.length()-1));
        }


    }
    
}
