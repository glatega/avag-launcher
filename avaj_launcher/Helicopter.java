public class Helicopter extends Aircraft {
    private WeatherTower weathertower;

    private Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions() {
        Path file = Paths.get("simulation.txt");
        switch(weathertower.getWeather(coordinates)) {
            case "SUN":
                String message = "Boy is it sunny! Good thing i have a giant fan above my head :P";
                Files.write(file, message.getBytes(), StandardOpenOption.APPEND);
                coordinates.setLongitude(coordinates.getLongitude() + 10);
                coordinates.setHeight(coordinates.getHeight() + 2);
                if (coordinates.getHeight() == 0) {
                    weathertower.unregister(this);
                }
                break;
            case "RAIN":
                // soo sunnY!
                coordinates.setLongitude(coordinates.getLongitude() + 10);
                coordinates.setHeight(coordinates.getHeight() + 2);
                if (coordinates.getHeight() == 0) {
                    weathertower.unregister(this);
                }
                break;
            case "FOG":
                // soo sunnY!
                coordinates.setLongitude(coordinates.getLongitude() + 10);
                coordinates.setHeight(coordinates.getHeight() + 2);
                if (coordinates.getHeight() == 0) {
                    weathertower.unregister(this);
                }
                break;
            case "SNOW":
                // soo sunnY!
                coordinates.setLongitude(coordinates.getLongitude() + 10);
                coordinates.setHeight(coordinates.getHeight() + 2);
                if (coordinates.getHeight() == 0) {
                    weathertower.unregister(this);
                }
                break;
          }
    }

    public void registerTower(WeatherTower WeatherTower) {
        weathertower = WeatherTower;
    }
}
