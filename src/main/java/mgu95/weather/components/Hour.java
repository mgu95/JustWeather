package mgu95.weather.components;

import java.time.LocalTime;

public class Hour {

    private AirQuality airQuality;
    private Wind wind;
    private LocalTime time;
    private float temperature;
    private float realFeelTemperature;
    private String condition;
    private int cloudCover;
    private int chanceOfRain;
    private int chanceOfSnow;
    private float rainPrecipitation;
    private float snowPrecipitation;
    private int humidity;
    private float pressure;
    private float visibility;
    private float uvIndex;

    public Hour(AirQuality airQuality, Wind wind, LocalTime time, float temperature, float realFeelTemperature,
                String condition, int cloudCover, int chanceOfRain, int chanceOfSnow, float rainPrecipitation,
                float snowPrecipitation, int humidity, float pressure, float visibility, float uvIndex) {
        this.airQuality = airQuality;
        this.wind = wind;
        this.time = time;
        this.temperature = temperature;
        this.realFeelTemperature = realFeelTemperature;
        this.condition = condition;
        this.cloudCover = cloudCover;
        this.chanceOfRain = chanceOfRain;
        this.chanceOfSnow = chanceOfSnow;
        this.rainPrecipitation = rainPrecipitation;
        this.snowPrecipitation = snowPrecipitation;
        this.humidity = humidity;
        this.pressure = pressure;
        this.visibility = visibility;
        this.uvIndex = uvIndex;
    }

    public AirQuality getAirQuality() {
        return airQuality;
    }

    public Wind getWind() {
        return wind;
    }

    public LocalTime getTime() {
        return time;
    }

    public float getTemperature() {
        return temperature;
    }

    public float getRealFeelTemperature() {
        return realFeelTemperature;
    }

    public String getCondition() {
        return condition;
    }

    public int getCloudCover() {
        return cloudCover;
    }

    public int getChanceOfRain() {
        return chanceOfRain;
    }

    public int getChanceOfSnow() {
        return chanceOfSnow;
    }

    public float getRainPrecipitation() {
        return rainPrecipitation;
    }

    public float getSnowPrecipitation() {
        return snowPrecipitation;
    }

    public int getHumidity() {
        return humidity;
    }

    public float getPressure() {
        return pressure;
    }

    public float getVisibility() {
        return visibility;
    }

    public float getUvIndex() {
        return uvIndex;
    }
}
