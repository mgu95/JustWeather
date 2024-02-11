package mgu95.weather;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import mgu95.weather.enums.AQI;
import mgu95.weather.enums.MoonPhase;
import mgu95.weather.records.*;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class WeatherAPI implements Weather{

    private final String key;
    private LocalDateTime lastUpdateTime;
    private Forecast forecast;

    public WeatherAPI() {
        try {
            Scanner myReader = new Scanner(new File("WeatherApiKey.txt"));
            key = myReader.nextLine();
            myReader.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public AirQuality getAirQuality(String city, LocalDateTime dateTime) {
        validator(city);
        Day[] days = forecast.days();
        for (Day day : days) {
            if (day.date().isEqual(dateTime.toLocalDate())) {
                Hour[] hours = day.hours();
                for (Hour hour : hours) {
                    if (hour.time().equals(dateTime.toLocalTime())) {
                        return hour.airQuality();
                    }
                }
            }
        }
        return null;
    }

    @Override
    public Alert getAlert(String city, LocalDate date) {
        return null;
    }

    @Override
    public Astronomy getAstronomy(String city, LocalDate date) {
        return null;
    }

    @Override
    public Wind getWind(String city, LocalDateTime dateTime) {
        validator(city);
        System.out.println("key=" + key);
        boolean b = LocalDateTime.now().isAfter(forecast.updateDateTime().plusMinutes(15));
        //czy od ostatniej aktualizacji minęło 15min?
        System.out.println("b=" + b);
        return null;
    }

    @Override
    public double getTemperature(String city, LocalDateTime dateTime) {
        return 0;
    }

    @Override
    public double getRealFeelTemperature(String city, LocalDateTime dateTime) {
        return 0;
    }

    @Override
    public String getCondition(String city, LocalDateTime dateTime) {
        return null;
    }

    @Override
    public int getCloudCover(String city, LocalDateTime dateTime) {
        return 0;
    }

    @Override
    public int getChanceOfRain(String city, LocalDateTime dateTime) {
        return 0;
    }

    @Override
    public int getChanceOfSnow(String city, LocalDateTime dateTime) {
        return 0;
    }

    @Override
    public double getRainPrecipitation(String city, LocalDateTime dateTime) {
        return 0;
    }

    @Override
    public double getSnowPrecipitation(String city, LocalDateTime dateTime) {
        return 0;
    }

    @Override
    public int getHumidity(String city, LocalDateTime dateTime) {
        return 0;
    }

    @Override
    public double getPressure(String city, LocalDateTime dateTime) {
        return 0;
    }

    @Override
    public double getVisibility(String city, LocalDateTime dateTime) {
        return 0;
    }

    @Override
    public double getUvIndex(String city, LocalDateTime dateTime) {
        return 0;
    }

    private void validator(String city) {
        if (forecast == null || LocalDateTime.now().isAfter(forecast.updateDateTime().plusMinutes(15))) {
            String data = downloadData("http://api.weatherapi.com/v1/forecast.json?key=" + key + "&q=" + city
                    + "&days=3&aqi=yes&alerts=yes");
            try {
                ObjectMapper mapper = new ObjectMapper();
                JsonNode actualObj = mapper.readTree(data);

                JsonNode location = actualObj.get("location");
                String country = location.get("country").asText();

                JsonNode current = actualObj.get("current");
                String updateTime = current.get("last_updated").asText();
                String replacedTime = updateTime.replace(" ", "T");
                lastUpdateTime = LocalDateTime.parse(replacedTime);

                JsonNode forecastData = actualObj.get("forecast");
                JsonNode forecastDay = forecastData.get("forecastday");
                Day[] days = new Day[forecastDay.size()];
                for (int i = 0; i < days.length; i++) {
                    JsonNode dayJson = forecastDay.get(i);
                    JsonNode averageDay = dayJson.get("day");
                    JsonNode averageCondition = averageDay.get("condition");
                    JsonNode astro = dayJson.get("astro");
                    Astronomy astronomy = new Astronomy(
                            LocalTime.parse(astro.get("sunrise").asText(), DateTimeFormatter.ofPattern("hh:mm a", Locale.US)),
                            LocalTime.parse(astro.get("sunset").asText(), DateTimeFormatter.ofPattern("hh:mm a", Locale.US)),
                            LocalTime.parse(astro.get("moonrise").asText(), DateTimeFormatter.ofPattern("hh:mm a", Locale.US)),
                            LocalTime.parse(astro.get("moonset").asText(), DateTimeFormatter.ofPattern("hh:mm a", Locale.US)),
                            getMoonPhaseFromString(astro.get("moon_phase").asText()),
                            astro.get("moon_illumination").asInt());

                    JsonNode hoursJson = dayJson.get("hour");
                    Hour[] hours = new Hour[hoursJson.size()];
                    for (int j = 0; j < hours.length; j++) {
                        JsonNode hour = hoursJson.get(j);
                        JsonNode condition = hour.get("condition");
                        JsonNode air = hour.get("air_quality");
                        AirQuality airQuality = new AirQuality(
                                air.get("co").asDouble(),
                                air.get("no2").asDouble(),
                                air.get("o3").asDouble(),
                                air.get("so2").asDouble(),
                                air.get("pm2_5").asDouble(),
                                air.get("pm10").asDouble(),
                                getAqiFromIndex(air.get("us-epa-index").asInt()));
                        Wind wind = new Wind(
                                hour.get("wind_kph").asDouble(),
                                hour.get("wind_degree").asInt(),
                                hour.get("wind_dir").asText(),
                                hour.get("gust_kph").asDouble());

                        hours[j] = new Hour(
                                airQuality,
                                wind,
                                LocalTime.parse(hour.get("time").asText().substring(11)),
                                hour.get("temp_c").asDouble(),
                                hour.get("feelslike_c").asDouble(),
                                condition.get("text").asText(),
                                hour.get("cloud").asInt(),
                                hour.get("chance_of_rain").asInt(),
                                hour.get("chance_of_snow").asInt(),
                                hour.get("precip_mm").asDouble(),
                                hour.get("snow_cm").asDouble() * 10,
                                hour.get("humidity").asInt(),
                                hour.get("pressure_mb").asDouble(),
                                hour.get("vis_km").asDouble(),
                                hour.get("uv").asDouble());
                    }

                    days[i] = new Day(
                            LocalDate.parse(dayJson.get("date").asText()),
                            hours,
                            astronomy,
                            averageDay.get("maxtemp_c").asDouble(),
                            averageDay.get("mintemp_c").asDouble(),
                            averageDay.get("avgtemp_c").asDouble(),
                            averageDay.get("maxwind_kph").asDouble(),
                            averageDay.get("totalprecip_mm").asDouble(),
                            averageDay.get("totalsnow_cm").asDouble() * 10,
                            averageDay.get("avgvis_km").asDouble(),
                            averageDay.get("avghumidity").asInt(),
                            averageDay.get("daily_chance_of_rain").asInt(),
                            averageDay.get("daily_chance_of_snow").asInt(),
                            averageCondition.get("text").asText());
                }

                // To dodać jak będą alerty
                JsonNode alerts = actualObj.get("alerts");
                System.out.println(alerts.toString());

                forecast = new Forecast(lastUpdateTime, city, country, days);

            } catch (Exception e) {
                System.out.println("Something went wrong...");
            }
        }
    }

    private String downloadData(String address) {
        URL url = null;
        try {
            url = new URL(address);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        try (InputStream input = url.openStream()) {
            InputStreamReader isr = new InputStreamReader(input);
            BufferedReader reader = new BufferedReader(isr);
            StringBuilder data = new StringBuilder();
            int c;
            while ((c = reader.read()) != -1) {
                data.append((char) c);
            }
            return data.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private MoonPhase getMoonPhaseFromString(String moonPhase) {
        return switch (moonPhase) {
            case "New Moon" -> MoonPhase.NEW_MOON;
            case "Waxing Crescent" -> MoonPhase.WAXING_CRESCENT;
            case "First Quarter" -> MoonPhase.FIRST_QUARTER;
            case "Waxing Gibbous" -> MoonPhase.WAXING_GIBBOUS;
            case "Full Moon" -> MoonPhase.FULL_MOON;
            case "Waning Gibbous" -> MoonPhase.WANING_GIBBOUS;
            case "Last Quarter" -> MoonPhase.LAST_QUARTER;
            case "Waning Crescent" -> MoonPhase.WANING_CRESCENT;
            default -> null;
        };
    }

    private AQI getAqiFromIndex(int index) {
        return switch (index) {
            case 1 -> AQI.GOOD;
            case 2 -> AQI.MODERATE;
            case 3 -> AQI.UNHEALTHY_FOR_SENSITIVE_GROUP;
            case 4 -> AQI.UNHEALTHY;
            case 5 -> AQI.VERY_UNHEALTHY;
            case 6 -> AQI.HAZARDOUS;
            default -> null;
        };
    }
}
