package InterfacePractice;

//String Builder an array of characters or list of characters, more efficinet then adding two strongs becuase you dont have to copy

public class Calculator implements Debuggable{

    StringBuilder builder = new StringBuilder();

    
    public int add(int a, int b){
        builder.append("We're adding two numbers ")
            .append(a)
            .append(" ")
            .append(b)
            .append(", the result is: ")
            .append(a+b)
            .append("\n");
        return a + b;
    }

    public int multiply(int a, int b){
        builder.append("We're multiplying two numbers ")
            .append(a)
            .append(" ")
            .append(b)
            .append(", the result is: ")
            .append(a*b)
            .append("\n");
        return a * b;
    }


    @Override
    public String getTrace() {
        String temp = builder.toString();

        builder = new StringBuilder();

        return temp;
    }
    
}
