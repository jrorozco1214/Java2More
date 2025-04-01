package TestPractice.FileOpenings;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class NamesGrades {
    public static void main(String[] args) throws FileNotFoundException{
        
    File f1 = new File("C:\\Users\\jerem\\OneDrive\\Documents\\GitHub\\Java2More\\TestPractice\\FileOpenings\\NamesGrades.txt");

    Scanner sc = new Scanner(f1);

    while(sc.hasNextLine()){
        String line = sc.nextLine();

        System.out.print(line + '\n');
    }
    sc.close();
}
    
}
