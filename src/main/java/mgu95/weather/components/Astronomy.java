package mgu95.weather.components;

import mgu95.weather.enums.MoonPhase;

import java.time.LocalTime;

public class Astronomy {
    private LocalTime sunrise;
    private LocalTime sunset;
    private LocalTime moonrise;
    private LocalTime moonset;
    private MoonPhase moonphase;
    private int moonIllumination;

    public Astronomy(LocalTime sunrise, LocalTime sunset, LocalTime moonrise, LocalTime moonset, MoonPhase moonphase,
                     int moonIllumination) {
        this.sunrise = sunrise;
        this.sunset = sunset;
        this.moonrise = moonrise;
        this.moonset = moonset;
        this.moonphase = moonphase;
        this.moonIllumination = moonIllumination;
    }

    public LocalTime getSunrise() {
        return sunrise;
    }

    public LocalTime getSunset() {
        return sunset;
    }

    public LocalTime getMoonrise() {
        return moonrise;
    }

    public LocalTime getMoonset() {
        return moonset;
    }

    public MoonPhase getMoonphase() {
        return moonphase;
    }

    public int getMoonIllumination() {
        return moonIllumination;
    }
}
