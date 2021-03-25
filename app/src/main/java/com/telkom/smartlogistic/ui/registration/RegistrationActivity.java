package com.telkom.smartlogistic.ui.registration;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.telkom.smartlogistic.R;
import com.telkom.smartlogistic.base.BaseActivity;
import com.telkom.smartlogistic.ui.login.LoginActivity;

/**
 * Created by AasSuhendar on 24/03/2021.
 */
public class RegistrationActivity extends AppCompatActivity {

    TextView tvLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        setVariable();

        tvLogin.setOnClickListener(v -> {
            Intent login = new Intent(getApplicationContext(), LoginActivity.class);
            startActivity(login);
        });
    }

    private void setVariable() {
        tvLogin = findViewById(R.id.tv_link_login);
    }

}