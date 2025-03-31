package TestPractice.Recursion;

public class RecursionPractice {

    public static void main(String[] args) {
        System.out.println(find("Mississippi", "sip"));
    }

    public static int find(String txt, String str){
        
        return find2(txt, str, 0);
    }

    public static int find2(String txt, String str, int count){
        if(txt.startsWith(str)){
            return count;
        } else if(txt.length() == 0){
            return 0;
        } else {
            return find2(txt.substring(1), str, count+1);
        }
    }
}
