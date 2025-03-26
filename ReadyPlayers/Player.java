package ReadyPlayers;

import java.io.Serializable;

public class Player implements Serializable{

    private static final long serialVersionUID = 1L;  // Helps with compatibility
    private String name;
    private String whatP;

    public Player(String name, String whatP){
        this.name = name;
        this.whatP = whatP;
    }

    public String toString(){
        return this.name + this.whatP;
    }
    
}
