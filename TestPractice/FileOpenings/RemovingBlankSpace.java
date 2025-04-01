package TestPractice.FileOpenings;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.nio.file.NoSuchFileException;
import java.util.Scanner;

import TestPractice.Recursion.fillinginBlanks;

public class RemovingBlankSpace {

    public static void main(String[] args) throws FileNotFoundException{
    File f = new File("C:\\Users\\jerem\\OneDrive\\Documents\\GitHub\\Java2More\\TestPractice\\FileOpenings\\RemovingBlankSpace.txt");
    Scanner sc = new Scanner(f);

    PrintWriter pw = new PrintWriter(new File("C:\\Users\\jerem\\OneDrive\\Documents\\GitHub\\Java2More\\TestPractice\\FileOpenings\\RemovingBlankSpacerRef.txt"));

    while(sc.hasNextLine()){
        String line = sc.nextLine();

        if(!line.isEmpty()){
            pw.println(line); 
            }
        }
    sc.close();
    pw.close();
    }
}
