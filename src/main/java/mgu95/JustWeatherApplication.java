package mgu95;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;

@SpringBootApplication
public class JustWeatherApplication {

    public static void main(String[] args) {
        File weatherApikey = new File("WeatherApiKey.txt");
        if (weatherApikey.exists()) {
            SpringApplication.run(JustWeatherApplication.class, args);
        } else {
            System.out.println("File \"WeatherApiKey.txt\" not found. Please create a file and try again.");
        }
    }
}
