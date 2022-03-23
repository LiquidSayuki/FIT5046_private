package com.liquid.tutorial4;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SharedViewModel extends ViewModel {
    private MutableLiveData<String> mText;

    public SharedViewModel() {
        mText = new MutableLiveData<>();
    }

    public void setMessage (String message) {
        mText.postValue(message);
    }
    public LiveData<String> getText () {
        return mText;
    }
}
