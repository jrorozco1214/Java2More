package TestPractice.FileOpenings;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.File;

public class hello {
    public static void main(String[] args) throws FileNotFoundException{
        
    PrintWriter pw = new PrintWriter("C:\\Users\\jerem\\OneDrive\\Documents\\GitHub\\Java2More\\TestPractice\\FileOpenings\\hello.txt");

    pw.println("Hello World");

    pw.close();

    File f = new File("C:\\Users\\jerem\\OneDrive\\Documents\\GitHub\\Java2More\\TestPractice\\FileOpenings\\hello.txt");

    Scanner sc = new Scanner(f);

    String s = sc.nextLine();

    System.out.println(s);

    sc.close();




    }
    
}
