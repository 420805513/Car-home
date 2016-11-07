package com.example.dllo.carhome.forum;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.SparseArray;

import java.util.ArrayList;

/**
 * Created by dllo on 16/11/7.
 */
public class ForumFragmentAdapter extends FragmentPagerAdapter {
    ArrayList<Fragment> fragment;
    String [] titles = {"精选","论坛"};
    public ForumFragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    public void setFragment(ArrayList<Fragment> fragment) {
        this.fragment = fragment;
    }

    @Override
    public Fragment getItem(int position) {
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
