package TestPractice;

public class DescendingOrder {
    // TODO: Write a void method selectionSortDescendTrace() that takes 
    //       an integer array and the number of elements in the array as arguments, 
    //       and sorts the array into descending order.
    public static void selectionSortDescendTrace(int [] numbers, int numElements) {
          
       for (int i = 0; i < numElements - 1; i++){
           if (numbers[i] > 0) {
              int maxElementIndex = i;
         for (int j = i + 1; j < numbers.length; j++) {
             if (numbers[maxElementIndex] < numbers[j]) {
                 maxElementIndex = j;
             }
         }
             int temp = numbers[i];
             numbers[i] = numbers[maxElementIndex];
             numbers[maxElementIndex] = temp;
             
             for (int element: numbers) {
                  if(element > 0)
                     System.out.print(element + " ");
                 }
                  System.out.println("");
             }
      }
    }
 }
