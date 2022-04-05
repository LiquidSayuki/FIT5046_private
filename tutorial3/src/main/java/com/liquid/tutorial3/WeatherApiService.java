package com.liquid.tutorial3;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface WeatherApiService {
    //https://api.openweathermap.org/data/2.5/weather?lat={lat}&lon={lon}&appid={API key}
    @GET("weather")
    Call<Root> getWeather(@Query("lat") double lat, @Query("lon") double lon, @Query("appid") String apiKey);
}
