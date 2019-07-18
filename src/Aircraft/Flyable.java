package src.Aircraft;

import src.Towers.WeatherTower;

public interface Flyable {
    public void updateConditions();

    public void registerTower(WeatherTower WeatherTower);

    public long getId();

    public String getName();
}
