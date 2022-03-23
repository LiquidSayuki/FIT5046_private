package com.liquid.tutorial4;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.liquid.tutorial4.databinding.ViewFragmentBinding;

public class ViewFragment extends Fragment {
    private ViewFragmentBinding binding;

    public ViewFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflate the View for this fragment using the binding
        binding = ViewFragmentBinding.inflate(inflater,container,false);
        View view = binding.getRoot();

//        SharedPreferences sharedPref = requireActivity().
//                getSharedPreferences("Message",0);
//        String message = sharedPref.getString("message",null);
//        binding.textMessage.setText("Message from Add fragment: " + message);

        SharedViewModel model = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);
        model.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                binding.textMessage.setText(s);
            }
        });

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
