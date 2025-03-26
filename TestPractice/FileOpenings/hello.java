package TestPractice.FileOpenings;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class hello {

    public static void main(String[] args) {
     try(PrintWriter p1 = new PrintWriter("C:\\Users\\jerem\\OneDrive\\Documents\\GitHub\\Java2More\\TestPractice\\FileOpenings\\hello.txt")){
        p1.println("Hello World");

     } catch(IOException e){
        e.getMessage();
        }


        try{
            File f1 = new File("C:\\Users\\jerem\\OneDrive\\Documents\\GitHub\\Java2More\\TestPractice\\FileOpenings\\hello.txt");

            Scanner sc = new Scanner(f1);


            while(sc.hasNextLine()){
                System.out.print(sc.nextLine());
            }
            sc.close();
            
        } catch (FileNotFoundException e){
            e.getMessage();
        }
    } 
}
