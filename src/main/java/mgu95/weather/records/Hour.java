package mgu95.weather.records;

import java.time.LocalTime;

public record Hour(AirQuality airQuality,
                   Wind wind,
                   LocalTime time,
                   double temperature,
                   double realFeelTemperature,
                   String condition,
                   int cloudCover,
                   int chanceOfRain,
                   int chanceOfSnow,
                   double rainPrecipitation,
                   double snowPrecipitation,
                   int humidity,
                   double pressure,
                   double visibility,
                   double uvIndex) {
    @Override
    public String toString() {
        return "\n            Hour{" +
                "airQuality=" + airQuality +
                ", wind=" + wind +
                ", time=" + time +
                ", temperature=" + temperature +
                ", realFeelTemperature=" + realFeelTemperature +
                ", condition='" + condition + '\'' +
                ", cloudCover=" + cloudCover +
                ", chanceOfRain=" + chanceOfRain +
                ", chanceOfSnow=" + chanceOfSnow +
                ", rainPrecipitation=" + rainPrecipitation +
                ", snowPrecipitation=" + snowPrecipitation +
                ", humidity=" + humidity +
                ", pressure=" + pressure +
                ", visibility=" + visibility +
                ", uvIndex=" + uvIndex +
                '}';
    }
}
