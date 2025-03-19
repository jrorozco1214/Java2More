import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class CreatingFile {
    
    public static void main(String[] args) {
     try{
        File f1 = new File("C:\\Users\\jerem\\OneDrive\\Documents\\GitHub\\Java2More\\input.txt");
        Scanner sc = new Scanner(f1);

        sc.useDelimiter(",\\s"+);

        while(sc.hasNext()) {

        }
    
    
    }

     catch(IOException e){
        e.getMessage();
     }
        

    }
}
