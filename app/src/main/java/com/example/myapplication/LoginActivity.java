package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button btn_login = (Button) findViewById(R.id.btn_login);
        Button btn_logout = (Button) findViewById(R.id.btn_logout);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText et_loginid = (EditText)findViewById(R.id.et_loginid);
                EditText et_loginpw = (EditText)findViewById(R.id.et_loginpw);

                String id = et_loginid.getText().toString();
                String pw = et_loginpw.getText().toString();

                CallWCF cw = new CallWCF();
                TextView tvlogin = (TextView) findViewById(R.id.tv_loginresult);
                tvlogin.setText(cw.LoginReq(id,pw));
            }
        });

        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText et_loginid = (EditText)findViewById(R.id.et_loginid);
                EditText et_loginpw = (EditText)findViewById(R.id.et_loginpw);

                String id = et_loginid.getText().toString();
                String pw = et_loginpw.getText().toString();

                CallWCF cw = new CallWCF();
                TextView tvlogin = (TextView) findViewById(R.id.tv_loginresult);
                tvlogin.setText(cw.LogoutReq(id,pw));
            }
        });
    }
}