package FinalsPractice;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class FinalPractice {

    public static void main(String[] args) {
    
        try{
            File f1 = new File("C:\\Users\\jerem\\OneDrive\\Documents\\GitHub\\Java2More\\FinalsPractice\\hello.txt");
            Scanner sc = new Scanner(f1);
            ArrayList<String> a = new ArrayList<>();

            while(sc.hasNextLine()){
                String line = sc.nextLine();

                if(!line.isEmpty()){
                    a.add(line);
                }
            }

            PrintWriter p = new PrintWriter(f1);

            for(String read: a){
                p.println(read);
            }
            sc.close();
            p.close();
        } catch(FileNotFoundException e){
            e.getMessage();
        }
    }
}
