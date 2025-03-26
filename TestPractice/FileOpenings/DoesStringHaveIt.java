package TestPractice.FileOpenings;

public class DoesStringHaveIt {
    public static void main(String[] args) {
        


    }

    public static boolean find(String text, String str){
    
        if(str.length() == 0){
            return true;
        } else if(text.charAt(0) == str.charAt(0)){
            return str.charAt(0) + find(text.substring(1), str.substring(1));
        } else {
            find(text.substring(1), str.substring(1));
        }
        return false;
    }
    
}
