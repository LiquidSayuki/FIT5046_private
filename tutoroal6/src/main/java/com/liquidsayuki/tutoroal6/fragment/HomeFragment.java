package com.liquidsayuki.tutoroal6.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.liquidsayuki.tutoroal6.databinding.HomeFragmentBinding;
import com.liquidsayuki.tutoroal6.viewmodel.SharedViewModel;

public class HomeFragment extends Fragment {
    private SharedViewModel model;
    private HomeFragmentBinding binding;

    public HomeFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the View for this fragment
        binding = HomeFragmentBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        return view;
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}
