package InterfacePractice;

public class PrettyPrinter {

    public static void PrettyPrint(Debuggable d, String name){ //we're not making a prettyprinter object we're only using it to call the method

        String storedString = d.getTrace();
        System.out.println("----------------------------------------");
        System.out.print("Name: " + name + "\n");
        System.out.print("Trace: \n" + storedString + "\n");
        System.out.print("Length: " + storedString.length() + " characters\n");
        System.out.println("----------------------------------------");

    }
}
