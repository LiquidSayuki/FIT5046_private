package com.liquid.tutorial4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

import com.liquid.tutorial4.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.addButton.setOnClickListener(v -> {
            replaceFragment(R.id.fragment_container_view,new AddFragment());
        });

        binding.viewButton.setOnClickListener(v -> {
            replaceFragment(R.id.fragment_container_view,new ViewFragment());
        });


    }

    private void replaceFragment(int viewId, Fragment nextFragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(viewId,nextFragment);
        fragmentTransaction.commit();
    }
}