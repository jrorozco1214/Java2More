package InterfacePractice;

public class Saver implements Debuggable{

    StringBuilder builder = new StringBuilder();

    public void save(String message){
        builder.append(message).append("\n");
    }

    @Override
    public String getTrace() {

        String temp = builder.toString();

        builder = new StringBuilder();

        return temp;
    }    
}
