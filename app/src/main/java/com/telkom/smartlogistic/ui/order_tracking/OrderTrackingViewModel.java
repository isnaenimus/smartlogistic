package com.telkom.smartlogistic.ui.order_tracking;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * Created by Isnaeni on 08/03/2021.
 */
public class OrderTrackingViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public OrderTrackingViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is order fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}