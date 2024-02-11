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
public class WeatherService {

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
    public double getTemperature(String city, LocalDateTime dateTime) {
        return weather.getTemperature(city, dateTime);
    }
    public double getRealFeelTemperature(String city, LocalDateTime dateTime) {
        return weather.getRealFeelTemperature(city, dateTime);
    }
    public String getCondition(String city, LocalDateTime dateTime) {
        return weather.getCondition(city, dateTime);
    }
    public int getCloudCover(String city, LocalDateTime dateTime) {
        return weather.getCloudCover(city, dateTime);
    }
    public int getChanceOfRain(String city, LocalDateTime dateTime) {
        return weather.getChanceOfRain(city, dateTime);
    }
    public int getChanceOfSnow(String city, LocalDateTime dateTime) {
        return weather.getChanceOfSnow(city, dateTime);
    }
    public double getRainPrecipitation(String city, LocalDateTime dateTime) {
        return weather.getRainPrecipitation(city, dateTime);
    }
    public double getSnowPrecipitation(String city, LocalDateTime dateTime) {
        return weather.getSnowPrecipitation(city, dateTime);
    }
    public int getHumidity(String city, LocalDateTime dateTime) {
        return weather.getHumidity(city, dateTime);
    }
    public double getPressure(String city, LocalDateTime dateTime) {
        return weather.getPressure(city, dateTime);
    }
    public double getVisibility(String city, LocalDateTime dateTime) {
        return weather.getVisibility(city, dateTime);
    }
    public double getUvIndex(String city, LocalDateTime dateTime) {
        return weather.getUvIndex(city, dateTime);
    }
}
