package FinalsPractice;

public class calcSumOfArray {

    public static void main(String[] args) {
    int[] ar = {1, 2, 3, 4};

    System.out.println(hSum(ar));
    
    }

    public static int hSum(int[] ar){
        return totalSum(ar, 0); 
    }

    public static int totalSum(int[] ar, int start){

        if(start == ar.length){
            return 0;
        }

        return ar[start] + totalSum(ar, start+1);

    }
    
}
