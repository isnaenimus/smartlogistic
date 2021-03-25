package com.telkom.smartlogistic.ui.login;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * Created by AasSuhendar on 24/03/2021.
 */
public class LoginViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public LoginViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Login");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
