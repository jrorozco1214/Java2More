package TestPractice.Recursion.RectangleMath;

public class Rectangle {


    private int width;
    private int height;
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

        if(width == 0){
            return 0;
        }
        System.out.println(width + " " + height);
        return getArea(width-1, height);
    }
    
}
