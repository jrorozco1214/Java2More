package GymStats;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class GymMain {
    public static void main(String[] args) {
        
        try {
            File f1 = new File("C:\\Users\\jerem\\OneDrive\\Documents\\GitHub\\Java2More\\GymStats\\stat.txt");

            Scanner sc = new Scanner(f1);

            ArrayList<String> exNames = new ArrayList<>();
            ArrayList<Integer> var1 = new ArrayList<>();
            


            while(sc.hasNextLine()){
                String line = sc.nextLine();
                String []names = line.split("[^A-Za-z]+");
                String []nums = line.split("[^0-9]+");

                for(String n: names){
                    if(!n.isEmpty()){
                        exNames.add(n);
                    }
                }

                for(String nu: nums){
                    if(!nu.isEmpty()){
                        var1.add(Integer.parseInt(nu));
                    }
                }
            }
            int total1 = 0;
            int total2 = 0;
            int total3 = 0;


            for(int i = 0; i < 4; i++){
                total1 += var1.get(i);
            }

            for(int j = 4; j < 8; j++){
                total2 += var1.get(j);
            }

            for(int z = 8; z < var1.size(); z++){
                total3+= var1.get(z);
            }

            System.out.println(exNames.get(0) + total1);

            System.out.println(exNames.get(1) + total2);

            System.out.println(exNames.get(2) + total3);

            sc.close();
        } catch(FileNotFoundException e){
            e.getMessage();
        }
    }
}
