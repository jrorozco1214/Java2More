package TestPractice.FileOpenings;

import java.io.IOException;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;


public class wordsWithSpacesTest {
    public static void main(String[] args) {
        
    try {
    File f1 = new File("C:\\Users\\jerem\\OneDrive\\Documents\\GitHub\\Java2More\\TestPractice\\FileOpenings\\wordsWithSpaces.txt");
    Scanner sc = new Scanner(f1);

    ArrayList<String> sent = new ArrayList<>();

    while(sc.hasNextLine()){
        String line = sc.nextLine().trim();
        
        sent.add(line);
    }
    sc.close();

    for(String s: sent){
        System.out.println(s);
    }


    } catch(IOException e){
        e.getMessage();
    }





    }
}
