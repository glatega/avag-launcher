package src.Towers;

import src.Aircraft.Coordinates;
import src.Aircraft.Flyable;

public class WeatherTower extends Tower {
    public String getWeather(Coordinates coordinates) {
        return WeatherProvider.getProvider().getCurrentWeather(coordinates);
    }

    public void triggerWeatherChange() {
        changeWeather();
    }

    void changeWeather() {
        conditionsChanged();
    }

    public void register(Flyable flyable) {
        super.register(flyable);
        log.write("Tower says: " + flyable.getName() + "(" + flyable.getId() + ") registered to weather tower");
    }

    public void unregister(Flyable flyable) {
        super.unregister(flyable);
        log.write("Tower says: " + flyable.getName() + "(" + flyable.getId() + ") unregistered from weather tower");
    }
}