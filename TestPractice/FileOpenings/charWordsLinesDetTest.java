package TestPractice.FileOpenings;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class charWordsLinesDetTest {
    public static void main(String[] args) {
        
    try {
        File f1 = new File("C:\\Users\\jerem\\OneDrive\\Documents\\GitHub\\Java2More\\TestPractice\\FileOpenings\\charWordsLinesDet.txt");

        Scanner sc = new Scanner(f1);

        int totalLines = 0;
        int totalCharacters = 0;
        int totalWords = 0;

        ArrayList<String> w = new ArrayList<>();

        while(sc.hasNextLine()){
        String line = sc.nextLine();
        
        if(!line.isEmpty()){
            w.add(line);
        }  

        if(sc.hasNextLine()){
            totalLines++;
        }
    }


            for(String le: w){
                totalCharacters += le.length();
            }

            for(String ls: w){
                String[] words = ls.trim().split("\\s+");
                totalWords += words.length;
            }

        System.out.println(totalLines);
        System.out.println(totalWords);
        System.out.println(totalCharacters);


        sc.close();
            } catch(IOException e){
                e.getMessage();
            }
        }
    }
