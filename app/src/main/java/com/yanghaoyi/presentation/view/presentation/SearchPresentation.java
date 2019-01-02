package com.yanghaoyi.presentation.view.presentation;

import android.app.Presentation;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.Display;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.yanghaoyi.presentation.R;

/**
 * @author : YangHaoYi on 2019/1/2.
 *         Email  :  yang.haoyi@qq.com
 *         Description :
 *         Change : YangHaoYi on 2019/1/2.
 *         Version : V 1.0
 */
public class SearchPresentation extends Presentation{

    private EditText edInput;
    private TextView tvSearch;


    public SearchPresentation(Context outerContext, Display display) {
        super(outerContext, display);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.presentation_search);
        init();
    }

    private void init(){
        initView();
        initEvent();
    }

    private void initView(){
        edInput = findViewById(R.id.edInput);
        tvSearch = findViewById(R.id.tvSearch);
    }

    private void initEvent(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                edInput.setText("测试测试");
            }
        },5000);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                tvSearch.performClick();
            }
        },7000);

        tvSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvSearch.setText(edInput.getText().toString());
            }
        });
    }



}
