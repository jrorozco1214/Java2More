import java.util.Arrays;
import java.util.Random;

public class QuickSort{

    public static void main(String[] args) {

        int [] ar = new int[15];

        Random r = new Random();

        for(int i = 0; i < ar.length; i++){

            ar[i] = r.nextInt(0, 10_000);
        }

        quickSort(ar, 0, ar.length);
        System.out.println(Arrays.toString(ar));

    }

    public static void quickSort(int[] ar, int startIndex, int endIndex){ //split and call itself again
        if(endIndex - startIndex <= 1){
            return;
        }

        Random r = new Random();

        int pivotIndex = r.nextInt(startIndex, endIndex);

        pivotIndex = pivot(ar, startIndex, endIndex, pivotIndex);

        quickSort(ar, startIndex, pivotIndex);
        quickSort(ar, pivotIndex+1, endIndex);
        

    }

    public static int pivot(int[] ar, int startIndex, int endingIndex, int pivotIndex){ //starting and end index are not channging
        int pivotValue = ar[pivotIndex];

        swap(ar, pivotIndex, startIndex);

        int unsortedEndIndex = endingIndex;

        pivotIndex = startIndex;

        while(pivotIndex + 1 < unsortedEndIndex){

            int target = ar[pivotIndex+1];

            if(target < pivotValue){

                swap(ar, pivotIndex, pivotIndex+1);
                pivotIndex++;

            } else {
    
                swap(ar, pivotIndex+1, unsortedEndIndex-1);
                unsortedEndIndex--;
            }
        }

        return pivotIndex;
    }

    public static void swap(int []ar, int i, int j){
        int temp = ar[i];

        ar[i] = ar[j];
        ar[j] = temp;
    }
}