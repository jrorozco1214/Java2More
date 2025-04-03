package TestPractice.Recursion;

import java.util.Scanner;

public class codeForece {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();

        for(int i = 0; i < num; i++){
        int secondIn = sc.nextInt();

            for(int j = 0; j < secondIn; j++){
                System.out.print((int)Math.random() * 9 + " ");
            }
        }
        sc.close();
    }
}
