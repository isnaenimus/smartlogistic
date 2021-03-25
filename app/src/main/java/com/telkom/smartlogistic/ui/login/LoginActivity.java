package com.telkom.smartlogistic.ui.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.telkom.smartlogistic.R;
import com.telkom.smartlogistic.ui.otp.OtpActivity;
import com.telkom.smartlogistic.ui.registration.RegistrationActivity;

/**
 * Created by AasSuhendar on 24/03/2021.
 */
public class LoginActivity extends AppCompatActivity {

    private TextView tvRegister;
    private Button btnLogin;
    private TextInputEditText txtPhoneNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        setVariable();

        tvRegister.setOnClickListener(v -> {
            Intent registration = new Intent(getApplicationContext(), RegistrationActivity.class);
            startActivity(registration);
        });

        btnLogin.setOnClickListener(v -> {
            Intent otp = new Intent(getApplicationContext(), OtpActivity.class);
            otp.putExtra("PHONE_NUMBER",txtPhoneNumber.getText().toString().trim());
            startActivity(otp);
        });
    }

    private void setVariable() {
        tvRegister = findViewById(R.id.tv_link_register);
        btnLogin = findViewById(R.id.btn_login);
        txtPhoneNumber = findViewById(R.id.input_phone_login);
    }
}