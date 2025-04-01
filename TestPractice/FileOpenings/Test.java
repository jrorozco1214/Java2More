package TestPractice.FileOpenings;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.ArrayList;

public class Test {
    public class Arithmetic {

        public static void main(String[] args)
        {
            try{
                File f = new File("C:\\Users\\jerem\\OneDrive\\Documents\\GitHub\\Java2More\\TestPractice\\FileOpenings\\RemovingBlankSpace.txt");
                Scanner sc = new Scanner(f);

                ArrayList<String> s = new ArrayList<>(); 
                while(sc.hasNextLine()){
                    String line = sc.nextLine();

                    if(!line.isEmpty()){
                        s.add(line);
                    }
                }
            sc.close();
            PrintWriter pw = new PrintWriter(f);

            for(String str: s){
                pw.println(str);
            }

            pw.close();


            } catch(FileNotFoundException e){
                e.getMessage();
            } catch(NullPointerException e){
                e.getMessage();
            }
        }       
    }
}
