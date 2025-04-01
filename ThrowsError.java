import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ThrowsError {


    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);

        int num;
    
        int n = 0;
        int w = 3;
        int total = 0;
    
    while(n < w) {
    try {

    while(true){
        num = sc.nextInt();
        total += num;
        }
    } catch (InputMismatchException e){
        System.out.println("Enter in an integer");
        sc.nextLine();
        n++;
        }
    }
    System.out.println(total);
    sc.close();
    
    }
}
