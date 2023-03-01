package com.example.androidmvc.llistView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidmvc.R;
import com.scwang.smart.refresh.footer.ClassicsFooter;
import com.scwang.smart.refresh.header.ClassicsHeader;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;

/**
 * 列表显示数据
 */
public class ListActivity extends BaseListActivity {

    private SmartRefreshLayout mSmartLayout;
    private ClassicsHeader mHeader;
    private RecyclerView mRecyclerView;
    private ClassicsFooter mFooter;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
//        mSmartLayout = findViewById(R.id.refreshLayout);
//        mHeader = findViewById(R.id.header);
//        mRecyclerView = findViewById(R.id.rv_refresh);
//        mFooter = findViewById(R.id.footer);
//        init();
    }

    private void init() {
//        mSmartLayout.setEnableLoadMore(false);
//        mSmartLayout.setEnableRefresh(false);
//        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
//        mRecyclerView.addItemDecoration(new ListAdapter.GameRankSpace(getActivityExp()));
//        mRecyclerView.setAdapter(mDinoGameRankingAdapter);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btn_activity) {

        } else if(view.getId() == R.id.btn_fragment) {

        }
    }
}