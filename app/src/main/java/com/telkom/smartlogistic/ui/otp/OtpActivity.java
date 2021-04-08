package com.telkom.smartlogistic.ui.otp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.telkom.smartlogistic.R;
import com.telkom.smartlogistic.ui.dashboard.DashboardActivity;

/**
 * Created by AasSuhendar on 25/03/2021.
 */
public class OtpActivity extends AppCompatActivity {

    private int counter=60;
    private Button btnSendOtp;
    private TextView tvResendOtp, tvCountDown, tvAsignOTP;
    private OtpViewModel otpViewModel;
    private CoordinatorLayout clSnackbar;
    private static Snackbar snackbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);

        setVariable();

        otpViewModel = new ViewModelProvider(this).get(OtpViewModel.class);
        otpViewModel.getText().observe(this, text -> {
            String phone = getIntent().getExtras().getString("PHONE_NUMBER");
            String txtAsignOTP = text+phone;
            tvAsignOTP.setText(txtAsignOTP);
        });

        btnSendOtp.setOnClickListener(v -> {
            Intent dashboard = new Intent(getApplicationContext(), DashboardActivity.class);
            startActivity(dashboard);
        });

        tvResendOtp.setOnClickListener(v -> {
            clSnackbar.bringToFront();
            snackbar.make(clSnackbar,"Kode OTP sudah dikirim kembali",Snackbar.LENGTH_LONG).setAction("", null).show();
        });

        new CountDownTimer(60000,1000){

            @Override
            public void onTick(long millisUntilFinished) {
                tvCountDown.setText(String.valueOf(counter));
                counter--;
            }

            @Override
            public void onFinish() {
                tvCountDown.setText("00");
            }
        }.start();


    }

    private void setVariable() {
        btnSendOtp = findViewById(R.id.btn_otp);
        tvResendOtp = findViewById(R.id.tv_link_resend);
        tvCountDown = findViewById(R.id.tv_countdown);
        tvAsignOTP = findViewById(R.id.tv_asign_otp);
        clSnackbar =  findViewById(R.id.snackbar_layout);
    }
}