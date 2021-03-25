package com.telkom.smartlogistic.ui.otp;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class OtpViewModel extends ViewModel {
    private MutableLiveData<String> mText;

    public OtpViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Otp");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
