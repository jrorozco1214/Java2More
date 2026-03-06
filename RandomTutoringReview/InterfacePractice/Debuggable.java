package InterfacePractice;


public interface Debuggable { //all abstract by default, public by default

    String getTrace();

    public static void main(String[] args) {
        Calculator c = new Calculator(); //since this is implementing debuggable it can be used in place of a debuggable variable 
        //in a method

        c.add(3, 2);
        c.multiply(5, 2);
        c.add(9, 10);

        PrettyPrinter.PrettyPrint(c, "Calculator Class");

        Saver s = new Saver();

        s.save("HI how are you?");
        s.save("What is up?");

        PrettyPrinter.PrettyPrint(s, "Save Class 1");

        s.save("HI how are you?");
        s.save("What is up?");
        s.save("HI how are you?");
        s.save("What is up?");
        s.save("HI how are you?");
        s.save("What is up?");
        s.save("HI how are you?");
        s.save("What is up?");
        
        PrettyPrinter.PrettyPrint(s, "Save Class 2");


    }
}

