package TestPractice.FileOpenings.March12Of2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class March122 {
    
    public static void main(String[] args) throws FileNotFoundException{

        File f1 = new File("C:\\Users\\jerem\\OneDrive\\Documents\\GitHub\\Java2More\\TestPractice\\FileOpenings\\March12Of2\\input.txt");

        Scanner sc = new Scanner(f1);

        int total = 0;

        while(sc.hasNextLine()){
        String teams = sc.next();
        String teamScore = sc.nextLine().trim();

        String []teamScoreCombined = teamScore.split("[,\\s]+");
        
        
        System.out.print(teams + " ");
        for(String j: teamScoreCombined){
            total+= Integer.parseInt(j);
        }
        System.out.println(total);


        }
        sc.close();
    }
}
