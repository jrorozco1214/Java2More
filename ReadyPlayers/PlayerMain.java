package ReadyPlayers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.tools.FileObject;

public class PlayerMain {

    public static void main(String[] args) {
     
    try(ObjectInputStream input = new ObjectInputStream(new FileInputStream("C:\\Users\\jerem\\OneDrive\\Documents\\GitHub\\Java2More\\ReadyPlayers\\players.dat"))){
        Player p1 = (Player) input.readObject();
        System.out.println(p1);
    } catch(IOException | ClassNotFoundException e){
        e.printStackTrace();
        }

        /*try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("playersOut.txt"))){
            
        } catch(IOException e){
            e.getMessage();
        }*/
    }
}
