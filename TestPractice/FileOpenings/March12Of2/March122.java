package TestPractice.FileOpenings.March12Of2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class March122 {
    
    public static void main(String[] args) throws FileNotFoundException{

        File f1 = new File("C:\\Users\\jerem\\OneDrive\\Documents\\GitHub\\Java2More\\TestPractice\\FileOpenings\\March12Of2\\input.txt");

        Scanner sc = new Scanner(f1);

        while(sc.hasNextLine()){
            String line = sc.next();
            String num = sc.nextLine().trim();

            String []nums = num.split("[,\\s]+");
            int min = 100;
            int max = 0;
            int total = 0;
            System.out.print(line + " ");
            for(int i = 0; i < nums.length; i++){

                if(min > Integer.parseInt(nums[i])){
                    min = Integer.parseInt(nums[i]);
                }
                if(max < Integer.parseInt(nums[i])){
                    max = Integer.parseInt(nums[i]);
                }
                total += Integer.parseInt(nums[i]);
                
            }
            System.out.print(min + " ");
                System.out.print(max + " ");
                System.out.println(total);
            
        }
        sc.close();
    }
}
