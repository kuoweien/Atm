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
        Spinner spinner = (Spinner) findViewById(R.id.spinner_taipei);
        String[] data1 = {"中正區", "暖暖區", "八堵區"};
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, data1);
        spinner.setAdapter(adapter);

        Spinner spinner2 = (Spinner) findViewById(R.id.spinner_xei);
        String[] data2 = {"永和區", "板橋區", "新莊區"};
        ArrayAdapter adapter2 = new ArrayAdapter(this, android.R.layout.simple_list_item_1, data2);
        spinner.setAdapter(adapter);
    }
}
