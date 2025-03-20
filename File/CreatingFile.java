package File;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class CreatingFile {
    
    public static void main(String[] args) {
     try{
        File f1 = new File("C:\\Users\\jerem\\OneDrive\\Documents\\GitHub\\Java2More\\input.txt");
        Scanner sc = new Scanner(f1);

        sc.useDelimiter("[,\\s]+");

        PrintWriter p1 = new PrintWriter("C:\\Users\\jerem\\OneDrive\\Documents\\GitHub\\Java2More\\output.txt");

        while(sc.hasNext()) {
            p1.println(sc.next());
        }
        sc.close();
        p1.close();
    }
     catch(IOException e){
        e.getMessage();
     }
    }
}
