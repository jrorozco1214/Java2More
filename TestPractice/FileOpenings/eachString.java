package TestPractice.FileOpenings;

import java.util.ArrayList;

public class eachString {

    public static void main(String[] args) {
        
        ArrayList<String> words = new ArrayList<>();

        words = lets("ABC");

        for(String s: words){
            System.out.println(s);
        }

        
    }

    public static ArrayList<String> lets(String w){
        ArrayList<String> r = new ArrayList<>();

        if(w.length() == 0){
            r.add(w);
            return r;
        }

        for(int i = 0; i < w.length(); i++){
            String w2 = w.substring(0, i) + w.substring(i+1);

            ArrayList<String> subPerm = lets(w2);

            for(String s: subPerm){
                r.add(s);
            }

        }
        return r;
    }
}
