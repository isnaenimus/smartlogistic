package com.telkom.smartlogistic.ui.history;

import android.os.Bundle;
import com.telkom.smartlogistic.base.BaseActivity;
import com.telkom.smartlogistic.R;

/**
 * Created by Isnaeni on 08/03/2021.
 */
public class HistoryActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_history);
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_history;
    }

    @Override
    public int getBottomNavigationMenuItemId() {
        return R.id.navigation_history;
    }
}