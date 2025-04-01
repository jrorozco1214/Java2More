package TestPractice.FileOpenings;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class RemovingBlankBegEnd {
    public static void main(String[] args) throws FileNotFoundException{
    File f = new File("C:\\Users\\jerem\\OneDrive\\Documents\\GitHub\\Java2More\\TestPractice\\FileOpenings\\RemovingBlankBegEnd.txt");
    
    Scanner sc = new Scanner(f);

    ArrayList<String> w = new ArrayList<>();

    while(sc.hasNextLine()){
        w.add(sc.nextLine());
        }
    
    sc.close();
    int start = 0;

    for(int i = 0; i < w.size(); i++){
        if(w.get(i).trim().isEmpty()){
            start++;
        } else {
            break;
            }
        }

    int end = 0;
    int end1;
    
    for(int i = w.size()-1; i > 0; i--){
        if(w.get(i).trim().isEmpty()){
            end++;
        } else {
            break;
            }
        }
    end1 = w.size()-1 - end;
    PrintWriter p = new PrintWriter(f);
        
    for(int i = start; i <= end1; i++){
        System.out.println(w.get(i));
        p.println(w.get(i));
        }
        p.close();
    }
}
