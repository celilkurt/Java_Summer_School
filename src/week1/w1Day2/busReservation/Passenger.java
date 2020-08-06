package week1.w1Day2.busReservation;

public class Passenger {

    private String name;
    private Cities destination;

    public Passenger(String name, Cities destination) {
        this.name = name;
        this.destination = destination;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Cities getDestination() {
        return destination;
    }

    public void setDestination(Cities destination) {
        this.destination = destination;
    }
}
