package com.liquidsayuki.tutoroal6.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SharedViewModel extends ViewModel {
    MutableLiveData<String> mText;

    public SharedViewModel(){
        mText = new MutableLiveData<String>();
    }

    public void setMessage(String message){
        mText.setValue(message);
    }

    public LiveData<String> getText(){
        return mText;
    }
}
