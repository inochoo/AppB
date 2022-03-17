package com.sibaamap.appb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tv_name, tv_address, tv_phone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().setStatusBarColor(getColor(R.color.yellow));
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);

        tv_name = findViewById(R.id.tv_name);
        tv_address = findViewById(R.id.tv_address);
        tv_phone = findViewById(R.id.tv_phone);

        BroadcastReceiver receiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                String valueName = intent.getStringExtra("valueName");//lấy dữ liều truyền
                String valueAdd = intent.getStringExtra("valueAdd");
                String valuePhone = intent.getStringExtra("valuePhone");


                tv_name.setText(valueName);
                tv_address.setText(valueAdd);
                tv_phone.setText(valuePhone);
            }
        };

        IntentFilter screenStateFilter = new IntentFilter();
        screenStateFilter.addAction("test");
        registerReceiver(receiver, screenStateFilter);


    }
}