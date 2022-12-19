package com.example.androidmvc.llistView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.androidmvc.R;

/**
 * 列表显示数据
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

        } else if(view.getId() == R.id.btn_fragment) {

        }
    }
}