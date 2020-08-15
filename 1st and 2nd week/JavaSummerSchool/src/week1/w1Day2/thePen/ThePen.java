package week1.w1Day2.thePen;

import java.util.Scanner;

public class ThePen {

    public static void main(String[] args){

        Scanner sc= new Scanner(System.in);
        System.out.println("For 'draw rectangle' enter 1" +
                "\nFor 'draw circle' enter 2" +
                "\nFor 'change circleColor' enter 3" +
                "\nFor 'change rectangleColor' enter 4" +
                "\nFor exit enter -1");

        Circle circle= new Circle(2,"red");
        Rectangle rectangle= new Rectangle(4,4,"yellow");
        Pen pen = new Pen();

        int choice = 0;
        while(choice != -1){

            choice = sc.nextInt();
            switch (choice){
                case 1:
                    pen.drawRectangle(rectangle);
                    break;
                case 2:
                    pen.drawCircle(circle);
                    break;
                case 3:
                    pen.changeColorCircle("blue",circle);
                    break;
                case 4:
                    pen.changeColorRectangle("white",rectangle);
                    break;

            }


        }

    }






}
