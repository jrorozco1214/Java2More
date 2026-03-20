import java.util.Arrays;

public class mergeSort2{

    public static void main(String[] args) {

        int [] ar = {6, 8, 9, 2, 3, 4};

        mergeSortMethod(ar);

    }

    public static void mergeSortMethod(int[] array){ //split and call itself again
        if(array.length <= 1){
            return;
        }


        int[] firstHalf = Arrays.copyOfRange(array, 0, array.length / 2);
        int[] secondHalf = Arrays.copyOfRange(array, array.length / 2, array.length);

        mergeSortMethod(firstHalf);
        mergeSortMethod(secondHalf);

        merge(firstHalf, secondHalf, array);

    }

    public static void merge(int[] firstHalf, int[] secondHalf, int[] originalArray){

        int firstIndex = 0;
        int secondIndex = 0;

        while(firstIndex < firstHalf.length && secondIndex < secondHalf.length){ 

            int firstValue = firstHalf[firstIndex];
            int secondValue = secondHalf[secondIndex];

            if(firstValue <= secondValue){
                originalArray[firstIndex+secondIndex] = firstValue; //firstIndex and secondIndex sum will be the index for the oringal array replacement no matter what
                firstIndex++;

            } else {
                originalArray[firstIndex+secondIndex] = secondValue;
                secondIndex++;
            } 
        }

        while(firstIndex < firstHalf.length){ 
            originalArray[firstIndex+secondIndex] = firstHalf[firstIndex];
            firstIndex++;
        }

        while(secondIndex < secondHalf.length){
            originalArray[firstIndex+secondIndex] = secondHalf[secondIndex];
            secondIndex++;
        }

        /*
        no matter what for each of the half of the arrays you are going to be missing something so you have to check
        because in the first while loop you will reach the case and have something missing 
        you need two while loops to check the conditions to make sure that you are not missing anything
        */

        System.out.println(Arrays.toString(originalArray));
    }
}