package FinalsPractice;

public class largestElementinArray {

    public static void main(String[] args) {
        
        int []ar = {2, 4, 7, 9, 3};

        System.out.println(hHelper(ar));
        }
    
        public static int hHelper(int[] ar){
    
            return largestElement(ar, 0, ar.length-1, 0);
    
        }
    
        public static int largestElement(int[] ar, int start, int end, int temp){
    
            if(start == end){
                if(ar[temp] > ar[end]){
                    return ar[temp];
                } else {
                    return ar[end];
                }
            } else if(ar[temp] < ar[start]){
                temp = start;
                return largestElement(ar, start+1, end, temp);
            }
            return largestElement(ar, start+1, end, temp);
    
        }
    
}
