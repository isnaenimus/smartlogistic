package com.telkom.smartlogistic.ui.registration;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * Created by AasSuhendar on 24/03/2021.
 */
public class RegistrationViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public RegistrationViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Registration");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
