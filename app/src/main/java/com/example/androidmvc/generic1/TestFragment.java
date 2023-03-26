package com.example.androidmvc.generic1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.androidmvc.R;


public class TestFragment extends Fragment implements View.OnClickListener{

    private String test;
    private TextView tvTest;
    private Button btnTest1;
    private Button btnTest2;

    public static TestFragment newInstance(String test) {
        Bundle args = new Bundle();
        TestFragment fragment = new TestFragment();
        args.putString("test", test);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Bundle bundle = getArguments();
        if (bundle != null) {
            test = bundle.getString("test");
        }
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_test, null);
        initView(view);
        return view;
    }
    
    /**
     * 初始化界面
     * @param
     * @return
     */
    private void initView(View view) {
        if(view != null) {

            tvTest = view.findViewById(R.id.tv_test);

            btnTest1 = view.findViewById(R.id.btn_test1);
            btnTest1.setOnClickListener(this);
            btnTest2 = view.findViewById(R.id.btn_test2);
            btnTest2.setOnClickListener(this);

        }
    }
    
    /**
     * 删除一个fragment
     */
    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.btn_test1:

                break;
            case R.id.btn_test2:

                break;

        }
    }

}
