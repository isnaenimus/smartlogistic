package com.telkom.smartlogistic.ui.order;

import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.telkom.smartlogistic.base.BaseActivity;
import com.telkom.smartlogistic.R;
import com.telkom.smartlogistic.models.PortModel;
import com.telkom.smartlogistic.ui.dashboard.DashboardViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Isnaeni on 08/03/2021.
 */
public class OrderActivity extends BaseActivity implements ActionBar.TabListener {
    private ViewPager viewPager;
    private OrderTabsAdapter orderTabsAdapter;
    private ActionBar actionBar;
    private String[] tabs = {"Pencarian baru", "Pencarian tersimpan"};
    private OrderViewModel orderViewModel;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        orderViewModel = new ViewModelProvider(this).get(OrderViewModel.class);
        orderViewModel.getText().observe(this, text -> {
            textView.setText(text);
        });

        setVariable();
        //        viewPager = findViewById(R.id.order_tabs);
//        actionBar = getActionBar();
//        orderTabsAdapter = new OrderTabsAdapter(getSupportFragmentManager());
//
//        viewPager.setAdapter(orderTabsAdapter);
//        actionBar.setHomeButtonEnabled(false);
//        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
//
//        for (String tabName : tabs) {
//            actionBar.addTab(actionBar.newTab().setText(tabName).setTabListener(this));
//        }
//
//        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//            @Override
//            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//                actionBar.setSelectedNavigationItem(position);
//            }
//
//            @Override
//            public void onPageSelected(int position) {
//
//            }
//
//            @Override
//            public void onPageScrollStateChanged(int state) {
//
//            }
//        });
    }

    private void setVariable() {
        textView = findViewById(R.id.text_dashboard);
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_order;
    }

    @Override
    public int getBottomNavigationMenuItemId() {
        return R.id.navigation_order;
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
        viewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }
}


