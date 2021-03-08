package com.telkom.smartlogistic.ui.dashboard;

import android.os.Bundle;
import android.widget.TextView;

import androidx.lifecycle.ViewModelProvider;
import com.telkom.smartlogistic.base.BaseActivity;
import com.telkom.smartlogistic.R;

/**
 * Created by Isnaeni on 08/03/2021.
 */
public class DashboardActivity extends BaseActivity {

    private DashboardViewModel dashboardViewModel;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        dashboardViewModel = new ViewModelProvider(this).get(DashboardViewModel.class);
        dashboardViewModel.getText().observe(this, text -> {
            textView.setText(text);
        });

        setVariable();
    }

    private void setVariable() {
        textView = findViewById(R.id.text_dashboard);
    }

    @Override
    public int getContentViewId() { return R.layout.activity_dashboard; }

    @Override
    public int getBottomNavigationMenuItemId() { return R.id.navigation_dashboard; }
}
