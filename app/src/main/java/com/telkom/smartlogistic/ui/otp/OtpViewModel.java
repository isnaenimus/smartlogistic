package com.telkom.smartlogistic.ui.otp;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * Created by AasSuhendar on 25/03/2021.
 */
public class OtpViewModel extends ViewModel {
    private MutableLiveData<String> mTextAsignOTP;
    
    private static final String txtAsignOTP = "Masukkan kode OTP yang telah kami kirim ke Nomor HP ";

    public OtpViewModel() {
        mTextAsignOTP = new MutableLiveData<>();
        mTextAsignOTP.setValue(txtAsignOTP);
    }

    public LiveData<String> getText() {
        return mTextAsignOTP;
    }


}
