package week1.w1Day2.thePenRevisited;

public class Circle extends Shape{

    private int radius;

    public Circle(int radius, String color) {
        super(color);
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }


    @Override
    public int drawShapeArea() throws AreaException{

        int area = (int)Math.PI*2*radius;
        System.out.println(area);
        setArea((int)Math.PI*2*radius);
        return getArea();
    }

}
