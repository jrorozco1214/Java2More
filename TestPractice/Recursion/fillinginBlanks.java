package TestPractice.Recursion;

public class fillinginBlanks {
    public static void main(String[] args) {
    
    System.out.println(replace("Hello there class"));
    }

    public static String replace(String str){
        if(str.length() == 0){
            return str;
        } else if(str.charAt(0) == ' '){
            return "-" + replace(str.substring(1));
        } else {
            return str.charAt(0) + replace(str.substring(1));
        }
    }

}

