import java.util.Arrays;

public class sortingAlphabeticalOrder {

    public static void main(String[] args) {

        
        // printSorting(new String[]{
        //     "cat", "car", "bar", "care", "cart"
        // }, new String[]{
        //     "bar", "car", "care", "cart", "cat"
        // });

        // System.out.println("\n");
        // printSorting(new String[]{
        //     "cat", "car", "bar"
        // }, new String[]{
        //     "bar", "car","cat"
        // });
    }

    public static String[] sortAlphabeticalSelection(String[] stringArr){

        String[] sorted = Arrays.copyOf(stringArr, stringArr.length);

        String runningString = "";
        int minimumIndex = 0;

        for(int i = 0; i < sorted.length; i++){

            runningString = sorted[i];
            minimumIndex = i;
            for(int j = i + 1; j < sorted.length; j++){

                int decision = compare(runningString, sorted[j]);

                if(decision > 0) {

                    runningString = sorted[j];
                    minimumIndex = j;
                }
            }

            String temp = sorted[minimumIndex];
            sorted[minimumIndex] = sorted[i];
            sorted[i] = temp; 
        }

        return sorted;
    }

    public static int compare(String s1, String s2){

        char[] charArray1 = s1.toCharArray();
        char[] charArray2 = s2.toCharArray();

        int length = Math.min(charArray1.length, charArray2.length);

        for(int i = 0; i < length; i++){

            int diff = charArray1[i] - charArray2[i];
            if (diff != 0) return diff;

            // if(charArray1[i] == charArray2[i]){

            //     continue;
            // } else if(charArray1[i] > charArray2[i]){

            //     return 1;
            // } else {

            //     return -1;
            // }
        }

        return charArray1.length - charArray2.length;

        // if(charArray1.length == charArray2.length){

        //     return 0;
        // } else if(charArray1.length < charArray2.length) {

        //     return -1;
        // } else {

        //     return 1;
        // }
    }

    public static void printSorting(String[] input, String[] expected){

        String[] result = sortAlphabeticalSelection(input);


        System.out.println("Expected: " + Arrays.toString(expected));
        System.out.println("  Result: " + Arrays.toString(result));

        for(int i = 0; i < input.length; i++){

            if(expected[i].equals(result[i])) {

                System.out.println(result[i]);
            } else {

                System.out.println("Expected: " + expected[i] + ", but got " + result[i]);
            }
        }
    }
}
