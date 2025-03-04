package flight.reservation.flight;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import flight.reservation.Airport;
import flight.reservation.Passenger;
import flight.reservation.plane.Helicopter;
import flight.reservation.plane.PassengerDrone;
import flight.reservation.plane.PassengerPlane;

public class ScheduledFlight extends Flight {

    private final List<Passenger> passengers;
    private final Date departureTime;
    private double currentPrice;

    private ScheduledFlight(ScheduledFlightBuilder builder) {
        super(builder.number, builder.departure, builder.arrival, builder.aircraft);
        this.departureTime = builder.departureTime;
        this.currentPrice = builder.currentPrice;
        this.passengers = new ArrayList<>();
    }

    public int getCrewMemberCapacity() throws NoSuchFieldException {
        if (this.aircraft instanceof PassengerPlane) {
            return ((PassengerPlane) this.aircraft).getCrewCapacity();
        }
        if (this.aircraft instanceof Helicopter) {
            return 2;
        }
        if (this.aircraft instanceof PassengerDrone) {
            return 0;
        }
        throw new NoSuchFieldException("This aircraft has no information about its crew capacity");
    }

    public void addPassengers(List<Passenger> passengers) {
        this.passengers.addAll(passengers);
    }

    public void removePassengers(List<Passenger> passengers) {
        this.passengers.removeAll(passengers);
    }

    public int getCapacity() throws NoSuchFieldException {
        if (this.aircraft instanceof PassengerPlane) {
            return ((PassengerPlane) this.aircraft).getPassengerCapacity();
        }
        if (this.aircraft instanceof Helicopter) {
            return ((Helicopter) this.aircraft).getPassengerCapacity();
        }
        if (this.aircraft instanceof PassengerDrone) {
            return 4;
        }
        throw new NoSuchFieldException("This aircraft has no information about its capacity");
    }

    public int getAvailableCapacity() throws NoSuchFieldException {
        return this.getCapacity() - this.passengers.size();
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(double currentPrice) {
        this.currentPrice = currentPrice;
    }

    public static class ScheduledFlightBuilder {
        private int number;
        private Airport departure;
        private Airport arrival;
        private Object aircraft;
        private Date departureTime;
        private double currentPrice = 100;

        public ScheduledFlightBuilder(int number, Airport departure, Airport arrival, Object aircraft, Date departureTime) {
            this.number = number;
            this.departure = departure;
            this.arrival = arrival;
            this.aircraft = aircraft;
            this.departureTime = departureTime;
        }

        public ScheduledFlightBuilder withCurrentPrice(double currentPrice) {
            this.currentPrice = currentPrice;
            return this;
        }

        public ScheduledFlight build() {
            return new ScheduledFlight(this);
        }
    }
}