package TestPractice.FileOpenings;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.io.FileNotFoundException;
import java.io.File;
import java.io.PrintWriter;

public class TestFileOpening {

    public static void main(String[] args) throws FileNotFoundException{
        File f1 = new File("C:\\Users\\jerem\\OneDrive\\Documents\\GitHub\\Java2More\\TestPractice\\FileOpenings\\columns.txt");
        float totalSum = 0;
        Scanner sc = new Scanner(f1);
        while(sc.hasNextLine()){
            String line = sc.nextLine();
            String []total = line.split("[\\s\n]+");

            for(String s: total){
                totalSum += Float.parseFloat(s);
            }
        
        }
        System.out.println(totalSum);
        sc.close();
        }
    }
