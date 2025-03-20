package FileWithSplitScanner;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class SplitScanner {

    public static void main(String[] args) {
    
    try {
        File f1 = new File("C:\\Users\\jerem\\OneDrive\\Documents\\GitHub\\Java2More\\FileWithSplitScanner\\team.txt");
        Scanner sc = new Scanner(f1);

        int total1 = 0; 
        while(sc.hasNextLine()){
           String line = sc.nextLine().trim();
           String []teamNames = line.split("[\\s]", 2);

           System.out.println(teamNames[0]);
           System.out.println(teamNames[1]); //ASK ABOUT HOW YOU CAN USE VARIABLES OR PARSE THEM
        }
        System.out.println(total1);
        sc.close();  
    } 

    catch(IOException e){
        e.getMessage();
        }
    }
}
