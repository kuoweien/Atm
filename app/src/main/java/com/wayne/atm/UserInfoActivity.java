package com.wayne.atm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class UserInfoActivity extends AppCompatActivity {
    private static final String TAG = Ch8Activity.class.getSimpleName();
    private EditText edName;
    private EditText edPhone;
    private Spinner ages;
    private final static int REQUEST_ADDR = 106;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);
        ages = (Spinner) findViewById(R.id.ages);
   /*     ArrayList<String> data = new ArrayList<>();
        for (int i = 15; i <= 40; i++) {
            data.add(i + "");
        }*/
      /*  String[] data = getResources().getStringArray(R.array.ages);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, ages.setAdapter ());
        ages.setAdapter(adapter);*/

        edName = (EditText) findViewById(R.id.ed_name);
        edPhone = (EditText) findViewById(R.id.ed_phone);
        setContentView(R.layout.activity_user_info);
        String name = getSharedPreferences("User",MODE_PRIVATE)
                .getString("NAME","");
        String phone = getSharedPreferences("Phone",MODE_PRIVATE)
                .getString("PHONE","");
        edName.setText(name);
        edPhone.setText(phone);
    }

    public void Ok (View v){
    //    Button Ok = (Button) findViewById(R.id.b_ok);
        Log.d(TAG,"ok:" + ages.getSelectedItem().toString());
        int age = Integer.parseInt(ages.getSelectedItem().toString());
        String name = edName.getText().toString();
        String phone = edPhone.getText().toString();
        getIntent().putExtra("EXTRA_NAME", name);
        getIntent().putExtra("EXTRA_PHONE", phone);
        setResult(RESULT_OK,getIntent());
  //      Intent intent = new Intent(this, MainActivity.class);
        finish();

    }
    public void Addr(View v){
        Intent intent = new Intent(this, AddrActivity.class);
        startActivityForResult(intent,REQUEST_ADDR);
    }

}
