package com.example.dllo.carhome.recommend;

import android.support.design.widget.TabLayout;

import com.example.dllo.carhome.R;
import com.example.dllo.carhome.base.BaseActivity;

/**
 * Created by dllo on 16/10/27.
 */
public class RecommendMoreActivity extends BaseActivity{
    private TabLayout tb;
    @Override
    protected int getLayout() {
        return R.layout.activity_recommend_more;
    }

    @Override
    protected void initViews() {
        findID();
    }



    @Override
    protected void initData() {
    }
    private void findID() {
        tb = bindView(R.id.tl_recommend_more);
    }
}
