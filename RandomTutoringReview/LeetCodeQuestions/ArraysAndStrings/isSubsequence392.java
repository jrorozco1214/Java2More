package LeetCodeQuestions.ArraysAndStrings;

public class isSubsequence392 {

    public static void main(String[] args) {

        System.out.println(isSubsequence("abc", "ahbgdc"));
    }

    public static boolean isSubsequence(String s, String t) {

        int i = 0;
        int j = 0;

        while(i < s.length() && j < t.length()){

            if(s.charAt(i) == t.charAt(j)){

                i++;
            }

            j++;
        }

        return i == s.length();
    }
    
}
