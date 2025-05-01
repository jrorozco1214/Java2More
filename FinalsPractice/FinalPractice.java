package FinalsPractice;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class FinalPractice {

    public static void main(String[] args) {
        System.out.println(rep("heeeeello", 'e', 'i'));
    }

    public static String rep(String w, char c1, char c2){

        if(w.length() == 0){
            return "";
        } else if(w.charAt(0) == c1){
            return c2 + rep(w.substring(1), c1, c2);
        }
        return w.charAt(0) + rep(w.substring(1), c1, c2);

    }
}
