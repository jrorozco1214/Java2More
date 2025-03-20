import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Delimiter {
    
public static void main(String[] args) {
    
    try{
    File f1 = new File("C:\\Users\\jerem\\OneDrive\\Documents\\GitHub\\Java2More\\FileWithSplitScanner\\team.txt");

    Scanner sc = new Scanner(f1);
    
    String[] teamsplit = sc.next().split("[^A-Za-z]"); //you are able to split it all at once here

    while(sc.hasNextLine()){
        for(int i = 0; i < teamsplit.length; i++){ 
            System.out.println(teamsplit[i]);
        }
    }

    


    sc.close();
    }

  catch(IOException e){
    e.getMessage();
  } 


    }   
}
