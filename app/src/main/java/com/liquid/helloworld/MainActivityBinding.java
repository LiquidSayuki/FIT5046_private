package com.liquid.helloworld;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.liquid.helloworld.databinding.ActivityMainBinding;

public class MainActivityBinding extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());

        View view = binding.getRoot();

        setContentView(view);

        binding.reverseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String builder  = new StringBuilder(binding.username.getText()).reverse().toString();
                binding.username.setText(builder);
            }
        });
    }
}
