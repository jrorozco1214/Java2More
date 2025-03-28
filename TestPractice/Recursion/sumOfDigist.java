package TestPractice.Recursion;

public class sumOfDigist {
    public static void main(String[] args) {
        
        int []ar = {1, 2, 3};

        System.out.println(sum(ar, 0));


    }
    public static int sum(int []ar, int start){

        if(start >= ar.length){
            return 0;
        } else {
            return (ar[start] + sum(ar, start+1));
        }
    }
}
