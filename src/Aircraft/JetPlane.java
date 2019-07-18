package src.Aircraft;

import src.Towers.*;

public class JetPlane extends Aircraft implements Flyable {
    private WeatherTower weathertower;

    JetPlane(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions() {
        String message;
        switch(weathertower.getWeather(coordinates)) {
            case "SUN":
                message = name + "(" + id + "): I'm racing the sun rays :D";
                weathertower.log.write(message);
                coordinates.setLatitude(coordinates.getLatitude() + 10);
                coordinates.setHeight(coordinates.getHeight() + 2);
                break;
            case "RAIN":
                message = name + "(" + id + "): These raindrops are hitting like bullets!";
                weathertower.log.write(message);
                coordinates.setLatitude(coordinates.getLatitude() + 5);
                break;
            case "FOG":
                message = name + "(" + id + "): I have to reduce my speed, this fog makes it impossible to see.";
                weathertower.log.write(message);
                coordinates.setLatitude(coordinates.getLatitude() + 1);
                break;
            case "SNOW":
                message = name + "(" + id + "): I'm going to overclock my engines, the snow should take care of the overheating ;)";
                weathertower.log.write(message);
                coordinates.setHeight(coordinates.getHeight() - 7);
                break;
            }
        if (coordinates.getHeight() == 0) {
            message = name + "(" + id + "): Smooth landing. Taking her to the hangar.";
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
