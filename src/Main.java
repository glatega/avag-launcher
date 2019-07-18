package src;

import src.Aircraft.*;
import src.Concomitants.*;
import src.Towers.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        WeatherTower weatherTower;
        AircraftFactory factory;
        int iterations;

        if (args.length == 1) {
            BufferedReader br = null;
            try {
                br = new BufferedReader(new FileReader(args[0]));
                String line = br.readLine();
                String[] parts = line.split("\\s+");
                
                if (parts.length != 1) {
                    System.out.println("Faulty scenario: Line 1 must be a single argument");
                    return;
                } else {
                    iterations = Integer.parseInt(parts[0]);
                    
                    if (iterations <= 0) {
                        System.out.println("Faulty scenario: Line 1 must be a positive number");
                        return;
                    }
                }
                
                factory = new AircraftFactory();
                while ((line = br.readLine()) != null) {
                    parts = line.split("\\s+");
                    int longitude = Integer.parseInt(parts[2]);
                    int latitude = Integer.parseInt(parts[3]);
                    int height = Integer.parseInt(parts[4]);
                    
                    if (parts.length != 5) {
                        throw new CustomException("Scenario Error: Incorrect format");
                    } else {
                        factory.manufactureAircraft(parts[0], parts[1], longitude, latitude, height);
                    }
                }
                
                weatherTower = new WeatherTower();
                for (Flyable flyable : factory.flyables) {
                    flyable.registerTower(weatherTower);
                }

                for (int i = 0; i < iterations; i++) {
                    weatherTower.triggerWeatherChange();
                }

            } catch (IOException e) {
                e.printStackTrace();
            } catch (NumberFormatException e) {
                System.out.println(e.toString());
            } catch (CustomException e) {
                System.out.println(e.toString());
            } finally {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else {
            System.out.println("Please provide a single argument");
        }
    }
}