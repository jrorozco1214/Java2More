package TestPractice.Recursion;

public class doesItHaveThisString {
    public static void main(String[] args) {
        
    System.out.println(find("Mississippi", "x"));

    }

    public static boolean find(String text, String str){
      if(text.startsWith(str)){
        return true;
      } else if(text.length() == 0){
        return false;
      } else {
        return find(text.substring(1), str);
      }
    }
}
