import java.util.ArrayList;
import java.util.Stack;

public class ValidParentheses {

    public static void main(String[] args) {


        System.out.print(isValid("([{}](()))"));
    }

    public static boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();

        for(Character c: s.toCharArray()){ //changing String to character array

            if(!stack.isEmpty() && valid(stack.peek(), c)){
                stack.pop();

            } else {
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }

    public static boolean valid(char left, char right){

        return  (left == '(' && right == ')') 
                || (left == '{' && right == '}') 
                || (left == '[' && right == ']');
    }
    
}
