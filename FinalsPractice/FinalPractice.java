package FinalsPractice;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

import TestPractice.Recursion.ar;

public class FinalPractice {

    public static void main(String[] args) {

    int ar[][] = new int[5][5];

    int total = 1;

    for(int i = 0; i < ar.length; i++){
        for(int j = 0; j < ar[0].length; j++){
            ar[i][j] = total;
        }
    }
    
    for(int i = 0; i < ar.length; i++){
        for(int j = 0; j < ar[0].length; j++){
            System.out.print(ar[i][j]);
        }
        System.out.println();
    }


    }
}
