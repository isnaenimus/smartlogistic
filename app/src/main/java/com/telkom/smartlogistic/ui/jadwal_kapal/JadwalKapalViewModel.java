package com.telkom.smartlogistic.ui.jadwal_kapal;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * Created by Isnaeni on 08/03/2021.
 */
public class JadwalKapalViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public JadwalKapalViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is order fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}