package com.liquid.tutorial3;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.liquid.tutorial3.databinding.ActivitySecondBinding;

public class SecondActivity extends AppCompatActivity {
    private ActivitySecondBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySecondBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

//        binding.startButton.setOnClickListener(v -> {
//            //Intent intent = new Intent(SecondActivity.this,MainActivity.class);
//            //    startActivity(intent);
//            Intent returnIntent = getIntent();
//            String message = binding.editText.getText().toString();
//            returnIntent.putExtra("megBack",message);
//            setResult(RESULT_OK,returnIntent);
//            finish();
//        });

        binding.messageButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Bundle bundle = getIntent().getExtras();
                Student aStudent = bundle.getParcelable("stu_obj_1");
                String name = aStudent.getName();
                int id = aStudent.getId();
                binding.textView.setText(id + " " + name);
            }
        });
        binding.startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}