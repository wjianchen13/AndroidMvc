package com.example.androidmvc.llistView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.androidmvc.R;
import com.example.androidmvc.llistView.view.ListActivity;

/**
 * 列表显示数据
 * 封装Activity列表显示和Fragment列表显示，没有完成，可直接删除
 */
public class ListViewActivity extends AppCompatActivity implements View.OnClickListener {
    
    private Button btnActivity;
    private Button btnFragment;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);
        btnActivity = findViewById(R.id.btn_activity);
        btnFragment = findViewById(R.id.btn_fragment);
        btnActivity.setOnClickListener(this);
        btnFragment.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btn_activity) {
            startActivity(new Intent(this, ListActivity.class));
        } else if(view.getId() == R.id.btn_fragment) {

        }
    }
}