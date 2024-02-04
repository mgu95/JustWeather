package mgu95.weather.components;

import java.time.LocalDate;

public class Day {

    private LocalDate date;
    private Hour[] hours;
    private Astronomy astronomy;
    private float maxTemperature;
    private float minTemperature;
    private float averageTemperature;
    private float maxWindSpeed;
    private float totalRainPrecipitation;
    private float totalSnowPrecipitation;
    private float averageVisibility;
    private int averageHumidity;
    private int dailyChanceOfRain;
    private int dailyChanceOfSnow;
    private String averageCondition;

    public Day(LocalDate date, Hour[] hours, Astronomy astronomy, float maxTemperature, float minTemperature,
               float averageTemperature, float maxWindSpeed, float totalRainPrecipitation, float totalSnowPrecipitation,
               float averageVisibility, int averageHumidity, int dailyChanceOfRain, int dailyChanceOfSnow,
               String averageCondition) {
        this.date = date;
        this.hours = hours;
        this.astronomy = astronomy;
        this.maxTemperature = maxTemperature;
        this.minTemperature = minTemperature;
        this.averageTemperature = averageTemperature;
        this.maxWindSpeed = maxWindSpeed;
        this.totalRainPrecipitation = totalRainPrecipitation;
        this.totalSnowPrecipitation = totalSnowPrecipitation;
        this.averageVisibility = averageVisibility;
        this.averageHumidity = averageHumidity;
        this.dailyChanceOfRain = dailyChanceOfRain;
        this.dailyChanceOfSnow = dailyChanceOfSnow;
        this.averageCondition = averageCondition;
    }

    public LocalDate getDate() {
        return date;
    }

    public Hour[] getHours() {
        return hours;
    }

    public Astronomy getAstronomy() {
        return astronomy;
    }

    public float getMaxTemperature() {
        return maxTemperature;
    }

    public float getMinTemperature() {
        return minTemperature;
    }

    public float getAverageTemperature() {
        return averageTemperature;
    }

    public float getMaxWindSpeed() {
        return maxWindSpeed;
    }

    public float getTotalRainPrecipitation() {
        return totalRainPrecipitation;
    }

    public float getTotalSnowPrecipitation() {
        return totalSnowPrecipitation;
    }

    public float getAverageVisibility() {
        return averageVisibility;
    }

    public int getAverageHumidity() {
        return averageHumidity;
    }

    public int getDailyChanceOfRain() {
        return dailyChanceOfRain;
    }

    public int getDailyChanceOfSnow() {
        return dailyChanceOfSnow;
    }

    public String getAverageCondition() {
        return averageCondition;
    }
}
