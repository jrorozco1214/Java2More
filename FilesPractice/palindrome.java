package FilesPractice;

public class palindrome {

    public static void main(String[] args) {
        
        System.out.println(pal1("ABBA"));

    }


    public static boolean pal1(String word){
        return pal(0, word, word.length()-1);
    }

    public static boolean pal(int start, String w, int end){
            if(start >= end){
                return true;
            } else if(w.charAt(start) == w.charAt(end)){
                return pal(start+1, w, end-1);
            } 
        return false;
    }
    
}
