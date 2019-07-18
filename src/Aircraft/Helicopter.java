package src.Aircraft;

import src.Towers.*;

public class Helicopter extends Aircraft implements Flyable {
    private WeatherTower weathertower;

    Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions() {
        String message;
        switch(weathertower.getWeather(coordinates)) {
            case "SUN":
                message = name + "(" + id + "): Boy is it sunny! Good thing i have a giant fan above my head :P";
                weathertower.log.write(message);
                coordinates.setLongitude(coordinates.getLongitude() + 10);
                coordinates.setHeight(coordinates.getHeight() + 2);
                break;
            case "RAIN":
                message = name + "(" + id + "): I love watching the rain from inside my protected bubble <3";
                weathertower.log.write(message);
                coordinates.setLongitude(coordinates.getLongitude() + 5);
                break;
            case "FOG":
                message = name + "(" + id + "): It's mad foggy out here! Turning on the spotlights";
                coordinates.setLongitude(coordinates.getLongitude() + 1);
                break;
            case "SNOW":
                message = name + "(" + id + "): Frick it's cold...";
                weathertower.log.write(message);
                coordinates.setHeight(coordinates.getHeight() - 12);
                break;
        }
        if (coordinates.getHeight() == 0) {
            message = name + "(" + id + "): Touch down! Engines off";
            weathertower.log.write(message);
            weathertower.unregister(this);
        }
    }

    public void registerTower(WeatherTower WeatherTower) {
        weathertower = WeatherTower;
        weathertower.register(this);
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
