package com.telkom.smartlogistic.ui.order_detail;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.telkom.smartlogistic.R;
import com.telkom.smartlogistic.ui.order_tracking.OrderTrackingActivity;

/**
 * Created by Isnaeni on 08/03/2021.
 */
public class OrderDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_detail);

        TextView order_tracking_btn = (TextView) findViewById(R.id.tracking_order_btn);
        order_tracking_btn.setOnClickListener(v -> {
            Intent intent = new Intent(this, OrderTrackingActivity.class);
            startActivity(intent);
        });
    }
}