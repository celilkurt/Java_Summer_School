package week1.w1Day2.thePenRevisited;

public class Square extends Shape{

    private int size;

    public Square(String color,int size) {
        super(color);
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public int drawShapeArea() throws AreaException{
        int area = size*size;
        System.out.println(area);
        setArea(area);
        return getArea();

    }
}
