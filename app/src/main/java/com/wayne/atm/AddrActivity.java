package com.wayne.atm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class AddrActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addr);
        Spinner sp_city = (Spinner) findViewById(R.id.sp_city);
        Spinner sp_area = (Spinner) findViewById(R.id.sp_area);
        String[] data1 = {"基隆市", "新北市", "台北市"};
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, data1);
        sp_city.setAdapter(adapter);


    }
}
