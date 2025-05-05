package FinalsPractice;

import java.util.Arrays;

public class selectionSorting {

    public static void main(String[] args) {
    int []ar = {4, 7, 11, 4, 9, 5};
    
    for(int i = 0; i < ar.length; i++){
        int max = 0;
        
        for(int j = 0; j < ar.length-i; j++){
            if(ar[max] > ar[j]){
                max = j;
            }
        }

        int temp = ar[ar.length-i-1];
        ar[ar.length-i-1] = ar[max];
        ar[max] = temp;
    }

    System.out.println(Arrays.toString(ar));
    



    }
    
}

public class Main{
	
	// binary search = Search algorithm that finds the position
	//				   of a target value within a sorted array.
	//				   Half of the array is eliminated during each "step"
	
	public static void main(String[] args) {
		
		int array[] = new int[100];
		int target = 78;
		
		for(int i = 0; i < array.length; i++) {
			array[i] = i;
		}
		
		//int index = Arrays.binarySearch(array, target);
		int index = binarySearch(array, target);
		
		if(index == -1) {
			System.out.println(target + " not found");
		}
		else {
			System.out.println("Element found at: " + index);
		}
		
	}

	private static int binarySearch(int[] array, int target) {
		
		int low = 0;
		int high = array.length - 1;
		
		while(low <= high) {
			
			int middle = low + (high - low) / 2;
			int value = array[middle];
			
			System.out.println("middle: " + value);
			
			if(value < target) low = middle + 1;
			else if(value > target) high = middle - 1;
			else return middle; //target found
		}
		
		return -1;
	}
}