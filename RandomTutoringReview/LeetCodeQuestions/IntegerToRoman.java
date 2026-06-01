package LeetCodeQuestions;
public class IntegerToRoman {

    public static void main(String[] args) {

        System.out.println(intToRoman(50_000));

    }

    /*
    this is taking input and determining the ones, tens, hundreds, and thousands
    and looking at the special cases of 4, 40, 400 and 9, 90, 900
    once it's getting larger then 1000 such as 4000 or 9000 or even 5000 it's M by default or a bunch of M's

    */
    

    public static String intToRoman(int num) {
        // write your code here
        String result = "";

        int valueLeft = num;

        int mCount = valueLeft / 1000;
        valueLeft -= mCount * 1000;

        int cCount = valueLeft / 100;
        valueLeft -= cCount * 100;

        int xCount = valueLeft / 10;
        valueLeft -= xCount * 10;

        int iCount = valueLeft;

        String ones = "";
        String tens = "";
        String hundreds = "";
        String thousands = "";

        if(iCount == 4){
            ones = "IV";
        } else if(iCount == 9){
            ones = "IX";
        } else {
            if(iCount > 5){
                ones = "V";
                iCount -= 5;
            }
            ones += "I".repeat(iCount);
        }

        if(xCount == 4){
            tens = "XL";
        } else if(xCount == 9){
            tens = "XC";
        } else {
            if(xCount > 5){
                tens = "L";
                xCount -= 5;
            }
            tens += "X".repeat(xCount);
        }

        if(cCount == 4){
            hundreds = "CD";
        } else if(cCount == 9){
            hundreds = "CM";
        } else {
            if(cCount > 5){
                hundreds = "D";
                cCount -= 5;
            }
            hundreds += "C".repeat(cCount);
        }

        thousands += "M".repeat(mCount);


        //M".repeat(mCount) + "C".repeat(cCount) + "X".repeat(xCount) + "I".repeat(iCount)
        return thousands + hundreds + tens + ones;
    }
    
}
