package DataStructures;

public class PrintAllPagesMain {
    public static void main(String[] args) {
        
        PrintAllPage p1 = new PrintAllPage();

        p1.addTo(1);
        p1.addTo(2);
        p1.addTo(3);
        p1.addTo(4);

        p1.multipleTwo();
        
        PrintAllPage.checkList();
    }
    
}
