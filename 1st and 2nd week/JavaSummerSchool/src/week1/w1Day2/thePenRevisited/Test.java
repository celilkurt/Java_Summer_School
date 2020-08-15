package week1.w1Day2.thePenRevisited;


public class Test {

    public static void main(String[] args){

        Shape circle= new Circle(2,"red");
        Shape rectangle= new Rectangle(80,4,"yellow");
        Pen pen = new Pen();

        pen.changeColor("black",circle);
        pen.changeColor("purple",rectangle);
        pen.drawObjectArea(circle);
        pen.drawObjectArea(rectangle);

    }

}
