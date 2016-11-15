package com.example.dllo.carhome.opening;

import android.content.Intent;
import android.os.CountDownTimer;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.dllo.carhome.R;
import com.example.dllo.carhome.base.BaseActivity;
import com.example.dllo.carhome.recommend.MainActivity;

import cn.bmob.v3.Bmob;

/**
 * Created by dllo on 16/10/24.
 */
public class OpeningActivity extends BaseActivity implements View.OnClickListener {
    private ImageView frameIV;
    private TextView textViewMain;
    private TextView textViewPart;
    private Animation animation;
    private LinearLayout ll;
    private CountDownTimer timer;

    @Override
    protected int getLayout() {
        return R.layout.opening;
    }

    @Override
    protected void initViews() {

        frameIV = bindView(R.id.iv_opening);
        textViewMain = bindView(R.id.tv_opening_main);
        textViewPart = bindView(R.id.tv_opening_part);
        ll = bindView(R.id.ll_opening);
        animation = AnimationUtils.loadAnimation(this, R.anim.text_aa);
        ll.setOnClickListener(this);

    }

    @Override
    protected void initData() {
        timer = new CountDownTimer(4000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
            }
            @Override
            public void onFinish() {
                Intent intent = new Intent(OpeningActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        };
        timer.start();
        textViewMain.startAnimation(animation);
        textViewPart.startAnimation(animation);
    }
    @Override
    public void onClick(View v) {
       timer.onFinish();
        timer.cancel();
    }


}
