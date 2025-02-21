package flight.reservation.plane;

public class Helicopter implements Aircraft {
    private final String model;
    private final int passengerCapacity;
    private static final int CREW_CAPACITY = 2;

    public Helicopter(String model) {
        this.model = model;
        if ("H1".equals(model)) {
            passengerCapacity = 4;
        } else if ("H2".equals(model)) {
            passengerCapacity = 6;
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
        return passengerCapacity;
    }

    @Override
    public int getCrewCapacity() {
        return CREW_CAPACITY;
    }
}
