import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static boolean isValidFlyable(String input) {
        String[] validFlyables = {"Helicopter", "Balloon", "JetPlane"};

        for (int i = 0; i < validFlyables.length; i++) {
            if (input.equals(validFlyables[i])) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        private static WeatherTower weatherTower;

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
                    int iterations = Integer.parseInt(parts[0]);

                    if (iterations <= 0) {
                        System.out.println("Faulty scenario: Line 1 must be a positive number");
                        return;
                    }
                    System.out.println(iterations);
                }

                while ((line = br.readLine()) != null) {
                    parts = line.split("\\s+");
                    int longitude = Integer.parseInt(parts[2]);
                    int latitude = Integer.parseInt(parts[3]);
                    int height = Integer.parseInt(parts[4]);

                    if (parts.length != 5) {
                        System.out.println("Faulty scenario: Incorrect format");
                        return;
                    } else if (!isValidFlyable(parts[0])) {
                        System.out.println("Faulty scenario: UFO");
                        return;
                    } else if (longitude < 0 || latitude < 0 || height < 0) {
                        System.out.println("Faulty scenario: Negative coordinate");
                        return;
                    } else {
                        //TODO aircraft factory
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
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