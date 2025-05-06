package FinalsPractice.BooksTypes;

public class ComicBook extends Book implements Text, Comparable<ComicBook>{

    private int count;

    public ComicBook(int years, int count){
        super(years);
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String toString(){
        return super.toString() + this.count;
    }

    public void flipPages(){
        System.out.println("flipping pages");
    }

    @Override
    public int compareTo(ComicBook o) {
        int result = Integer.compare(super.getYears(), o.getYears());

        if(result == 0){
            return Integer.compare(this.count, o.count);
        }
        return result;
    }

    @Override
    public void read() {
        System.out.println("Someone is reading right now");
    }
}
