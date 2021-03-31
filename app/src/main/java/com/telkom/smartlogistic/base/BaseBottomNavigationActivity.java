package com.telkom.smartlogistic.base;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import androidx.annotation.NonNull;

/**
 * Created by Isnaeni on 08/03/2021.
 */
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.telkom.smartlogistic.R;
import com.telkom.smartlogistic.framework.core.base.BaseActivity;
import com.telkom.smartlogistic.ui.dashboard.DashboardActivity;
import com.telkom.smartlogistic.ui.history.HistoryActivity;
import com.telkom.smartlogistic.ui.order.OrderActivity;
import com.telkom.smartlogistic.ui.profile.ProfileActivity;

/**
 * Created by Isnaeni on 08/03/2021.
 */
public abstract class BaseBottomNavigationActivity extends BaseActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    protected BottomNavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(getViewLayoutResId());

        navigationView = findViewById(R.id.navigation);
        navigationView.setOnNavigationItemSelectedListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        updateNavigationBarState();
    }

    // Remove inter-activity transition to avoid screen tossing on tapping bottom navigation items
    @Override
    public void onPause() {
        super.onPause();
        overridePendingTransition(0, 0);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        navigationView.postDelayed(() -> {
            int itemId = item.getItemId();
            if (itemId == R.id.navigation_dashboard) {
                startActivity(new Intent(this, DashboardActivity.class));
            } else if (itemId == R.id.navigation_order) {
                startActivity(new Intent(this, OrderActivity.class));
            } else if (itemId == R.id.navigation_history) {
                startActivity(new Intent(this, HistoryActivity.class));
            } else if (itemId == R.id.navigation_profile) {
                startActivity(new Intent(this, ProfileActivity.class));
            }
            finish();
        }, 300);
        return true;
    }

    private void updateNavigationBarState() {
        int actionId = getBottomNavigationMenuItemId();
        selectBottomNavigationBarItem(actionId);
    }

    void selectBottomNavigationBarItem(int itemId) {
        MenuItem item = navigationView.getMenu().findItem(itemId);
        item.setChecked(true);
    }

    //public abstract int getContentViewId();

    public abstract int getBottomNavigationMenuItemId();
}
