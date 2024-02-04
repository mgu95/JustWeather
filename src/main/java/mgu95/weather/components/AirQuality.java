package mgu95.weather.components;

import mgu95.weather.enums.AQI;

public class AirQuality {

    private float co;
    private float no2;
    private float o3;
    private float so2;
    private float pm2_5;
    private float pm10;
    private AQI aqi;

    public AirQuality(float co, float no2, float o3, float so2, float pm2_5, float pm10, AQI aqi) {
        this.co = co;
        this.no2 = no2;
        this.o3 = o3;
        this.so2 = so2;
        this.pm2_5 = pm2_5;
        this.pm10 = pm10;
        this.aqi = aqi;
    }

    public float getCo() {
        return co;
    }

    public float getNo2() {
        return no2;
    }

    public float getO3() {
        return o3;
    }

    public float getSo2() {
        return so2;
    }

    public float getPm2_5() {
        return pm2_5;
    }

    public float getPm10() {
        return pm10;
    }

    public AQI getAqi() {
        return aqi;
    }
}
