package com.liquid.tutorial4;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.liquid.tutorial4.databinding.AddFragmentBinding;

import org.jetbrains.annotations.NotNull;

public class AddFragment extends Fragment {
    private AddFragmentBinding addBinding;

    public AddFragment(){}

    @Nullable
    @Override
    public View onCreateView (@NotNull LayoutInflater inflater,
                              @Nullable ViewGroup container,
                              @Nullable Bundle savedInstanceState){
        // Inflate the View for this fragment
        addBinding = AddFragmentBinding.inflate(inflater,container,false);
        View view = addBinding.getRoot();

        SharedViewModel model = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);

        addBinding.addButton.setOnClickListener(v -> {
            String message = addBinding.editText.getText().toString();
            if (!message.isEmpty()){
//                SharedPreferences sharedPref = requireActivity().
//                        getSharedPreferences("Message", 0);
//                SharedPreferences.Editor spEditor = sharedPref.edit();
//                spEditor.putString("message",message);
//                spEditor.apply();

                model.setMessage(message);
            }
        });

        addBinding.clearButton.setOnClickListener(v -> {
            addBinding.editText.setText("");
        });
        return view;


    }

        @Override
        public void onDestroyView() {
            super.onDestroyView();
            addBinding = null;
    }
}
