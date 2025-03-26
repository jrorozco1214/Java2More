package TestPractice.Recursion;

public class Square {
    private int l1;
    private int l2;

    Square(int l1, int l2){
        this.l1 = l1;
        this.l2 = l2;
    }

    public int getL1() {
        return l1;
    }

    public void setL1(int l1) {
        this.l1 = l1;
    }

    public int getL2() {
        return l2;
    }

    public void setL2(int l2) {
        this.l2 = l2;
    }

    public int getArea(int l1, int l2){

        if(l2 == 0){
            return 0;
        } else {
            return l1 + (getArea(l1, l2-1));
        }


    }
}
