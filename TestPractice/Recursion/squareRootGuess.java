package TestPractice.Recursion;

public class squareRootGuess {

    public static void main(String[] args) {
        
        System.out.println(squareRoot(5.4));
    }


    public static double squareRoot(double x){
        return squareRootG(x, 0.0); 
    }

    public static double squareRootG(double x, double g){

        if(Math.pow(g, 2) == x){
            return g;
        } else {
            return squareRootG(x, ((g+x/g)/2));
        }

    }
    
}
