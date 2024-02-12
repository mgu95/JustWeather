package mgu95.contollers;

import mgu95.services.WeatherService;
import mgu95.weather.Weather;
import mgu95.weather.records.AirQuality;
import mgu95.weather.records.Alert;
import mgu95.weather.records.Astronomy;
import mgu95.weather.records.Wind;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/weather")
public class WeatherRestController implements Weather {

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

//    @GetMapping("/conflict")
//    @ResponseStatus(code = HttpStatus.CONFLICT, reason = "Incorrect date")
//    public String conflict() {
//        return "";
//    }

    @GetMapping("/airQuality")
    public AirQuality getAirQuality(@RequestParam String city,
                                    @RequestParam @DateTimeFormat(pattern = "yyyyMMddHH") LocalDateTime dateTime) {
        return weatherService.getAirQuality(city, dateTime);
    }

    @GetMapping("/alert")
    public Alert getAlert(@RequestParam String city,
                          @RequestParam @DateTimeFormat(pattern = "yyyyMMdd") LocalDate date) {
        return weatherService.getAlert(city, date);
    }

    @GetMapping("/astronomy")
    public Astronomy getAstronomy(@RequestParam String city,
                                  @RequestParam @DateTimeFormat(pattern = "yyyyMMdd") LocalDate date) {
        return weatherService.getAstronomy(city, date);
    }

    @GetMapping("/wind")
    public Wind getWind(@RequestParam String city,
                        @RequestParam @DateTimeFormat(pattern = "yyyyMMddHH") LocalDateTime dateTime) {
        return weatherService.getWind(city, dateTime);
    }

    @GetMapping("/maxWindSpeed")
    public double getMaxWindSpeed(@RequestParam String city,
                                  @RequestParam @DateTimeFormat(pattern = "yyyyMMdd") LocalDate date) {
        return weatherService.getMaxWindSpeed(city, date);
    }

    @GetMapping("/temperature")
    public double getTemperature(@RequestParam String city,
                                @RequestParam @DateTimeFormat(pattern = "yyyyMMddHH") LocalDateTime dateTime) {
        return weatherService.getTemperature(city, dateTime);
    }

    @GetMapping("/realFeelTemperature")
    public double getRealFeelTemperature(@RequestParam String city,
                                        @RequestParam @DateTimeFormat(pattern = "yyyyMMddHH") LocalDateTime dateTime) {
        return weatherService.getRealFeelTemperature(city, dateTime);
    }

    @GetMapping("/maxTemperature")
    public double getMaxTemperature(@RequestParam String city,
                                    @RequestParam @DateTimeFormat(pattern = "yyyyMMdd") LocalDate date) {
        return weatherService.getMaxTemperature(city, date);
    }

    @GetMapping("/minTemperature")
    public double getMinTemperature(@RequestParam String city,
                                    @RequestParam @DateTimeFormat(pattern = "yyyyMMdd") LocalDate date) {
        return weatherService.getMinTemperature(city, date);
    }

    @GetMapping("/averageTemperature")
    public double getAverageTemperature(@RequestParam String city,
                                        @RequestParam @DateTimeFormat(pattern = "yyyyMMdd") LocalDate date) {
        return weatherService.getAverageTemperature(city, date);
    }

    @GetMapping("/condition")
    public String getCondition(@RequestParam String city,
                               @RequestParam @DateTimeFormat(pattern = "yyyyMMddHH") LocalDateTime dateTime) {
        return weatherService.getCondition(city, dateTime);
    }

    @GetMapping("/averageCondition")
    public String getAverageCondition(@RequestParam String city,
                                      @RequestParam @DateTimeFormat(pattern = "yyyyMMdd") LocalDate date) {
        return weatherService.getAverageCondition(city, date);
    }

    @GetMapping("/cloudCover")
    public int getCloudCover(@RequestParam String city,
                             @RequestParam @DateTimeFormat(pattern = "yyyyMMddHH") LocalDateTime dateTime) {
        return weatherService.getCloudCover(city, dateTime);
    }

    @GetMapping("/chanceOfRain")
    public int getChanceOfRain(@RequestParam String city,
                               @RequestParam @DateTimeFormat(pattern = "yyyyMMddHH") LocalDateTime dateTime) {
        return weatherService.getChanceOfRain(city, dateTime);
    }

    @GetMapping("/dailyChanceOfRain")
    public double getDailyChanceOfRain(@RequestParam String city,
                                       @RequestParam @DateTimeFormat(pattern = "yyyyMMdd") LocalDate date) {
        return weatherService.getDailyChanceOfRain(city, date);
    }

    @GetMapping("/chanceOfSnow")
    public int getChanceOfSnow(@RequestParam String city,
                               @RequestParam @DateTimeFormat(pattern = "yyyyMMddHH") LocalDateTime dateTime) {
        return weatherService.getChanceOfSnow(city, dateTime);
    }

    @GetMapping("/dailyChanceOfSnow")
    public double getDailyChanceOfSnow(@RequestParam String city,
                                       @RequestParam @DateTimeFormat(pattern = "yyyyMMdd") LocalDate date) {
        return weatherService.getDailyChanceOfSnow(city, date);
    }

    @GetMapping("/rainPrecipitation")
    public double getRainPrecipitation(@RequestParam String city,
                                      @RequestParam @DateTimeFormat(pattern = "yyyyMMddHH") LocalDateTime dateTime) {
        return weatherService.getRainPrecipitation(city, dateTime);
    }

    @GetMapping("/totalRainPrecipitation")
    public double getTotalRainPrecipitation(@RequestParam String city,
                                            @RequestParam @DateTimeFormat(pattern = "yyyyMMdd") LocalDate date) {
        return weatherService.getTotalRainPrecipitation(city, date);
    }

    @GetMapping("/snowPrecipitation")
    public double getSnowPrecipitation(@RequestParam String city,
                                      @RequestParam @DateTimeFormat(pattern = "yyyyMMddHH") LocalDateTime dateTime) {
        return weatherService.getSnowPrecipitation(city, dateTime);
    }

    @GetMapping("/totalSnowPrecipitation")
    public double getTotalSnowPrecipitation(@RequestParam String city,
                                            @RequestParam @DateTimeFormat(pattern = "yyyyMMdd") LocalDate date) {
        return weatherService.getTotalSnowPrecipitation(city, date);
    }

    @GetMapping("/humidity")
    public int getHumidity(@RequestParam String city,
                           @RequestParam @DateTimeFormat(pattern = "yyyyMMddHH") LocalDateTime dateTime) {
        return weatherService.getHumidity(city, dateTime);
    }

    @GetMapping("/averageHumidity")
    public double getAverageHumidity(@RequestParam String city,
                                     @RequestParam @DateTimeFormat(pattern = "yyyyMMdd") LocalDate date) {
        return weatherService.getAverageHumidity(city, date);
    }

    @GetMapping("/pressure")
    public double getPressure(@RequestParam String city,
                             @RequestParam @DateTimeFormat(pattern = "yyyyMMddHH") LocalDateTime dateTime) {
        return weatherService.getPressure(city, dateTime);
    }

    @GetMapping("/visibility")
    public double getVisibility(@RequestParam String city,
                               @RequestParam @DateTimeFormat(pattern = "yyyyMMddHH") LocalDateTime dateTime) {
        return weatherService.getVisibility(city, dateTime);
    }

    @GetMapping("/averageVisibility")
    public double getAverageVisibility(@RequestParam String city,
                                       @RequestParam @DateTimeFormat(pattern = "yyyyMMdd") LocalDate date) {
        return weatherService.getAverageVisibility(city, date);
    }

    @GetMapping("/uvIndex")
    public double getUvIndex(@RequestParam String city,
                            @RequestParam @DateTimeFormat(pattern = "yyyyMMddHH") LocalDateTime dateTime) {
        return weatherService.getUvIndex(city, dateTime);
    }
}
