package LeetCodeQuestions.CapitalOne;

import java.util.ArrayList;
import java.util.List;

public class textJustification68 {

    public static void main(String[] args) {

        List<String> result1 = (fullJustify(new String[]{"What", "must", "be", "acknowledgement", "shall", "be"}, 16));
        List<String> result2 = (fullJustify(new String[]{"Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"}, 20));

        printStatement(result1);
        printStatement(result2);

    }

    public static List<String> fullJustify(String[] words, int maxWidth) {

        ArrayList<String> result = new ArrayList<>();

        int i = 0;

        while(true){

            int lineLength = 0;
            int numWords = 0;

            while(i < words.length && lineLength + words[i].length() <= maxWidth){ //looping through the array
                

                lineLength += words[i].length() + 1;
                i++;
                numWords++;
            }

            if(i == words.length){

                StringBuilder lastLine = new StringBuilder();

                for(int j = words.length-numWords; j < words.length-1; j++){

                    lastLine
                        .append(words[j])
                        .append(" ");
                }

                lastLine.append(words[words.length-1]);

                int leftOverSpace = maxWidth - lastLine.length();

                lastLine.append(" ".repeat(leftOverSpace));

                result.add(lastLine.toString());

                break;

            } else if(numWords == 1){

                String singleWord = words[i-1];

                int endSpaces = maxWidth - singleWord.length();

                String oneWordLine = singleWord + " ".repeat(endSpaces);
                
                result.add(oneWordLine);

            } else {

                int numSpaces = numWords + (maxWidth - lineLength);
                int gaps = numWords-1;
                int spacesPerGap = numSpaces / gaps;
                int leftSpaces = numSpaces % gaps; //refers to the number of gaps that will get an extra space

                StringBuilder line = new StringBuilder();


                for(int j = i - numWords; j < i-1; j++){

                    line.append(words[j]);
                    
                    line.append(" ".repeat(spacesPerGap));

                    if(leftSpaces > 0){

                        line.append(" ");
                        leftSpaces--;
                    }
                }

                line.append(words[i-1]);
                result.add(line.toString());
            }
        }

        return result;
    }

    public static void printStatement(List<String> result){

        for(String x: result){

            System.out.println("| " + x + " |");
        }
    }
}
