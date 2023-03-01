package com.example.androidmvc.llistView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.androidmvc.R;

/**
 * 公共列表显示数据
 */
public abstract class BaseListActivity extends AppCompatActivity implements View.OnClickListener {
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btn_activity) {

        } else if(view.getId() == R.id.btn_fragment) {

        }
    }
}