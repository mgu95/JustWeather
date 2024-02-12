package mgu95.services;

import mgu95.weather.Weather;
import mgu95.weather.WeatherAPI;
import mgu95.weather.records.AirQuality;
import mgu95.weather.records.Alert;
import mgu95.weather.records.Astronomy;
import mgu95.weather.records.Wind;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class WeatherService implements Weather{

    Weather weather = new WeatherAPI();

    public AirQuality getAirQuality(String city, LocalDateTime dateTime) {
        return weather.getAirQuality(city, dateTime);
    }
    public Alert getAlert(String city, LocalDate date) {
        return weather.getAlert(city, date);
    }
    public Astronomy getAstronomy(String city, LocalDate date) {
        return weather.getAstronomy(city, date);
    }
    public Wind getWind(String city, LocalDateTime dateTime) {
        return weather.getWind(city, dateTime);
    }
    public double getMaxWindSpeed(String city, LocalDate date) {
        return weather.getMaxWindSpeed(city, date);
    }
    public double getTemperature(String city, LocalDateTime dateTime) {
        return weather.getTemperature(city, dateTime);
    }
    public double getRealFeelTemperature(String city, LocalDateTime dateTime) {
        return weather.getRealFeelTemperature(city, dateTime);
    }
    public double getMaxTemperature(String city, LocalDate date) {
        return weather.getMaxTemperature(city, date);
    }
    public double getMinTemperature(String city, LocalDate date) {
        return weather.getMinTemperature(city, date);
    }
    public double getAverageTemperature(String city, LocalDate date) {
        return weather.getAverageTemperature(city, date);
    }
    public String getCondition(String city, LocalDateTime dateTime) {
        return weather.getCondition(city, dateTime);
    }
    public String getAverageCondition(String city, LocalDate date) {
        return weather.getAverageCondition(city, date);
    }
    public int getCloudCover(String city, LocalDateTime dateTime) {
        return weather.getCloudCover(city, dateTime);
    }
    public int getChanceOfRain(String city, LocalDateTime dateTime) {
        return weather.getChanceOfRain(city, dateTime);
    }
    public double getDailyChanceOfRain(String city, LocalDate date) {
        return weather.getDailyChanceOfRain(city, date);
    }
    public int getChanceOfSnow(String city, LocalDateTime dateTime) {
        return weather.getChanceOfSnow(city, dateTime);
    }
    public double getDailyChanceOfSnow(String city, LocalDate date) {
        return weather.getDailyChanceOfSnow(city, date);
    }
    public double getRainPrecipitation(String city, LocalDateTime dateTime) {
        return weather.getRainPrecipitation(city, dateTime);
    }
    public double getTotalRainPrecipitation(String city, LocalDate date) {
        return weather.getTotalRainPrecipitation(city, date);
    }
    public double getSnowPrecipitation(String city, LocalDateTime dateTime) {
        return weather.getSnowPrecipitation(city, dateTime);
    }
    public double getTotalSnowPrecipitation(String city, LocalDate date) {
        return weather.getTotalSnowPrecipitation(city, date);
    }
    public int getHumidity(String city, LocalDateTime dateTime) {
        return weather.getHumidity(city, dateTime);
    }
    public double getAverageHumidity(String city, LocalDate date) {
        return weather.getAverageHumidity(city, date);
    }
    public double getPressure(String city, LocalDateTime dateTime) {
        return weather.getPressure(city, dateTime);
    }
    public double getVisibility(String city, LocalDateTime dateTime) {
        return weather.getVisibility(city, dateTime);
    }
    public double getAverageVisibility(String city, LocalDate date) {
        return weather.getAverageVisibility(city, date);
    }
    public double getUvIndex(String city, LocalDateTime dateTime) {
        return weather.getUvIndex(city, dateTime);
    }
}
