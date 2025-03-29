package TestPractice.FileOpenings.March3;

import java.io.File;
import java.io.IOError;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class March3 {
    public static void main(String[] args) {
    
    try{
        File f1 = new File("C:\\Users\\jerem\\OneDrive\\Documents\\GitHub\\Java2More\\TestPractice\\FileOpenings\\March3\\input.txt");
        Scanner sc = new Scanner(f1);

        PrintWriter p1 = new PrintWriter("C:\\Users\\jerem\\OneDrive\\Documents\\GitHub\\Java2More\\TestPractice\\FileOpenings\\March3\\output1.txt");
        PrintWriter p2 = new PrintWriter("C:\\Users\\jerem\\OneDrive\\Documents\\GitHub\\Java2More\\TestPractice\\FileOpenings\\March3\\output2.txt");



        while(sc.hasNextLine()){
        String line = sc.next();

        String []words = line.split("[^A-Za-z]+");
        String []nums = line.split("[^0-9]");

        for(String s1: words){
            p1.println(s1);
        }

        for(String s2: nums){
            p2.println(s2);
        }
        }
    sc.close();
    p1.close();
    p2.close();
        try {
            File f2 = new File("C:\\Users\\jerem\\OneDrive\\Documents\\GitHub\\Java2More\\TestPractice\\FileOpenings\\March3\\output1.txt");
            File f3 = new File("C:\\Users\\jerem\\OneDrive\\Documents\\GitHub\\Java2More\\TestPractice\\FileOpenings\\March3\\output2.txt");

            Scanner sc2 = new Scanner(f2);
            Scanner sc3 = new Scanner(f3);

            while(sc2.hasNextLine()){
                System.out.println(sc2.next());
            }

            while(sc3.hasNextLine()){
                System.out.println(sc3.next());
            }

            sc2.close();
            sc3.close();
        } catch(IOException e){
            e.getMessage();
        }
    } catch(IOException e){
        e.getMessage();
    } catch(NoSuchElementException e){
        e.getMessage();
    }
    }
    
}
