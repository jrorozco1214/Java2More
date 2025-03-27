package TestPractice.Recursion;

public class CharacterCount {
    public static void main(String[] args) {
        
    System.out.println(total("giggling", 'g'));


    }

    public static int total(String s, char c){
        return count(s, c, 0);
    }


    public static int count(String s, char c, int total){
        if(s.equals("")){
            return total;
        } else if(s.charAt(0) == c){
            return count(s.substring(1), c, total + 1);
        } else {
            return count(s.substring(1), c, total);
        }
    }
    
}
