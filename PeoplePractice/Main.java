package PeoplePractice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) {
        person p1 = new person("Jeremy", 27);

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Person.txt"))){ 
            oos.writeObject(p1);
            System.out.println("The object was written to the file");       
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }


        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Person.txt"))){
            person p2 = (person) ois.readObject();
            System.out.println(p2);
        }
        catch(IOException | ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
    }
}
