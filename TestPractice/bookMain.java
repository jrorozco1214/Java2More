package TestPractice;

public class bookMain {
    public static void main(String[] args) {
        
    book b1 = new book("The Hunger Games", "Suzanne Collins", 15.99);

    b1.displayDetails();

    discount(b1);

    }

    public static double discount(book b){
        return b.getPrice() * 0.15;
    }
    
}
