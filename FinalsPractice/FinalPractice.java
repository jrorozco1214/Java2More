package FinalsPractice;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class FinalPractice {

    public static void main(String[] args) {
    
        System.out.println(rev("hello!"));
    }

    public static String rev(String w){
        if(w.length() == 0){
            return "";
        }

        return rev(w.substring(1)) + w.charAt(0);

    }
}
