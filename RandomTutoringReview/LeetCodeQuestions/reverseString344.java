package LeetCodeQuestions;

import java.util.Arrays;

public class reverseString344 {

    public static void main(String[] args) {
        
        reverseString(new char[]{'h','e','l','l','o'});
    }

    public static void reverseString(char[] s) {

        int i = 0;
        int j = s.length-1;
        char[] temp = Arrays.copyOf(s, s.length);

        helperRevString(i, j, temp, s);

        System.out.println(s);
    }

    public static char[] helperRevString(int i, int j, char[] temp, char[] s){


        if(i == temp.length-1 && j == 0){
            s[i] = temp[j];
            return temp;
        }
        s[i] = temp[j];
        i +=1;
        j-=1;

        return helperRevString(i, j, temp, s);
    } 
}
