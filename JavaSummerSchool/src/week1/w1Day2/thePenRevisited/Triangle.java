package week1.w1Day2.thePenRevisited;

public class Triangle extends Shape{

    private int width;
    private int height;

    public Triangle(String color, int width, int height) {
        super(color);
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

    @Override
    public int drawShapeArea() throws AreaException{
        int area = width*height/2;
        System.out.println(area);
        setArea(area);
        return getArea();

    }
}
