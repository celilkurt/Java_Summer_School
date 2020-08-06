package week1.w1Day2.thePenRevisited;

public class Rectangle extends Shape {

    private int width;
    private int height;

    public Rectangle(int width, int height, String color) {
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

        int area = width*height;
        System.out.println(area);
        setArea(area);
        return getArea();

    }

}
