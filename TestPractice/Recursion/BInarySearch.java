package TestPractice.Recursion;

public class BInarySearch {

    public static void main(String[] args) {
    
    int []ar = {1, 2, 5, 8, 9};
    
    System.out.println(search1(ar, 5));

    }

    public static int search1(int []ar, int n){
        return search2(ar, n, 0);
    }

    public static int search2(int []ar, int n, int start){
        int i = 1;

        if(ar[start] == n){
            return 0;
        } else {

            return i + search2(ar, n, start + 1);
        }
    }
    
}
