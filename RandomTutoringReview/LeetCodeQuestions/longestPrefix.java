package LeetCodeQuestions;
public class longestPrefix {

    public static void main(String[] args) {
        String[] ar = {"hell", "hello"};
        System.out.println(longestCommonPrefix(ar));
    }

    public static String longestCommonPrefix(String[] strs) {
        int characterIndex = 0;

        outer: while(true){

            if(strs[0].length() == characterIndex){
                break outer;
            }

            char store = strs[0].charAt(characterIndex);

            for(int i = 1; i <= strs.length-1; i++){

                if(strs[i].length() == characterIndex || strs[i].charAt(characterIndex) != store){
                    break outer;
                }
            }
            characterIndex++;
        }

        return strs[0].substring(0,characterIndex);

    }
    /*
    IN the funciton we're getting the characterindex and comparing the first character that is the in the first element of the array to the first character in the second array 
    we will keeep looping until this is false break the loop and return the substring from the index 
    
    */    
}
