package com.liquid.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button reverseButton = findViewById(R.id.reverse_btn);
        reverseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editText = findViewById(R.id.username);
                String builder  = new StringBuilder(editText.getText()).reverse().toString();
                editText.setText(builder);
            }
        });

        Button clearButton = findViewById(R.id.clear_btn);
        clearButton.setOnClickListener(lambda01 -> {
            EditText editText = findViewById(R.id.username);
            editText.setText("");
        });

    }


}