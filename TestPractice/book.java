package TestPractice;

public class book {

    private String title;
    private String author;
    private double price;

    public book(String title, String author, double price){
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author){
        this.author = author;
    }

    public void setPrice(double price){
        this.price = price;
    }

    public String getTitle(){
        return this.title;
    }

    public String getAuthor(){
        return this.author;
    }

    public double getPrice(){
        return this.price;
    }

    public void displayDetails(){
        System.out.println(title + " written by " + author + " the price is " + price);
    }
    
}
