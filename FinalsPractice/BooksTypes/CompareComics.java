package FinalsPractice.BooksTypes;

import java.util.Comparator;

public class CompareComics implements Comparator<ComicBook>{

    @Override
    public int compare(ComicBook o1, ComicBook o2) {
        int result = Integer.compare(o1.getCount(), o2.getCount());

        if(result == 0){
            return Integer.compare(o1.getYears(), o2.getYears());
        }

        return result;
    }
}
