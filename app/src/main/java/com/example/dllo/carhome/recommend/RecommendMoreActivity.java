package com.example.dllo.carhome.recommend;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.view.View;
import android.widget.ImageView;

import com.example.dllo.carhome.R;
import com.example.dllo.carhome.base.BaseActivity;

import javax.security.auth.Destroyable;

/**
 * Created by dllo on 16/10/27.
 */
public class RecommendMoreActivity extends BaseActivity implements View.OnClickListener {
    private ImageView iv;

    @Override
    protected int getLayout() {
        return R.layout.activity_recommend_more;
    }

    @Override
    protected void initViews() {
        iv =bindView(R.id.iv_recommend_more_quit);
        iv.setOnClickListener(this);

    }



    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_recommend_more_quit:
                finish();
                break;
        }
    }


}
