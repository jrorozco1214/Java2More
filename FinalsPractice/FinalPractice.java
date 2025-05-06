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

    int []ar = {2, 4, 7, 9, 3};

    System.out.println(hHelper(ar));
    }

    public static int hHelper(int[]ar){
        return sumArray(ar, 0);
    }

    public static int sumArray(int[] ar, int start){

        if(start == ar.length){
            return 0;
        }

        return ar[start] + sumArray(ar, start+1);

    }
}
