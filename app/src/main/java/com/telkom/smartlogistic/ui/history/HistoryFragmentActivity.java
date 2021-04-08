package com.telkom.smartlogistic.ui.history;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.telkom.smartlogistic.R;

public class HistoryFragmentActivity extends Fragment {
    // The onCreateView method is called when Fragment should create its View object hierarchy,
    // either dynamically or via XML layout inflation.
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        // Defines the xml file for the fragment
        View view = inflater.inflate(R.layout.fragment_history, parent, false);
        LinearLayout ll_riwayat_waiting = (LinearLayout) view.findViewById(R.id.ll_riwayat_waiting);
        ll_riwayat_waiting.setOnClickListener(v -> {
            FragmentTransaction ft = getChildFragmentManager().beginTransaction();
            ft.replace(R.id.screen_riwayat, new HistoryBayarFragmentActivity());
            ft.commit();
        });

        LinearLayout ll_riwayat_process = (LinearLayout) view.findViewById(R.id.ll_riwayat_process);
        ll_riwayat_process.setOnClickListener(v -> {
            FragmentTransaction ft = getChildFragmentManager().beginTransaction();
            ft.replace(R.id.screen_riwayat, new HistoryProsesFragmentActivity());
            ft.commit();
        });

        LinearLayout ll_riwayat_sending = (LinearLayout) view.findViewById(R.id.ll_riwayat_sending);
        ll_riwayat_sending.setOnClickListener(v -> {
            FragmentTransaction ft = getChildFragmentManager().beginTransaction();
            ft.replace(R.id.screen_riwayat, new HistoryKirimFragmentActivity());
            ft.commit();
        });

        LinearLayout ll_riwayat_arrived = (LinearLayout) view.findViewById(R.id.ll_riwayat_arrived);
        ll_riwayat_arrived.setOnClickListener(v -> {
            FragmentTransaction ft = getChildFragmentManager().beginTransaction();
            ft.replace(R.id.screen_riwayat, new HistorySampaiFragmentActivity());
            ft.commit();
        });

        ll_riwayat_waiting.performClick();
        return view;
    }

    // This event is triggered soon after onCreateView().
    // Any view setup should occur here.  E.g., view lookups and attaching view listeners.
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        // Setup any handles to view objects here
        // EditText etFoo = (EditText) view.findViewById(R.id.etFoo);
    }
}