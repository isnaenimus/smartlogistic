package com.telkom.smartlogistic.ui.order_detail;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * Created by Isnaeni on 08/03/2021.
 */
public class OrderDetailViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public OrderDetailViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is order fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}