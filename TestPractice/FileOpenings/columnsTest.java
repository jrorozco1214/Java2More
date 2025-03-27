package TestPractice.FileOpenings;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class columnsTest {

    public static void main(String[] args) {
        
    try {
        File f1 = new File("C:\\Users\\jerem\\OneDrive\\Documents\\GitHub\\Java2More\\TestPractice\\FileOpenings\\columns.txt");

        Scanner sc = new Scanner(f1);

        ArrayList<Float> file1 = new ArrayList<>();
        ArrayList<Float> file2 = new ArrayList<>();

        int average1 = 0;
        int average2 = 0;

        while(sc.hasNextLine()){
            String l1 = sc.next();
            String l2 = sc.next();

            String[] a1 = l1.split("//s");
            String[] a2 = l2.split("\n");

            for(String s1: a1){
                if(!s1.isEmpty()){
                    file1.add(Float.parseFloat(s1));
                    }
                }

            for(String s2: a2){
                if(!s2.isEmpty()){
                    file2.add(Float.parseFloat(s2));
                    }
                }
            }
            sc.close();

            for(Float w1: file1){
                average1 += w1;
            }
            average1 = average1 / file1.size();
            System.out.println(average1);

            for(Float w2: file2){
                average2 += w2;
            }
            average2 = average2 / file2.size();
            System.out.println(average2);

        } catch(IOException e){
            e.getMessage();
        }
    }
    
}
