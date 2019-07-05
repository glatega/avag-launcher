public class WeatherTower extends Tower {
    public String getWeather(Coordinates coordinates) {
        return WeatherProvider.getProvider().getCurrentWeather(coordinates);
    }

    protected void changeWeather() {
        conditionsChanged();
    }
}
List<String> lines = Arrays.asList("The first line", "The second line");
Path file = Paths.get("the-file-name.txt");
Files.write(file, lines, StandardCharsets.UTF_8);
//Files.write(file, lines, StandardCharsets.UTF_8, StandardOpenOption.APPEND);