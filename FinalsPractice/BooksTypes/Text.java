package FinalsPractice.BooksTypes;

public interface Text {

    void read();

    public default void pages(ComicBook c){
        System.out.println(c.getCount());
    }
    
}
