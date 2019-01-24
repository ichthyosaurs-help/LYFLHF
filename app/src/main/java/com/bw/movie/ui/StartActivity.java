package com.bw.movie.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.Log;

import com.bw.movie.MainActivity;
import com.bw.movie.R;
import com.bw.movie.base.BaseActivity;
import com.bw.movie.utils.SharedUtil;

/**
 * Created by android_lhf：2019/1/24
 */
public class StartActivity extends BaseActivity {
    private int Time  = 2;
    private boolean isFirstUse;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what ==0){
                if (Time>0) {
                    Time--;
                    handler.sendEmptyMessageDelayed(0, 1000);
                }else {
                    if (!isFirstUse) {
                        startActivity(new Intent(StartActivity.this, YinDaoActivity.class));
                        SharedUtil.SharedPrefrenceHelper(StartActivity.this).setSave("isFirstUse",true);
                    } else {
                        startActivity(new Intent(StartActivity.this, LoginActivity.class));
                    }
                    finish();
                    //实例化Editor对象

                   /* SharedPreferences.Editor editor = preferences.edit();
                    //存入数据
                    editor.putBoolean("isFirstUse", false);
                    //提交修改
                    editor.commit();*/

                }
            }
        }
    };


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        isFirstUse = (boolean) SharedUtil.SharedPrefrenceHelper(StartActivity.this).getData("isFirstUse", 3);
        Log.e("zzz", "onCreate: "+isFirstUse );
        /*preferences = getSharedPreferences("isFirstUse", MODE_WORLD_READABLE);
        this.isFirstUse = preferences.getBoolean("isFirstUse", true);*/
        handler.sendEmptyMessageDelayed(0,2000);
    }
}
