package com.yanghaoyi.presentation.view.activity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.yanghaoyi.presentation.MultiScreenService;
import com.yanghaoyi.presentation.R;

/**
 * @author : YangHaoYi on 2019/1/2.
 *         Email  :  yang.haoyi@qq.com
 *         Description :
 *         Change : YangHaoYi on 2019/1/2.
 *         Version : V 1.0
 */
public class MainActivity extends AppCompatActivity {

    private MultiScreenService multiScreenService;
    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            multiScreenService = ((MultiScreenService.MultiScreenBinder) service).getService();
            multiScreenService.showSearchPresentation();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };
    private TextView tvShowPresentation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init(){
        initView();
        initEvent();
    }

    private void initView(){
        tvShowPresentation = findViewById(R.id.tvShowPresentation);
    }

    private void initEvent(){
        tvShowPresentation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSearchPresentation();
            }
        });
    }

    private void openSearchPresentation(){
        Intent intent = new Intent(this,MultiScreenService.class);
        bindService(intent,serviceConnection, Context.BIND_AUTO_CREATE);

    }



}
