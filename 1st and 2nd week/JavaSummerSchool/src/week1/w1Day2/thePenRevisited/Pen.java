package week1.w1Day2.thePenRevisited;


public class Pen {

    public void drawObjectArea(Shape o){
        try {
            o.drawShapeArea();
        } catch (AreaException e) {
            System.out.println(e);
        }
    }

    public void changeColor(String color, Shape o){
        System.out.println("Current color is " + o.getColor());
        o.changeColor(color);
        System.out.println("New color is " + o.getColor());
    }

}
