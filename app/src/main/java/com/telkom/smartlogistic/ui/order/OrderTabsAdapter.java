package com.telkom.smartlogistic.ui.order;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.telkom.smartlogistic.ui.order.fragments.NewSearchFragment;
import com.telkom.smartlogistic.ui.order.fragments.SavedSearchFragment;

public class OrderTabsAdapter extends FragmentStatePagerAdapter {

    public OrderTabsAdapter(FragmentManager supportFragmentManager) {
        super(supportFragmentManager);
    }

    @Override
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return new NewSearchFragment();
            case 1:
                return new SavedSearchFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return "OBJECT " + (position + 1);
    }
}
