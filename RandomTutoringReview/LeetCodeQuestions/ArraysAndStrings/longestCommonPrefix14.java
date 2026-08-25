package LeetCodeQuestions.ArraysAndStrings;

public class longestCommonPrefix14 {

    public static void main(String[] args) {

        System.out.println(longestCommonPrefix(new String[]{"dog","racecar","car"}));
    }

    public static String longestCommonPrefix(String[] strs) {


        String firstString = strs[0];

        if(firstString.length() <= 0){

            return "";
        }

        for(int i = 1; i < strs.length; i++){
            

            StringBuilder temp = new StringBuilder();

            int indexFirstString = 0;
            int indexSecondString = 0;

            while(indexFirstString < firstString.length() && indexFirstString < strs[i].length() && firstString.charAt(indexFirstString) == strs[i].charAt(indexSecondString)){

                temp.append(strs[i].charAt(indexSecondString));
                indexFirstString++;
                indexSecondString++;
            }

            if(temp.isEmpty()){

                return "";
            }

            firstString = temp.toString();
        }


        return firstString.toString();
    }

    public String longestCommonPrefixTwo(String[] strs) {

        if (strs.length == 0) return "";
        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++)


            while (strs[i].indexOf(prefix) != 0) {

            System.out.println(strs[i].indexOf(prefix));
            prefix = prefix.substring(0, prefix.length() - 1);

            if (prefix.isEmpty()) {
                return "";
            }
        }
        return prefix;
    }
}
