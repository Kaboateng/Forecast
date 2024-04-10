package com.weather.forecast;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

@Service
public class ForecastService {
    @Value("${weather.api.key}")
    private String apiKey;
    private final OkHttpClient client = new OkHttpClient();

    public String getCurrentForecast(String zipCode) throws Exception {
        String apiUrl = "http://api.weatherapi.com/v1/current.json?key=" + apiKey + "&q=" + zipCode + "&aqi=no";
        Request request = new Request.Builder().url(apiUrl).build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) throw new Exception("Unexpected code " + response);
            return response.body().string();
        }
    }
}
