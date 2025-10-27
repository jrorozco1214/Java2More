public class LeetCodeTest {
     public static String[] fizzBuzz(int n) {
        // write your code here
        String ar[] = new String[n+1];
        
        String num;        
        
        for(int i = 1; i <= n; i++){
            if(i % 3 == 0 && i % 5 == 0){
                ar[i] = "FizzBuzz";
            } else if(i % 3 == 0){
                ar[i] = "Fizz";
            } else if(i % 5 == 0){
                ar[i] = "Buzz";
            } else {
                num = Integer.toString(i);
                ar[i] = num; 
            }
        }
        return ar;
    }
    public static void main(String[] args) {
        String ar[] = fizzBuzz(5);
        for(String a: ar){
            System.out.println(a);
        }
    }
}
