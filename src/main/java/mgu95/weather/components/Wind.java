package mgu95.weather.components;

public class Wind {

    private float windSpeed;
    private int windDegree;
    private String windDirection;
    private float windGust;

    public Wind(float windSpeed, int windDegree, String windDirection, float windGust) {
        this.windSpeed = windSpeed;
        this.windDegree = windDegree;
        this.windDirection = windDirection;
        this.windGust = windGust;
    }

    public float getWindSpeed() {
        return windSpeed;
    }

    public int getWindDegree() {
        return windDegree;
    }

    public String getWindDirection() {
        return windDirection;
    }

    public float getWindGust() {
        return windGust;
    }
}
