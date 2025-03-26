package TestPractice.Recursion;

public class Rectangle {

    private int width;
    private int height;


    public Rectangle(int width, int height){
        this.width = width;
        this.height = height;
    }

    public int getArea(int width, int height){
        if(width < 0 || width == 0){
            return 0;
        } else {
            return height + getArea(width - 1, height);
        }
    }

    public void setWidth(int width){
        this.width = width;
    }

    public void setHeight(int height){
        this.height = height;
    }

    public int getWidth(){
        return this.width;
    }

    public int getHeight(){
        return this.height;
    }
    
}
