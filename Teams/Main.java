package Teams;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main {
    public static void main(String[] args) {

        Team t1 = new Team("Blackhawks", "red");

        //you have to first read the object to a file and then you can print the object 
        try(ObjectOutputStream objoutput = new ObjectOutputStream(new FileOutputStream("C:\\Users\\jerem\\OneDrive\\Documents\\GitHub\\Java2More\\Teams\\Team.txt"))){
        objoutput.writeObject(t1);

            try(ObjectInputStream objinput = new ObjectInputStream(new FileInputStream("C:\\\\Users\\\\jerem\\\\OneDrive\\\\Documents\\\\GitHub\\\\Java2More\\\\Teams\\\\Team.txt"))){
                Team t2 = (Team)objinput.readObject();
                System.out.println(t2.toString());
                }
                catch (IOException | ClassNotFoundException e) {
                System.out.println("Error: " + e.getMessage());
             }
            }
        catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
