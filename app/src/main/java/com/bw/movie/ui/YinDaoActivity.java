package com.bw.movie.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.bw.movie.R;
import com.bw.movie.adapter.ViewPageAdapter;
import com.bw.movie.base.BaseActivity;
import com.bw.movie.weight.DepthPageTransformer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by android_lhf：2019/1/24
 */
public class YinDaoActivity extends BaseActivity {
    private ViewPager mIn_vp;
    private LinearLayout mIn_ll;
    private List<View> mViewList;
    private ImageView mLight_dots;
    private int mDistance;
    private ImageView mOne_dot;
    private ImageView mTwo_dot;
    private ImageView mThree_dot;
    private ImageView mFour_dot;
    private boolean misScrolled;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yindao);
        initView();
        initData();
        mIn_vp.setAdapter(new ViewPageAdapter(mViewList));
        addDots();
        moveDots();
        mIn_vp.setPageTransformer(true, new DepthPageTransformer());
    }

    private void moveDots() {
        mLight_dots.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                //获得两个圆点之间的距离
                mDistance = mIn_ll.getChildAt(1).getLeft() - mIn_ll.getChildAt(0).getLeft();
                mLight_dots.getViewTreeObserver()
                        .removeGlobalOnLayoutListener(this);
            }
        });
        mIn_vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                //页面滚动时小白点移动的距离，并通过setLayoutParams(params)不断更新其位置
                float leftMargin = mDistance * (position + positionOffset);
                RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) mLight_dots.getLayoutParams();
                params.leftMargin = (int) leftMargin;
                mLight_dots.setLayoutParams(params);
            }

            @Override
            public void onPageSelected(int position) {
                //页面跳转时，设置小圆点的margin
                float leftMargin = mDistance * position;
                RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) mLight_dots.getLayoutParams();
                params.leftMargin = (int) leftMargin;
                mLight_dots.setLayoutParams(params);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                switch (state) {
                    case ViewPager.SCROLL_STATE_DRAGGING:
                        misScrolled = false;
                        break;
                    case ViewPager.SCROLL_STATE_SETTLING:
                        misScrolled = true;
                        break;
                    case ViewPager.SCROLL_STATE_IDLE:
                        if (mIn_vp.getCurrentItem() == mIn_vp.getAdapter().getCount() - 1 && !misScrolled) {
                            startActivity(new Intent(YinDaoActivity.this, LoginActivity.class));
                            finish();
                        }
                        break;
                }
            }
        });
    }

    private void addDots() {
        mOne_dot = new ImageView(this);
        mOne_dot.setImageResource(R.drawable.gray_dot);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(0, 0, 40, 0);
        mIn_ll.addView(mOne_dot, layoutParams);
        mTwo_dot = new ImageView(this);
        mTwo_dot.setImageResource(R.drawable.gray_dot);
        mIn_ll.addView(mTwo_dot, layoutParams);
        mThree_dot = new ImageView(this);
        mThree_dot.setImageResource(R.drawable.gray_dot);
        mIn_ll.addView(mThree_dot, layoutParams);
        mFour_dot = new ImageView(this);
        mFour_dot.setImageResource(R.drawable.gray_dot);
        mIn_ll.addView(mFour_dot, layoutParams);
        setClickListener();

    }

    private void setClickListener() {
        mOne_dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mIn_vp.setCurrentItem(0);
            }
        });
        mTwo_dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mIn_vp.setCurrentItem(1);
            }
        });
        mThree_dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mIn_vp.setCurrentItem(2);
            }
        });
        mFour_dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mIn_vp.setCurrentItem(3);
            }
        });
    }


    private void initData() {
        mViewList = new ArrayList<>();
        View view1 = getLayoutInflater().inflate(R.layout.we_indicator1, null);
        View view2 = getLayoutInflater().inflate(R.layout.we_indicator2, null);
        View view3 = getLayoutInflater().inflate(R.layout.we_indicator3, null);
        View view4 = getLayoutInflater().inflate(R.layout.we_indicator4, null);
        mViewList.add(view1);
        mViewList.add(view2);
        mViewList.add(view3);
        mViewList.add(view4);
    }

    private void initView() {
        mIn_vp = (ViewPager) findViewById(R.id.in_viewpager);
        mIn_ll = (LinearLayout) findViewById(R.id.in_ll);
        mLight_dots = (ImageView) findViewById(R.id.iv_light_dots);
    }
}
