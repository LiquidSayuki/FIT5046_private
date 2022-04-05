package com.liquid.tutorial3;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.liquid.tutorial3.databinding.ActivityWeatherBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WeatherActivity extends AppCompatActivity {
    ActivityWeatherBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityWeatherBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        //Create a retrofit object
        //https://api.openweathermap.org/data/2.5/weather?lat={lat}&lon={lon}&appid={API key}
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.openweathermap.org/data/2.5/")
                .addConverterFactory(GsonConverterFactory.create()) //Declare the api we call would return json object
                .build();

        WeatherApiService service = retrofit.create(WeatherApiService.class);

        //Ready to call and get a Root object
        Call<Root> weather = service.getWeather(-37.813,144.963,"7262ebce72fd75b2ebaaa56a5c686667");


        weather.enqueue(new Callback<Root>() {
            @Override
            public void onResponse(Call<Root> call, Response<Root> response) {
                Root root = response.body();
                double temp = root.getMain().getTemp();
                binding.textTemp.setText(String.valueOf((int)temp));
            }

            @Override
            public void onFailure(Call<Root> call, Throwable t) {
                System.out.println(t.getMessage());
            }
        });

    }
}
