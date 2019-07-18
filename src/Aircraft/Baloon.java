package src.Aircraft;

import src.Towers.*;

public class Baloon extends Aircraft implements Flyable {
    private WeatherTower weathertower;

    Baloon(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions() {
        String message;
        switch(weathertower.getWeather(coordinates)) {
            case "SUN":
                message = name + "(" + id + "): The sunset looks absolutely beautiful from up here";
                weathertower.log.write(message);
                coordinates.setLongitude(coordinates.getLongitude() + 2);
                coordinates.setHeight(coordinates.getHeight() + 4);
                break;
            case "RAIN":
                message = name + "(" + id + "): Oh fuck, the rain has pooled in the Wicker Basket. We're sitting in a bath here xD";
                weathertower.log.write(message);
                coordinates.setHeight(coordinates.getHeight() - 5);
                break;
            case "FOG":
                message = name + "(" + id + "): I can't tell if we're even moving in this fog. It feels like we're in the void";
                weathertower.log.write(message);
                coordinates.setHeight(coordinates.getHeight() - 3);
                break;
            case "SNOW":
                message = name + "(" + id + "): This is surprisingly cozy; warming our hands from the thrusters, surrounded by all this beautiful snow :O";
                weathertower.log.write(message);
                coordinates.setHeight(coordinates.getHeight() - 15);
                break;
        }
        if (coordinates.getHeight() == 0) {
            message = name + "(" + id + "): We have touched down. Deflating baloon";
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
