package TestPractice.FileOpenings.March12;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class March12 {

    public static void main(String[] args) throws FileNotFoundException{
        
    File f1 = new File("C:\\Users\\jerem\\OneDrive\\Documents\\GitHub\\Java2More\\TestPractice\\FileOpenings\\March12\\input1.txt");
    File f2 = new File("C:\\Users\\jerem\\OneDrive\\Documents\\GitHub\\Java2More\\TestPractice\\FileOpenings\\March12\\input2.txt");
    File f3 = new File("C:\\Users\\jerem\\OneDrive\\Documents\\GitHub\\Java2More\\TestPractice\\FileOpenings\\March12\\input3.txt");
    
    Scanner sc1 = new Scanner(f1);
    Scanner sc2 = new Scanner(f2);
    Scanner sc3 = new Scanner(f3);

    sc1.useDelimiter("[.;\\s]+");
    sc2.useDelimiter("[\\s,;|]+");
    sc3.useDelimiter("[\\s;|#]+");

    while(sc1.hasNextLine()){
        System.out.println(sc1.next());
    }

    while(sc2.hasNextLine()){
        System.out.println(sc2.next());
    }

    while(sc3.hasNextLine()){
        System.out.println(sc3.next());
    }
    sc1.close();
    sc2.close();
    sc3.close();
    }
    
}
