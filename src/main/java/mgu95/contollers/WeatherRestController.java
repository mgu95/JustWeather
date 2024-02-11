package mgu95.contollers;

import mgu95.services.WeatherService;
import mgu95.weather.records.AirQuality;
import mgu95.weather.records.Alert;
import mgu95.weather.records.Astronomy;
import mgu95.weather.records.Wind;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/weather")
public class WeatherRestController {

    WeatherService weatherService;

    @Autowired
    public void setUp(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

//    @GetMapping("/conflict")
//    public JsonNode conflict() {
//        String jsonString = "{\"k1\":\"v1\",\"k2\":\"v2\"}";
//        ObjectMapper mapper = new ObjectMapper();
//        try {
//            JsonNode actualObj = mapper.readTree(jsonString);
//            System.out.println(actualObj.toString());
//            return actualObj;
//        } catch (JsonProcessingException e) {
//            throw new RuntimeException(e);
//        }
//
//        //return HttpStatus.BAD_REQUEST;
//        //return "{" + HttpStatus.CONFLICT.value() + "}";
//    }

    @GetMapping("/conflict")
    @ResponseStatus(code = HttpStatus.CONFLICT, reason = "Incorrect date")
    public String conflict() {
        return "";
    }

    @GetMapping("/airQuality")
    public AirQuality getAirQuality(@RequestParam String city,
                                    @RequestParam @DateTimeFormat(pattern = "yyyyMMddHH") LocalDateTime dateTime) {
        AirQuality airQuality = weatherService.getAirQuality(city, dateTime);
        if (airQuality == null) {
            System.out.println("air is null!");
        }
        return weatherService.getAirQuality(city, dateTime);
    }
    public Alert getAlert(String city, LocalDate date) {
        return weatherService.getAlert(city, date);
    }
    public Astronomy getAstronomy(String city, LocalDate date) {
        return weatherService.getAstronomy(city, date);
    }

    @GetMapping("/wind")
    public Wind getWind(@RequestParam String city,
                        @RequestParam @DateTimeFormat(pattern = "yyyyMMddHH") LocalDateTime dateTime) {
        return weatherService.getWind(city, dateTime);
    }
    public double getTemperature(@RequestParam String city,
                                @RequestParam @DateTimeFormat(pattern = "yyyyMMddHH") LocalDateTime dateTime) {
        return weatherService.getTemperature(city, dateTime);
    }
    public double getRealFeelTemperature(@RequestParam String city,
                                        @RequestParam @DateTimeFormat(pattern = "yyyyMMddHH") LocalDateTime dateTime) {
        return weatherService.getRealFeelTemperature(city, dateTime);
    }
    public String getCondition(@RequestParam String city,
                               @RequestParam @DateTimeFormat(pattern = "yyyyMMddHH") LocalDateTime dateTime) {
        return weatherService.getCondition(city, dateTime);
    }
    public int getCloudCover(@RequestParam String city,
                             @RequestParam @DateTimeFormat(pattern = "yyyyMMddHH") LocalDateTime dateTime) {
        return weatherService.getCloudCover(city, dateTime);
    }
    public int getChanceOfRain(@RequestParam String city,
                               @RequestParam @DateTimeFormat(pattern = "yyyyMMddHH") LocalDateTime dateTime) {
        return weatherService.getChanceOfRain(city, dateTime);
    }
    public int getChanceOfSnow(@RequestParam String city,
                               @RequestParam @DateTimeFormat(pattern = "yyyyMMddHH") LocalDateTime dateTime) {
        return weatherService.getChanceOfSnow(city, dateTime);
    }
    public double getRainPrecipitation(@RequestParam String city,
                                      @RequestParam @DateTimeFormat(pattern = "yyyyMMddHH") LocalDateTime dateTime) {
        return weatherService.getRainPrecipitation(city, dateTime);
    }
    public double getSnowPrecipitation(@RequestParam String city,
                                      @RequestParam @DateTimeFormat(pattern = "yyyyMMddHH") LocalDateTime dateTime) {
        return weatherService.getSnowPrecipitation(city, dateTime);
    }
    public int getHumidity(@RequestParam String city,
                           @RequestParam @DateTimeFormat(pattern = "yyyyMMddHH") LocalDateTime dateTime) {
        return weatherService.getHumidity(city, dateTime);
    }
    public double getPressure(@RequestParam String city,
                             @RequestParam @DateTimeFormat(pattern = "yyyyMMddHH") LocalDateTime dateTime) {
        return weatherService.getPressure(city, dateTime);
    }
    public double getVisibility(@RequestParam String city,
                               @RequestParam @DateTimeFormat(pattern = "yyyyMMddHH") LocalDateTime dateTime) {
        return weatherService.getVisibility(city, dateTime);
    }
    public double getUvIndex(@RequestParam String city,
                            @RequestParam @DateTimeFormat(pattern = "yyyyMMddHH") LocalDateTime dateTime) {
        return weatherService.getUvIndex(city, dateTime);
    }
}
