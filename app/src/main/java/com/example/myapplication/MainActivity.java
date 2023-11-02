package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button btn_loginpage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_reg = (Button)findViewById(R.id.btn_reg);
        Button btn_unreg = (Button)findViewById(R.id.btn_unreg);

        btn_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText ed_id = (EditText)findViewById(R.id.et_id);
                EditText et_pw = (EditText)findViewById(R.id.et_pw);
                EditText et_name = (EditText)findViewById(R.id.et_name);
                String id = ed_id.getText().toString();
                String pw = et_pw.getText().toString();
                String name = et_name.getText().toString();

                CallWCF cw = new CallWCF();
                TextView tv = (TextView)findViewById(R.id.tv_result);
                tv.setText(cw.RegReq(id,pw,name));
            }
        });

        btn_unreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText ed_id = (EditText)findViewById(R.id.et_id);
                EditText et_pw = (EditText)findViewById(R.id.et_pw);
                String id = ed_id.getText().toString();
                String pw = et_pw.getText().toString();

                CallWCF cw = new CallWCF();
                TextView tv = (TextView)findViewById(R.id.tv_result);
                tv.setText(cw.UnregReq(id,pw));
            }
        });

        btn_loginpage = (Button)findViewById(R.id.btn_loginpage);

        btn_loginpage.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}