package TestPractice.Recursion;

import java.util.Scanner;

public class codeForece {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        int []constant = {0, 1, 0, 3, 2, 0, 2, 5};

        for(int i = 0; i < num; i++){
        int secondIn = sc.nextInt();

            int []ar = new int [10];
            for(int j = 0; j < secondIn; j++){
            int thirdIn = sc.nextInt();
                ar[j] = thirdIn; 
            }
            System.out.println();
            int counter = 0;
            
            for(int z = 0; z < constant.length; z++){
                for(int x = 0; x < ar.length; x++){
                    if(constant[z] == ar[x]){
                        ar[x] = -1;
                        counter = x;
                    }
                }
            }
            if(counter == 0){
                System.out.println(0);
            } else {
                System.out.println(counter+1);
            }
        }
        sc.close();
    }
}
