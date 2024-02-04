package mgu95.weather.components;

import java.time.LocalDateTime;

public class Forecast {

    private LocalDateTime updateDateTime;
    private String city;
    private String country;
    private Day[] days;

    public Forecast(String city, String country, Day[] days) {
        updateDateTime = LocalDateTime.now();
        this.city = city;
        this.country = country;
        this.days = days;
    }

    public LocalDateTime getUpdateDateTime() {
        return updateDateTime;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public Day[] getDays() {
        return days;
    }
}
