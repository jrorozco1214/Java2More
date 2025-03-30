import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ThrowsError {


    public static void main(String[] args)  {
    Scanner sc = new Scanner(System.in);

    float sum = 0;
    int x = 2;
    int count = 0;

    while(count < x){
        try{
            System.out.println("Enter in a float valeu: ");
            float f = sc.nextFloat();
            sum += f;
            
        } catch(InputMismatchException e){
            System.out.println("Wrong value, please enter in a float value: ");
            sc.nextLine();
            }
        }
    }
}
