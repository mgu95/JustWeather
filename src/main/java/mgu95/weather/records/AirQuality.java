package mgu95.weather.records;

import mgu95.weather.enums.AQI;

public record AirQuality(double co,
                         double no2,
                         double o3,
                         double so2,
                         double pm2_5,
                         double pm10,
                         AQI aqi) {

}
