package TestPractice.Recursion;

public class FindingIndexOfString {
    public static void main(String[] args) {
        
        System.out.println(hIndex("Mississippi", "x"));
    }

    public static int hIndex(String txt, String str){
        return indexOf(txt, str, 0);
    }
    
    public static int indexOf(String txt, String str, int count){
    
    if(count >= txt.length()){
        return -1;
    } else if(txt.startsWith(str, count)){
        return count;
    }
    return indexOf(txt, str, count+1);

    }

}
