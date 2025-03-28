package TestPractice.Recursion;

public class generateAllStrings {
    public static void main(String[] args) {
        

    }

    public static ArrayList<Strings> every(String s){
        ArrayList<String> a = ArrayList<>();
        
        
        if(s.length() == 0){
            a.add("");
            return a;
        }

        for(int i = 0; i < s.length(); i++){
            String word = s.substring(0, i) + s.substring(i+1);


        a.add(every(w));
        }
    }
    
}
