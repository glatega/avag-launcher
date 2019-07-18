package src.Aircraft;

import src.Concomitants.CustomException;

public class Coordinates {
    private int longitude;
    private int latitude;
    private int height;

    Coordinates(int longitude, int latitude, int height) throws CustomException {
        if (longitude < 0) {
            throw new CustomException("Scenario Error: Negative Longitude");
        } else if (latitude < 0) {
            throw new CustomException("Scenario Error: Negative Latitude");
        } else if (height < 0) {
            throw new CustomException("Scenario Error: Negative Height");
        } else {
            setLongitude(longitude);
            setLatitude(latitude);
            setHeight(height);
        }
    }

    public int getLongitude() {
        return longitude;
    }

    public int getLatitude() {
        return latitude;
    }

    public int getHeight() {
        return height;
    }

    public void setLongitude(int value) {
        longitude = value;
    }

    public void setLatitude(int value) {
        latitude = value;
    }

    public void setHeight(int value) {
        if (value <= 0) {
            height = 0;
        } else {
            height = value;
        }
    }
}
