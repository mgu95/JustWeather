package mgu95.weather;

import mgu95.weather.records.AirQuality;
import mgu95.weather.records.Alert;
import mgu95.weather.records.Astronomy;
import mgu95.weather.records.Wind;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface Weather {

    public AirQuality getAirQuality(String city, LocalDateTime dateTime);
    public Alert getAlert(String city, LocalDate date);
    public Astronomy getAstronomy(String city, LocalDate date);
    public Wind getWind(String city, LocalDateTime dateTime);
    public double getMaxWindSpeed(String city, LocalDate date);
    public double getTemperature(String city, LocalDateTime dateTime);
    public double getRealFeelTemperature(String city, LocalDateTime dateTime);
    public double getMaxTemperature(String city, LocalDate date);
    public double getMinTemperature(String city, LocalDate date);
    public double getAverageTemperature(String city, LocalDate date);
    public String getCondition(String city, LocalDateTime dateTime);
    public String getAverageCondition(String city, LocalDate date);
    public int getCloudCover(String city, LocalDateTime dateTime);
    public int getChanceOfRain(String city, LocalDateTime dateTime);
    public double getDailyChanceOfRain(String city, LocalDate date);
    public int getChanceOfSnow(String city, LocalDateTime dateTime);
    public double getDailyChanceOfSnow(String city, LocalDate date);
    public double getRainPrecipitation(String city, LocalDateTime dateTime);
    public double getTotalRainPrecipitation(String city, LocalDate date);
    public double getSnowPrecipitation(String city, LocalDateTime dateTime);
    public double getTotalSnowPrecipitation(String city, LocalDate date);
    public int getHumidity(String city, LocalDateTime dateTime);
    public double getAverageHumidity(String city, LocalDate date);
    public double getPressure(String city, LocalDateTime dateTime);
    public double getVisibility(String city, LocalDateTime dateTime);
    public double getAverageVisibility(String city, LocalDate date);
    public double getUvIndex(String city, LocalDateTime dateTime);
}
