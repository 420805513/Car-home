package com.example.dllo.carhome.recommend;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by dllo on 16/10/25.
 */
public class RecommendFragmentAdapter extends FragmentPagerAdapter {
    ArrayList<Fragment> fragment;
    String [] titles = {"推荐","优创+","说客","视频","快报","行情","新闻","评测","导购","用车","技术"};
    public RecommendFragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return fragment.get(position);
    }

    @Override
    public int getCount() {
        return fragment.size();
    }

    public void setFragment(ArrayList<Fragment> fragment) {
        this.fragment = fragment;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
