public class PracticeCompilerForQuestions {
    public static void main(String[] args) {
        //System.out.println(reverseString("Jeremy"));
        //contains("characters", 't');

        System.out.print(replace("Hello down there"));
    }
/*public static String reverseString(String str){
        if(str.length() <= 1){
            return str;
        } else {
            return (reverseString(str.substring(1)) + str.charAt(0));
        }
    }
 */
    /*public static boolean contains(String str, char c){
        if(str.length() < 1){
            return false;
        } else if(str.charAt(0) == c){
            return true;
        } else {
            return (contains(str.substring(1), c));
        }
    } */

    public static String replace(String str){
        if(str.length() == 0){
            return str;
        } else if(str.charAt(0) == ' '){
            return "-" + replace(str.substring(1));
        } else {
            return str.charAt(0) + replace(str.substring(1));
        }
    }

}
