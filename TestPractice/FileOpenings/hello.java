package TestPractice.FileOpenings;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.NoSuchElementException;

public class hello {
    public static void main(String[] args) {

        try{
            File f1 = new File("C:\\Users\\jerem\\OneDrive\\Documents\\GitHub\\Java2More\\TestPractice\\FileOpenings\\hello.txt");

            PrintWriter p = new PrintWriter(f1);

            p.println("Hello World");
            p.close();

            Scanner sc = new Scanner(f1);

            System.out.println(sc.nextLine());

            sc.close();
        } catch(FileNotFoundException e){
            e.getMessage();
        } catch(NoSuchElementException e){
            e.getMessage();
        }
    }
    
}
