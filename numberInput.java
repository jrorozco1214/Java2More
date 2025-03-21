import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class numberInput {
    public static void main(String[] args) {
        

        try {
            File f1 = new File("C:\\Users\\jerem\\OneDrive\\Documents\\GitHub\\Java2More\\numbers.txt");
        
            Scanner sc = new Scanner(f1);


            while(sc.hasNextLine()){
                String []array = sc.next().split("[.,\\s]+"); //will split based on what is provided into it's own line
                for(int i = 0; i < array.length; i++){
                    System.out.println(array[i]);
                }
            }
        }
        catch(IOException e){
            e.getMessage();
        }
    }
}
