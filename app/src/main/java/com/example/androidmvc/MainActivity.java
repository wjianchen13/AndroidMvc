package com.example.androidmvc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.androidmvc.llistView.ListViewActivity;
import com.example.androidmvc.mvc.controllor.MvcActivity;
import com.example.androidmvc.mvp.view.MvpActivity;
import com.example.androidmvc.mvvm.view.LoginActivity;
import com.example.androidmvc.test_recyclerview.view.TestRecyclerviewActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    
    public void onMvc(View v) {
        startActivity(new Intent(this, MvcActivity.class));
    }

    public void onMvp(View v) {
        startActivity(new Intent(this, MvpActivity.class));
    }

    public void onMvvm(View v) {
        startActivity(new Intent(this, LoginActivity.class));
    }

    public void onListView(View v) {
        startActivity(new Intent(this, ListViewActivity.class));
    }

    public void onTestRecyclerview(View v) {
        startActivity(new Intent(this, TestRecyclerviewActivity.class));
    }

}