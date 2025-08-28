
import java.util.Stack;

public class stackMain {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();

        stack.push("Minecraft");
        stack.push("Skyrim");
        stack.push("Doom");
        stack.push("Borderlands");
        stack.push("FFVII");

        String myFavGame = stack.pop(); //dont have to write the object, this can be assigned to a variable
        // stack.pop();
        // stack.pop();
        // stack.pop();

        System.out.println(stack.isEmpty()); //check if empty
        System.out.println(stack); //this will print the entire stack
        System.out.println(myFavGame);
        System.out.println(stack.peek()); //this will look at the top of the stack
        System.out.println(stack.search("Doom"));

        for(int i = 0; i < 10; i++){
            stack.push("SH2");
        }

        System.out.println(stack);

    }
    
}
