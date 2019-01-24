package com.bw.movie.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;

import com.bw.movie.MainActivity;
import com.bw.movie.R;
import com.bw.movie.base.BaseActivity;

/**
 * Created by android_lhf：2019/1/24
 */
public class StartActivity extends BaseActivity {
    private int Time  = 2;
    private SharedPreferences preferences;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what ==0){
                if (Time>0) {
                    //时间--
                    Time--;
                    //给时间赋值
                    handler.sendEmptyMessageDelayed(0, 1000);
                }else {
                    if (isFirstUse) {
                        startActivity(new Intent(StartActivity.this, YinDaoActivity.class));
                    } else {
                        startActivity(new Intent(StartActivity.this, MainActivity.class));
                    }
                    finish();
                    //实例化Editor对象
                    SharedPreferences.Editor editor = preferences.edit();
                    //存入数据
                    editor.putBoolean("isFirstUse", false);
                    //提交修改
                    editor.commit();

                }
            }
        }
    };

    private boolean isFirstUse;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        preferences = getSharedPreferences("isFirstUse", MODE_WORLD_READABLE);
        isFirstUse = preferences.getBoolean("isFirstUse", true);
        setContentView(R.layout.activity_start);
        handler.sendEmptyMessageDelayed(0,2000);
    }
}
