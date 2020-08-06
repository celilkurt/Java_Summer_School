package week1.w1Day2.thePenRevisited;

public abstract class Shape {

    private String color;
    private int area;

    public Shape(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getArea() throws AreaException{
        if(area < 50){
            throw new AreaException();
        }else
            return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public int drawShapeArea() throws AreaException { return 0;};


    public void changeColor(String color){
        this.color = color;
    };


}
