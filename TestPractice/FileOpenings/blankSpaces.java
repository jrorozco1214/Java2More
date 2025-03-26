package TestPractice.FileOpenings;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class blankSpaces {

    public static void main(String[] args) {
        try{
           File f1 = new File("C:\\Users\\jerem\\OneDrive\\Documents\\GitHub\\Java2More\\TestPractice\\FileOpenings\\blankTexts.txt");
        
            Scanner sc = new Scanner(f1);

            sc.useDelimiter("\\s+");

            try(PrintWriter p1 = new PrintWriter("C:\\Users\\jerem\\OneDrive\\Documents\\GitHub\\Java2More\\TestPractice\\FileOpenings\\blankTextsTest.txt")){
                while(sc.hasNext()){
                    p1.println(sc.next());
                }
            } catch(IOException e){
                e.getMessage();
            }
        sc.close();
        } catch(IOException e){
            e.getMessage();
        } catch(NoSuchElementException e){
            e.getMessage();
        }
    }    
}
