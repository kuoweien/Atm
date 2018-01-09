package com.wayne.atm;

import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import static com.wayne.atm.R.id.userid;

public class LoginActivity extends AppCompatActivity {
    private EditText edUserid;
    private EditText edPasswd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        edUserid = (EditText) findViewById(userid);
        edPasswd = (EditText) findViewById(R.id.passwd);
        String userid = getSharedPreferences("atm", MODE_PRIVATE)
                .getString("USERID", "");
        edUserid.setText(userid);
    }
    public class LoginTask extends AsyncTask<String, Void, Integer>{

        @Override
        protected Integer doInBackground(String... strings) {
            int data = 0;
            try{
                URL url = new URL(strings[0]);
                InputStream is = url.openStream();
                data = is.read();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            
            return data;
        }
        protected void onPostExecute(Integer integer){
            if(integer==49){
                getIntent().putExtra("EXRA_USERID", userid);
                setResult(RESULT_OK, getIntent());
                finish();
            }else{
                new AlertDialog.Builder(LoginActivity.this)
                        .setTitle("登入")
                        .setMessage("登入失敗")
                        .setPositiveButton("OK",null)
                        .show();
            }
        }
    }
    public void login(View v){

        String userid = edUserid.getText().toString();
        String passwd = edPasswd.getText().toString();
        if ("jack".equals(userid)&&"1234".equals(passwd)){
            Toast.makeText(this, "登入成功",Toast.LENGTH_LONG).show();
            getIntent().putExtra("EXTRA_USERID", userid);
            getIntent().putExtra("EXTRA_PASSWD", passwd);
            setResult(RESULT_OK, getIntent());
            finish();
        }else{
            new AlertDialog.Builder(this)
                    .setTitle("登入")
                    .setMessage("登入失敗")
                    .setPositiveButton("OK",null)
                    .show();
        }
    }
    public void cancel(View v){

    }
}
