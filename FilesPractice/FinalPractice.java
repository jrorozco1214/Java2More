package FilesPractice;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class FinalPractice {

    public static void main(String[] args) {
    
    try {
        File f = new File("C:\\Users\\jerem\\OneDrive\\Documents\\GitHub\\Java2More\\FilesPractice\\hello.txt");
        Scanner sc = new Scanner(f);

        int totalCharacters = 0;
        int totalWords = 0;
        int totalLine = 0;

        sc.useDelimiter("[//s+]");

        while(sc.hasNext()){
            String line = sc.next();

            if(!line.isEmpty()){
                totalCharacters++;
            }
        }

        while(sc.hasNextLine()){
            String line = sc.next();

            if(!line.isEmpty()){
                totalWords++;
            }
        }

        while(sc.hasNextLine()){
            totalLine++;
        }
        System.out.println(totalCharacters);
        System.out.println(totalWords);
        System.out.println(totalLine);

    } catch(FileNotFoundException e){
        e.getMessage();
    } catch(NoSuchElementException e){
        e.getMessage();
    }

    }
}
