package LeetCodeQuestions.BinarySearch;

public class divideChocolate1231 {

    public static void main(String[] args) {


        System.out.println(maximizeSweetness(new int[]{1,2,3,4,5}, 3));
    }

    public static int maximizeSweetness(int[] sweetness, int k){

        int right = 0;

        for(Integer x: sweetness){

            right += x;
        }
        int left = 1;
        right /= k + 1;

        while(left <= right) {

            int mid = left + (right - left) / 2;

            if(chunkCheck(sweetness, mid, k)) {
              
                left = mid + 1;
                //right = mid - 1;
            } else {
                right = mid - 1;
                //left = mid + 1
            }
        }

        return right;
    }


    public static boolean chunkCheck(int[] sweetness, int mid, int k){

        int sum = 0;
        int chunks  = 0;

        for(Integer sweet: sweetness){
            
            sum += sweet;

            if(sum >= mid) {

                chunks++;
                sum = 0;
            }
        }

        return chunks >= k + 1;
    }
}
