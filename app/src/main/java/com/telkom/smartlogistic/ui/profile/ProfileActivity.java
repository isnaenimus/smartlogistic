package com.telkom.smartlogistic.ui.profile;

import android.os.Bundle;
import com.telkom.smartlogistic.base.BaseActivity;
import com.telkom.smartlogistic.R;

/**
 * Created by Isnaeni on 08/03/2021.
 */
public class ProfileActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public int getContentViewId() { return R.layout.activity_profile; }

    @Override
    public int getBottomNavigationMenuItemId() {
        return R.id.navigation_profile;
    }
}