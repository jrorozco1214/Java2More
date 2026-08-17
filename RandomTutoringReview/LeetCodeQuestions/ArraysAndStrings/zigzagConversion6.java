package LeetCodeQuestions.ArraysAndStrings;

public class zigzagConversion6 {

    public static void main(String[] args) {

        System.out.println(convert("PAYPALISHIRING", 4));
    }

    public static String convert(String s, int numRows) {

        char[][] zigZag = new char[numRows][numRows+numRows];

        int tempJ = 0;
        int tempI = 0;

        int stringIndex = 0;

        for(int j = 0; j < zigZag[0].length; j++) {

            for(int i = 0; i < zigZag.length; i++){

                if(j % numRows-1 == 0) {

                    zigZag[i][j] = s.charAt(stringIndex);

                    if(i == numRows-1) {

                        tempJ = j+1;
                        tempI = i-1; 
                    }

                    stringIndex++;
                } else {

                    if(tempI == i && tempJ == j){

                        zigZag[i][j] = s.charAt(stringIndex);

                        tempJ++;
                        tempI--;
                        stringIndex++;
                    } else {

                        zigZag[i][j] = 'x';
                    }
                } 
            }
        }
        return "";
    }
    
}
