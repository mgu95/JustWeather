package mgu95.weather.records;

import mgu95.weather.enums.MoonPhase;

import java.time.LocalTime;

public record Astronomy(LocalTime sunrise,
                        LocalTime sunset,
                        LocalTime moonrise,
                        LocalTime moonset,
                        MoonPhase moonphase,
                        int moonIllumination) {

}
