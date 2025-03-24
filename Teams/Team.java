package Teams;

import java.io.Serializable;

public class Team implements Serializable{ //the Serializable is used in order to read/write objects using ObjectInputStream, the class must implemtn serialiazable

    private static final long serialVersionUID = 1L;


private String name;
private String color;

public Team(String name, String color){
    this.name = name;
    this.color = color;
    }

public String toString(){ //in order to convert from class name and memory adddress you have to use a toString method to convert it
    return "The team name is: " + this.name + "\n" + "The team color is: " + this.color;
    }
    
}
