package week1.w1Day2.busReservation;

public class Main {



    public static void main(String[] args){

        Bus bus = new Bus(Cities.ANKARA);
        Bus bus2 = new Bus(Cities.İSTANBUL);
        Bus bus3 = new Bus(Cities.İZMİR);

        Passenger p1 = new Passenger("Ali",Cities.ANKARA);
        Passenger p2 = new Passenger("Ali",Cities.İZMİR);
        Passenger p3 = new Passenger("Ali",Cities.İSTANBUL);
        bus2.insertPassenger(p1);
        bus.insertPassenger(p1);
        bus.insertPassenger(p1);
        bus.insertPassenger(p1);
        bus.insertPassenger(p1);
    }
}
