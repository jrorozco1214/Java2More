package FilesPractice;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class FinalPractice {

    public static void main(String[] args) {

    try{
    File f = new File("C:\\Users\\jerem\\OneDrive\\Documents\\GitHub\\Java2More\\FilesPractice\\hello.txt");

    Scanner sc = new Scanner(f);
    ArrayList<String> a = new ArrayList<>();

    while(sc.hasNextLine()){
        String line = sc.next();
        String line2 = sc.nextLine().trim();

        a.add(line + line2);
    }

    PrintWriter p = new PrintWriter(f);

    for(String write: a){
        p.println(write);
    }

    sc.close();
    p.close();
    } catch(FileNotFoundException e){
        e.getMessage();
    }
    


    }
}
