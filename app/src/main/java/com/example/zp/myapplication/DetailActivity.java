package com.example.zp.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DetailActivity extends AppCompatActivity {

    @BindView(R.id.icon)
    TextView icon;
    @BindView(R.id.image)
    ImageView image;
    @BindView(R.id.back)
    Button back;
    @BindView(R.id.backToLogin)
    Button backToLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ButterKnife.bind(this);

        String name = getIntent().getExtras().getString("name");
        String mImage = getIntent().getExtras().getString("image");

        icon.setText(name);
        image.setImageResource(Integer.valueOf(mImage));

    }

    @OnClick({R.id.back, R.id.backToLogin})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.backToLogin:
                Intent intent = new Intent(this,LoginActivity.class);
                startActivity(intent);
                break;
        }
    }
}
