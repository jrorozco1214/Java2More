package TestPractice.FileOpenings;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.io.File;


public class altToBlankSpaces {
    public static void main(String[] args) {
        
        try {
            File f1 = new File("C:\\Users\\jerem\\OneDrive\\Documents\\GitHub\\Java2More\\TestPractice\\FileOpenings\\blankTexts.txt");

            Scanner sc = new Scanner(f1);

            String []text = null;
            while(sc.hasNextLine()){
                String line = sc.next();
                text = line.split("[^A-Za-z]+");
            }

            sc.close();

            PrintWriter p = new PrintWriter("C:\\Users\\jerem\\OneDrive\\Documents\\GitHub\\Java2More\\TestPractice\\FileOpenings\\blankTexts.txt");

            for(String s: text){
                p.println(s);   
            }
            p.close();
        } catch(IOException e){
            e.getMessage();
        } catch(NoSuchElementException e){
            e.getMessage();
        }
    }
    
}
