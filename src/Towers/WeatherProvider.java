package src.Towers;

import src.Aircraft.Coordinates;

public class WeatherProvider {
    static private WeatherProvider weatherProvider;
    static private String[] weather;

    private WeatherProvider() {
        weather = new String[]{"SUN", "RAIN", "FOG", "SNOW"};
    }

    static public WeatherProvider getProvider() {
        if (weatherProvider == null) {
            weatherProvider = new WeatherProvider();
        }
        return weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates) {
        if (coordinates.getHeight() < 90) {
            if (coordinates.getLongitude() > coordinates.getLatitude()) {
                if (coordinates.getHeight() < 50) {
                    return weather[2];
                } else {
                    return weather[1];
                }
            } else {
                return weather[3];
            }
        } else {
            return weather[0];
        }
    }
}