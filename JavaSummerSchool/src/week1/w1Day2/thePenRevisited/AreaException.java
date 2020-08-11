package week1.w1Day2.thePenRevisited;

public class AreaException extends Exception{

    @Override
    public String toString() {
        return "Area is too small";
    }
}
