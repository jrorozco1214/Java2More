package LeetCodeQuestions.ArraysAndStrings;

import java.util.ArrayList;

public class reverseString344 {

    public static void main(String[] args) {

        reverseString(new char[]{'h','e','l','l','o'});
    }

    public static void reverseString(char[] s) {

        int i = 0;
        int j = s.length-1;
        char[] temp = s.clone();

        while(i < s.length){

            s[i] = temp[j];
            i++;
            j--;
        }
    }
}
