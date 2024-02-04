package mgu95.weather;

import mgu95.weather.components.Forecast;

public interface Weather {

    public Forecast getForecast(); // może lepiej rozbić to na metody?
}
