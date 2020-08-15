package week1.w1Day2.busReservation;

public class Bus {

    private Cities destination;
    private Passenger[] passengers;
    private int index = 0;
    private int pasLimit = 3;

    public Bus(Cities destination) {
        this.destination = destination;
        passengers = new Passenger[pasLimit];
    }

    public void insertPassenger(Passenger passenger){

        if(pasLimit == index){
            System.out.println("Bus is full");
        }else if(passenger.getDestination().equals(this.destination)){
            passengers[index++] = passenger;
            System.out.println("Passenger added");
        }else {
            System.out.println("Destination no equals");
        }

    }

    public Cities getDestination() {
        return destination;
    }

    public void setDestination(Cities destination) {
        this.destination = destination;
    }

    public Passenger[] getPassangers() {
        return passengers;
    }

    public void setPassangers(Passenger[] passangers) {
        this.passengers = passangers;
    }
}
