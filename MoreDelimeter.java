import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class MoreDelimeter {
    
    public static void main(String[] args) {
        
        try{
        File f1 = new File("C:\\Users\\jerem\\OneDrive\\Documents\\GitHub\\Java2More\\FileWithSplitScanner\\team.txt");
        Scanner sc = new Scanner(f1);

        String[] teamArray = sc.next().split("[\\s]+");

        String teams = teamArray[0];
        

        int sum = 0;
        int total = 0;



        for(int i = 1; i < teamArray.length; i++){
           int num = Integer.parseInt(teamArray[i]);
           sum+= num;
        }

        
    System.out.println(sum);
    sc.close();
        }
        catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
