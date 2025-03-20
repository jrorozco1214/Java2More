public class SplitMethod {
public static void main(String[] args) {
    
    String s1 = "8,9,9,8,5";
    String[] sT = s1.split(",");

    int total = 0;


    for(int i = 0; i < sT.length; i++){
        total += Integer.parseInt(sT[i]);
    }


    System.out.println(total);

    } 
}
