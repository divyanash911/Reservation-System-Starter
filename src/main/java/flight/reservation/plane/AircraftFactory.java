package flight.reservation.plane;

public class AircraftFactory {

    public static Aircraft createAircraft(String type, String model) {
        switch (type.toLowerCase()) {
            case "plane":
                return new PassengerPlane(model);
            case "drone":
                return new PassengerDrone(model);
            case "helicopter":
                return new Helicopter(model);
            default:
                throw new IllegalArgumentException(String.format("Aircraft type '%s' is not recognized", type));
        }
    }
    
}