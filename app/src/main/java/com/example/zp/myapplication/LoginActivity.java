package com.example.zp.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {


    @BindView(R.id.account)
    EditText account;
    @BindView(R.id.password)
    EditText password;
    @BindView(R.id.login)
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        ButterKnife.bind(this);
    }


    @OnClick(R.id.login)
    public void onViewClicked() {
        String ac = account.getText().toString();
        String pa = password.getText().toString();
        Log.i("TAG", account.getText().toString());
        //判断是否登陆成功
        if (ac.equals("admin") && pa.equals("123")) {
            //跳转页面
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        } else {
            //提示登录失败
            Toast.makeText(this, "登陆失败", Toast.LENGTH_LONG).show();
        }
    }
}
