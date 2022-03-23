package com.liquid.helloworld;

import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.liquid.helloworld.databinding.ActivityMainBinding;

public class MainActivityBinding extends AppCompatActivity {
    private ActivityMainBinding activityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = activityMainBinding.getRoot();
        setContentView(view);

        activityMainBinding.reverseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String builder  = new StringBuilder(activityMainBinding.username.getText()).reverse().toString();
                activityMainBinding.username.setText(builder);
            }
        });

        activityMainBinding.clearBtn.setOnClickListener(v -> {
            activityMainBinding.username.setText("");
        });
    }
}
