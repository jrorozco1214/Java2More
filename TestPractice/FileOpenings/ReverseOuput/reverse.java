package TestPractice.FileOpenings.ReverseOuput;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class reverse {
    public static void main(String[] args) throws FileNotFoundException{
        
    File f1 = new File("C:\\Users\\jerem\\OneDrive\\Documents\\GitHub\\Java2More\\TestPractice\\FileOpenings\\ReverseOuput\\input.txt");
    
    Scanner sc = new Scanner(f1);
    
    ArrayList<String> sentences = new ArrayList<>();

    while(sc.hasNextLine()){
        String line = sc.nextLine();

        String []ar = line.split("\n");

        for(String a: ar){
            if(!a.isEmpty()){
                sentences.add(a);
            }
        }
    
    }

    PrintWriter pw = new PrintWriter(new File("C:\\Users\\jerem\\OneDrive\\Documents\\GitHub\\Java2More\\TestPractice\\FileOpenings\\ReverseOuput\\output.txt"));

    for(int i = sentences.size()-1; i >= 0; i--){
        pw.println(sentences.get(i));
    }

pw.close();
sc.close();
    }
    
}
