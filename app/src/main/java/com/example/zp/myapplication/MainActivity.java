package com.example.zp.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.listView)
    ListView listView;
    private ArrayList<Integer> images = new ArrayList<>();
    private ArrayList<String> titles = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        for (int i = 0; i < 100; i++) {
            images.add(R.mipmap.icon);
            titles.add("张三" + i);
        }
        MyAdapter myAdapter = new MyAdapter(this, R.layout.list_item, images, titles);

        listView.setAdapter(myAdapter);

        //点击某一项进入详细界面
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //跳转到详细页面
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);

                //携带数据
                Bundle bundle = new Bundle();
                bundle.putCharSequence("name", titles.get(i));
                bundle.putCharSequence("image", images.get(i).toString());
                intent.putExtras(bundle);

                //进行跳转
                startActivity(intent);
            }
        });

    }
}
