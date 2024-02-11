package mgu95.weather.records;

import java.time.LocalDate;
import java.util.Arrays;

public record Day(LocalDate date,
                  Hour[] hours,
                  Astronomy astronomy,
                  double maxTemperature,
                  double minTemperature,
                  double averageTemperature,
                  double maxWindSpeed,
                  double totalRainPrecipitation,
                  double totalSnowPrecipitation,
                  double averageVisibility,
                  int averageHumidity,
                  int dailyChanceOfRain,
                  int dailyChanceOfSnow,
                  String averageCondition) {
    @Override
    public String toString() {
        return "\n      Day{" + "\n" +
                "         date=" + date + "\n" +
                "         hours=" + Arrays.toString(hours) + "\n" +
                "         astronomy=" + astronomy + "\n" +
                "         maxTemperature=" + maxTemperature + "\n" +
                "         minTemperature=" + minTemperature + "\n" +
                "         averageTemperature=" + averageTemperature + "\n" +
                "         maxWindSpeed=" + maxWindSpeed + "\n" +
                "         totalRainPrecipitation=" + totalRainPrecipitation + "\n" +
                "         totalSnowPrecipitation=" + totalSnowPrecipitation + "\n" +
                "         averageVisibility=" + averageVisibility + "\n" +
                "         averageHumidity=" + averageHumidity + "\n" +
                "         dailyChanceOfRain=" + dailyChanceOfRain + "\n" +
                "         dailyChanceOfSnow=" + dailyChanceOfSnow + "\n" +
                "         averageCondition=" + averageCondition + "\n" +
                "      }";
    }
}
