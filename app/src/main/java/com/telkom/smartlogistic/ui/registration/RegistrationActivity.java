package com.telkom.smartlogistic.ui.registration;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import com.telkom.smartlogistic.R;
import com.telkom.smartlogistic.ui.login.LoginActivity;
import com.telkom.smartlogistic.ui.otp.OtpActivity;

/**
 * Created by AasSuhendar on 24/03/2021.
 */
public class RegistrationActivity extends AppCompatActivity {

    private TextView tvLogin;
    private Button btnRegister;
    private TextInputEditText txtFullName, txtEmail, txtPhoneNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        setVariable();

        tvLogin.setOnClickListener(v -> {
            Intent login = new Intent(getApplicationContext(), LoginActivity.class);
            startActivity(login);
        });

        btnRegister.setOnClickListener(v -> {
            String phoneText = txtPhoneNumber.getText().toString().trim();
            String emailText = txtEmail.getText().toString().trim();
            String fullNameText = txtFullName.getText().toString().trim();

            if (phoneText.isEmpty()) {
                txtPhoneNumber.setError("Nomor HP tidak boleh kosong");
                txtPhoneNumber.requestFocus();
                return;
            }

            if (phoneText.length() < 11){
                txtPhoneNumber.setError("Nomor HP tidak valid");
                txtPhoneNumber.requestFocus();
                return;
            }

            if (fullNameText.isEmpty()) {
                txtFullName.setError("Nama Lengkap tidak boleh kosong");
                txtFullName.requestFocus();
                return;
            }

            if (emailText.isEmpty()) {
                txtEmail.setError("Email tidak boleh kosong");
                txtEmail.requestFocus();
                return;
            }

            phoneText = "0"+phoneText;


            Intent otp = new Intent(getApplicationContext(), OtpActivity.class);
            otp.putExtra("PHONE_NUMBER",phoneText);
            startActivity(otp);
        });
    }

    private void setVariable() {
        tvLogin = findViewById(R.id.tv_link_login);
        btnRegister =  findViewById(R.id.btn_register);
        txtPhoneNumber = findViewById(R.id.input_phone_register);
        txtFullName = findViewById(R.id.input_fullname);
        txtEmail = findViewById(R.id.input_email);
    }

}