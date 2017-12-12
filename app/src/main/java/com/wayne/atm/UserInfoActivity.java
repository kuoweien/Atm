package com.wayne.atm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class UserInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);
    }



    public void Ok (View v){
        EditText edName = (EditText) findViewById(R.id.ed_name);
        EditText edPhone = (EditText) findViewById(R.id.ed_phone);
        Button Ok = (Button) findViewById(R.id.b_ok);
        String name = edName.getText().toString();
        String phone = edPhone.getText().toString();
        getIntent().putExtra("EXTRA_NICKNAME", name);
        getIntent().putExtra("EXTRA_PHONE", phone);
        setResult(RESULT_OK,getIntent());
        Intent intent = new Intent(this, MainActivity.class);

    }
}
