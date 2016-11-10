package com.example.dllo.carhome.recommend;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.SparseArray;

/**
 * Created by dllo on 16/10/25.
 */
public class RecommendFragmentAdapter extends FragmentPagerAdapter {
    SparseArray<Fragment> fragment;
    String [] titles;
    public RecommendFragmentAdapter(FragmentManager fm, String [] s) {
        super(fm);
        fragment = new SparseArray<>();
        titles = s;
    }


    @Override
    public Fragment getItem(int position) {
        if (fragment.get(position) == null) {
            fragment.put(position,RecommendPageFragment.getInstance(position));
        }
        return fragment.get(position);
    }

    @Override
    public int getCount() {
        return titles.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
