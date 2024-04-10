package com.weather.forecast;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = {"http://localhost:4201/"})

@RestController
public class ForecastController {
    @Autowired
    private final ForecastService forecastService = new ForecastService();

    @GetMapping("/weather")
    public String getForecast(@RequestParam String zipCode){
        try {
            return forecastService.getCurrentForecast(zipCode);
        } catch (Exception e) {
            e.printStackTrace();
            return "Error getting weather data";
        }
    }
}
