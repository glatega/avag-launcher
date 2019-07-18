package src.Aircraft;

import src.Concomitants.CustomException;

import java.util.List;
import java.util.ArrayList;

public class AircraftFactory {
    public List<Flyable> flyables;

    public AircraftFactory() {
        flyables = new ArrayList<Flyable>();
    }

    public void manufactureAircraft(String type, String name, int longitude, int latitude, int height) throws CustomException {
        Flyable aircraft = newAircraft(type, name, longitude, latitude, height);
        flyables.add(aircraft);
    }

    public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height) throws CustomException {
        Coordinates coordinates = new Coordinates(longitude, latitude, height);

        switch(type) {
            case "Helicopter":
                return new Helicopter(name, coordinates);
            case "JetPlane":
                return new JetPlane(name, coordinates);
            case "Baloon":
                return new Baloon(name, coordinates);
            default:
                throw new CustomException("Scenario Error: Unknown Aircraft Request");
        }
    }
}