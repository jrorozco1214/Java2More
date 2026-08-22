package LeetCodeQuestions.ArraysAndStrings;

public class longestCommonPrefix14 {

    public static void main(String[] args) {

        longestCommonPrefix(new String[]{"flower","flow","flight"});
    }

    public static String longestCommonPrefix(String[] strs) {


        String firstString = strs[0];

        for(int i = 1; i < strs.length; i++){

            StringBuilder temp = new StringBuilder();

            for(int j = 0; j < firstString.length(); j++){
                

                if(firstString.charAt(i) == strs[i].charAt(j)) {

                    if(j == strs[i].length()-1) {

                        firstString = temp.toString();
                    }

                    temp.append(strs[i].charAt(j));
                } else {

                    firstString = temp.toString();
                    break;
                }
            }
        }


        return firstString.toString();
    }
}
