package TestPractice.Recursion;

public class largestElementArray {

    public static void main(String[] args) {
        
        int []ar = {1, 2, 7, 6};
        System.out.println(max(ar, 0, 0));

        

    }

    public static int max(int []ar, int start, int top){
        
        if(start == ar.length){
            return top;
        } else if(ar[start] > top){
            top = ar[start];
        }
        return max(ar, start+1, top);
    }
    
}
