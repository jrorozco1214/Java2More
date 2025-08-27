import java.util.ArrayList;

public class testMain {
    public static void main(String[] args) {
        
    ArrayList <Double> dnum = new ArrayList<>();

    dnum.add(12.2);
    dnum.add(4.5);
    dnum.add(2.8);
    dnum.add(2, 9.2);
    dnum.remove(2);
    dnum.size();


    for(double n: dnum){
        System.out.println(n);
    }

    for(int i = 0; i < dnum.size(); i++){
        System.out.println(dnum.get(i));
    }

    }
}
