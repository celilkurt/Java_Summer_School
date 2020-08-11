package week1.w1Day2.thePen;

public class Pen{




    public void drawRectangle(Rectangle r){
        System.out.println("Area of rectangle: " + (r.getHeight()* r.getWidth()));
    }

    public void drawCircle(Circle c){
        System.out.println("Area of circle: " + (Math.PI*c.getRadius()*2));
    }

    public void changeColorCircle(String color, Circle c){
        System.out.println("Color of circle: " + c.getColor());
        c.setColor(color);
        System.out.println("New color of circle: " + c.getColor());
    }

    public void changeColorRectangle(String color, Rectangle r){
        System.out.println("Color of rectangle: " + r.getColor());
        r.setColor(color);
        System.out.println("New color of rectangle: " + r.getColor());
    }

}