package flight.reservation.plane;

public class PassengerDrone implements Aircraft {
    private final String model;
    private static final int PASSENGER_CAPACITY = 2;
    private static final int CREW_CAPACITY = 0; // Autonomous

    public PassengerDrone(String model) {
        if ("HypaHype".equals(model)) {
            this.model = model;
        } else {
            throw new IllegalArgumentException(String.format("Model type '%s' is not recognized", model));
        }
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public int getPassengerCapacity() {
        return PASSENGER_CAPACITY;
    }

    @Override
    public int getCrewCapacity() {
        return CREW_CAPACITY;
    }
}
