package com.bw.movie.base;

import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Window;
import android.view.WindowManager;

import com.bw.movie.utils.SystemBarTintManager;

/**
 * Created by android_lhf：2019/1/24
 */
public class BaseActivity extends FragmentActivity {
    public boolean setTranslucent = true;

    @Override
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);

        if (setTranslucent)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                setTranslucentStatus(true);
            }
        SystemBarTintManager tintManager = new SystemBarTintManager(this);
        tintManager.setStatusBarTintEnabled(true);
        tintManager.setNavigationBarTintEnabled(true);
        tintManager.setStatusBarTintColor(Color.TRANSPARENT);

    }

    public Activity getActivity(){
        return BaseActivity.this;
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @TargetApi(19)
    private void setTranslucentStatus(boolean on) {
        Window win = getWindow();
        WindowManager.LayoutParams winParams = win.getAttributes();
        final int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
        if (on) {
            winParams.flags |= bits;
        } else {
            winParams.flags &= ~bits;
        }
        win.setAttributes(winParams);
    }

    private int getStatusBarHeight() {
        int result = 0;
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (setTranslucent){}
        //setStatusBarBGHeight();
    }

    private void setStatusBarBGHeight() {

    }

    @Override
    protected void onPause() {
        super.onPause();
    }

}
