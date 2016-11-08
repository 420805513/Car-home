package com.example.dllo.carhome.forum;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.example.dllo.carhome.R;
import com.example.dllo.carhome.base.BaseFragment;
import com.example.dllo.carhome.forum.foruminside.ForumPageFragment;
import com.example.dllo.carhome.forum.recommendinside.ForumPageRecommendFragment;

import java.util.ArrayList;

/**
 * Created by dllo on 16/10/24.
 */
public class ForumFragment extends BaseFragment {
    private ViewPager vp;
    private TabLayout tb;


    @Override
    protected int getLayout() {
        return R.layout.fragment_forum;
    }

    @Override
    protected void initView() {
        vp = bindView(R.id.vp_forum);
        tb = bindView(R.id.tb_forum);

        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new ForumPageRecommendFragment());
        fragments.add(new ForumPageFragment());
        ForumFragmentAdapter forumFragmentAdapter = new ForumFragmentAdapter(getChildFragmentManager());
        forumFragmentAdapter.setFragment(fragments);
        vp.setAdapter(forumFragmentAdapter);
        tb.setupWithViewPager(vp);


    }
    @Override
    protected void initData() {

    }
}
