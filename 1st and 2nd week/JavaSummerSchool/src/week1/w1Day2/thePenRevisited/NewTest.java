package week1.w1Day2.thePenRevisited;

import java.util.Random;

public class NewTest {

    public static void main(String[] args){
        Random rnd = new Random();
        int key;
        int n = 10;
        Shape[] shapes = new Shape[n];
        Pen pen = new Pen();

        for(int i = 0; i < n; i++){


            key = rnd.nextInt(100)+1;
            switch(key%4){
                case 0:
                    System.out.println("Created a circle.");
                    shapes[i] = new Circle(key,"red");
                    break;
                case 1:
                    System.out.println("Created a rectangle.");
                    shapes[i] = new Rectangle(key,key/2,"red");
                    break;
                case 2:
                    System.out.println("Created a square.");
                    shapes[i] = new Square("red",key);
                    break;
                case 3:
                    System.out.println("Created a triangle.");
                    shapes[i] = new Triangle("red",key,key/3);
                    break;

            }
        }

        for(Shape shape: shapes)
            pen.drawObjectArea(shape);


    }
}
