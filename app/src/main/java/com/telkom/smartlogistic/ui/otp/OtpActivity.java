package com.telkom.smartlogistic.ui.otp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.telkom.smartlogistic.R;
import com.telkom.smartlogistic.ui.dashboard.DashboardActivity;

public class OtpActivity extends AppCompatActivity {

    Button btnSendOtp;
    TextView tvResendOtp;

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

    }

    private void setVariable() {
        btnSendOtp = findViewById(R.id.btn_otp);
        tvResendOtp = findViewById(R.id.tv_link_resend);
    }
}