import java.util.Arrays;
import java.util.Stack;

public class asteroid {

    public static void main(String[] args) {
        
        System.out.println(Arrays.toString(asteroidCollision(new int[]{3, 5, -6, 2, -1, 4})));


        /*
        
        */
    }

    public static int[] asteroidCollision(int[] asteroids) {

        Stack<Integer> stack = new Stack<>();

        int index = 0;

        while(index < asteroids.length){

            stack.push(asteroids[index]);

            boolean keepGoing = true;

            while(keepGoing){
                
                keepGoing = false;

                if(stack.size() >= 2){

                    int right = stack.pop();
                    int left = stack.pop();

                    if(left > 0 && right < 0){

                        if(left > Math.abs(right)){
                            stack.push(left);
                        } else if (left < Math.abs(right)){
                            stack.push(right);
                            keepGoing = true;
                        } //else they both explode or dont do
                    } else {
                        stack.push(left);
                        stack.push(right);
                    }
                }
            }
            index++;
        }

        int[] stackArray = new int[stack.size()];

        for(int i = 0; i < stack.size(); i++){
            stackArray[i] = stack.get(i);
        }

        return stackArray;
    }
    
}
