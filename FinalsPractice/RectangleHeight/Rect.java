package FinalsPractice.RectangleHeight;

public class Rect {
    private int width;
    private int height;

    public Rect(int width, int height){
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
    
    public int getArea(int width, int height){

        if(width == 1){
            System.out.println(width + " " + height);
            return 1;
        }
        System.out.println(width + " " + height);
        return getArea(width-1, height);


    }

    



    
}
