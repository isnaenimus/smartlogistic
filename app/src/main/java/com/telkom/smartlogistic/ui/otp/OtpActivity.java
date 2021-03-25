package com.telkom.smartlogistic.ui.otp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.telkom.smartlogistic.R;
import com.telkom.smartlogistic.ui.dashboard.DashboardActivity;

/**
 * Created by AasSuhendar on 24/03/2021.
 */
public class OtpActivity extends AppCompatActivity {

    private int counter=60;
    private Button btnSendOtp;
    private TextView tvResendOtp, tvCountDown;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);

        setVariable();

        btnSendOtp.setOnClickListener(v -> {
            Intent dashboard = new Intent(getApplicationContext(), DashboardActivity.class);
            startActivity(dashboard);
        });

        tvResendOtp.setOnClickListener(v -> {
            Toast.makeText(getApplicationContext(),"Resend OTP", Toast.LENGTH_LONG).show();
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
    }
}