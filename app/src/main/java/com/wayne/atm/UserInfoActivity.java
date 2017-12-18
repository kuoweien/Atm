package com.wayne.atm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class UserInfoActivity extends AppCompatActivity {
    private EditText edName;
    private EditText edPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
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
        String name = edName.getText().toString();
        String phone = edPhone.getText().toString();
        getIntent().putExtra("EXTRA_NAME", name);
        getIntent().putExtra("EXTRA_PHONE", phone);
        setResult(RESULT_OK,getIntent());
  //      Intent intent = new Intent(this, MainActivity.class);
        finish();

    }
}
