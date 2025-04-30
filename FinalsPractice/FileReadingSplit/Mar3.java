package FinalsPractice.FileReadingSplit;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Mar3 {

    public static void main(String[] args) {
        Scanner sc = null;
        PrintWriter p1 = null;
        PrintWriter p2 = null;
        try{
            File input = new File("C:\\Users\\jerem\\OneDrive\\Documents\\GitHub\\Java2More\\FinalsPractice\\FileReadingSplit\\read.txt");
            sc = new Scanner(input);

            ArrayList<String> s1 = new ArrayList<>();
            ArrayList<String> s2 = new ArrayList<>();

            while(sc.hasNext()){
                String line1 = sc.next();
                String line2 = sc.next();

                String []ar1 = line1.split("[^A-Za-z]");
                String []ar2 = line2.split("[^0-9]");

                for(String r1: ar1){
                    s1.add(r1);
                }

                for(String r2: ar2){
                    s2.add(r2);
                }
            }

            p1 = new PrintWriter("output.txt");
            p2 = new PrintWriter("output2.txt");

            for(String rr1: s1){
                p1.println(rr1);
            }

            for(String rr2: s2){
                p2.println(rr2);
            }
        } catch(FileNotFoundException e){
            e.getMessage();
        } catch(NoSuchElementException e){
            e.getMessage();
        } finally {
            sc.close();
            p1.close();
            p2.close();
        }
    }
}
