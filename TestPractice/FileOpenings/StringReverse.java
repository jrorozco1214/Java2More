package TestPractice.FileOpenings;

public class StringReverse {

    public static void main(String[] args) {
    
    System.out.println(reverse("character"));
    }

    public static String reverse(String h){
        if(h.length() == 0){
            return h;
        } else {
            return h.charAt(h.length() - 1) + reverse(h.substring(0, h.length()-1));
        }
    }
}
