package TestPractice.FileOpenings;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Verse {

    public static void main(String[] args) {
        
        try {
        File f1 = new File("C:\\Users\\jerem\\OneDrive\\Documents\\GitHub\\Java2More\\TestPractice\\FileOpenings\\verseInput.txt");
        Scanner sc = new Scanner(f1);

        ArrayList<String> words = new ArrayList<>();

        while(sc.hasNextLine()){
            String line = sc.nextLine();
            words.add(line);
        }
        sc.close();

        PrintWriter p = new PrintWriter("C:\\Users\\jerem\\OneDrive\\Documents\\GitHub\\Java2More\\TestPractice\\FileOpenings\\verseOutput.txt");
        int count = 1;

        for(int i = 0; i < words.size(); i++){
            p.println("/* " + count + " */" + words.get(i));
            count++;
        }

        p.close();
        } catch (IOException e){
            e.getMessage();
        } catch(IndexOutOfBoundsException e){
            e.getMessage();
        }
    }
    
}
