package com.liquidsayuki.tutoroal6.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.liquidsayuki.tutoroal6.databinding.AddFragmentBinding;
import com.liquidsayuki.tutoroal6.viewmodel.SharedViewModel;

public class AddFragment extends Fragment {
    private AddFragmentBinding binding;

    public AddFragment (){}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding  = AddFragmentBinding.inflate(inflater,container,false);
        View view = binding.getRoot();

        SharedViewModel model = new ViewModelProvider(getActivity()).get(SharedViewModel.class);

        binding.addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message = binding.editText.getText().toString();
                if (!message.isEmpty()){
                    model.setMessage(message);
                }
            }
        });

        binding.clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.editText.setText("");
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
