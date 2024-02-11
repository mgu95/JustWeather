package mgu95.weather.records;

import java.time.LocalDateTime;
import java.util.Arrays;

public record Forecast(LocalDateTime updateDateTime,
                       String city,
                       String country,
                       Day[] days) {
    @Override
    public String toString() {
        return "Forecast{\n" +
                "   updateDateTime=" + updateDateTime + "\n" +
                "   city=" + city + "\n" +
                "   country=" + country + "\n" +
                "   days=" + Arrays.toString(days) + "\n" +
                '}';
    }
}
