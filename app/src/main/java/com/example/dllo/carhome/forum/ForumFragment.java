package com.example.dllo.carhome.forum;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.example.dllo.carhome.R;
import com.example.dllo.carhome.base.BaseFragment;
import com.example.dllo.carhome.recommend.RecommendFragmentAdapter;

import java.util.ArrayList;

/**
 * Created by dllo on 16/10/24.
 */
public class ForumFragment extends BaseFragment {
    private ViewPager vp;
    private TabLayout tb;
    private ArrayList<Fragment> arrayList;

    @Override
    protected int getLayout() {
        return R.layout.fragment_forum;
    }

    @Override
    protected void initView() {

    }
    @Override
    protected void initData() {

    }
}
