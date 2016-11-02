package com.example.dllo.carhome.recommend;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;

import com.example.dllo.carhome.R;
import com.example.dllo.carhome.base.BaseFragment;

import java.util.ArrayList;

/**
 * Created by dllo on 16/10/24.
 */
public class RecommendFragment extends BaseFragment implements View.OnClickListener {
    private ViewPager vp;
    private TabLayout tb;
    private ImageView iv;

    @Override
    protected int getLayout() {
        return R.layout.fragment_recommend;
    }

    @Override
    protected void initView() {
        vp = bindView(R.id.vp_recommend);
        tb = bindView(R.id.tb_recommend);
        iv = bindView(R.id.iv_more);
        iv.setOnClickListener(this);

        RecommendFragmentAdapter adapter = new RecommendFragmentAdapter(getChildFragmentManager());
        vp.setAdapter(adapter);
        tb.setupWithViewPager(vp);
        tb.setTabMode(TabLayout.MODE_SCROLLABLE);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_more:
                Intent intent = new Intent(getActivity(),RecommendMoreActivity.class);
                startActivity(intent);
                break;
        }
    }
}
