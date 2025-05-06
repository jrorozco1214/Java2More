package FinalsPractice.BooksTypes;

public class Book {
    private int years;

    public Book(int years){
        this.years = years;
    }

    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }

    public String toString(){
        return "" + this.years;
    }

    public void skim(){
        System.out.println("Skimming");
    }
    
}
