package FinalsPractice.BooksTypes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BookMain {
    public static void main(String[] args) {
        
    ArrayList<Book> c = new ArrayList<>();
    c.add(new ComicBook(15, 1200));
    c.add(new ComicBook(6, 1250));
    c.add(new ComicBook(15, 1500));
    c.add(new Book(12));

    //Collections.sort(c);
    //Collections.sort(c, new CompareComics());


    Book b1 = new ComicBook(1600, 12);

    Text t1 = new ComicBook(12, 14);
    
    for(Book cs: c){
        if(cs instanceof ComicBook){
            System.out.println(cs.toString());
        }
    }


    


    }
    
}
