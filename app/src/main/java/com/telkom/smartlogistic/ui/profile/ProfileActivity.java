package com.telkom.smartlogistic.ui.profile;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.lifecycle.ViewModelProvider;
import com.telkom.smartlogistic.R;
import com.telkom.smartlogistic.base.BaseBottomNavigationActivity;
import com.telkom.smartlogistic.ui.login.LoginActivity;

/**
 * Created by Isnaeni on 08/03/2021.
 */
public class ProfileActivity extends BaseBottomNavigationActivity {

    private ProfileViewModel profileViewModel;
    TextView textView;
    Button btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        profileViewModel = new ViewModelProvider(this).get(ProfileViewModel.class);
        profileViewModel.getText().observe(this, text -> {
            textView.setText(text);
        });

        setVariable();

        btnLogout.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(), LoginActivity.class));
        });
    }

    private void setVariable() {
        textView = findViewById(R.id.text_profile);
        btnLogout =  findViewById(R.id.btn_logout);
    }

    @Override
    public int getViewLayoutResId() { return R.layout.activity_profile; }

    @Override
    public int getBottomNavigationMenuItemId() {
        return R.id.navigation_profile;
    }
}