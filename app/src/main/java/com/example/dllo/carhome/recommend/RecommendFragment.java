package com.example.dllo.carhome.recommend;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.example.dllo.carhome.R;
import com.example.dllo.carhome.base.BaseFragment;

import java.util.ArrayList;

/**
 * Created by dllo on 16/10/24.
 */
public class RecommendFragment extends BaseFragment {
    private ViewPager vp;
    private TabLayout tb;
    private ArrayList<Fragment> arrayList;
    @Override
    protected int getLayout() {
        return R.layout.fragment_recommend;
    }

    @Override
    protected void initView() {
        vp = bindView(R.id.vp_recommend);
        tb = bindView(R.id.tb_recommend);
        arrayList = new ArrayList<>();
        arrayList.add(new RecommendPageFragment());
        arrayList.add(new NiceCreaterPageFragment());
        arrayList.add(new SpeakerPageFragment());
        arrayList.add(new VideoPageFragment());
        arrayList.add(new BulletinPageFragment());
        arrayList.add(new MarketConditionsPageFragment());
        arrayList.add(new NewsPageFragment());
        arrayList.add(new JudgePageFragment());
        arrayList.add(new ShoppingGuidePageFragment());
        arrayList.add(new UseCarPageFragment());
        arrayList.add(new TechnologyPageFragment());




        RecommendFragmentAdapter adapter = new RecommendFragmentAdapter(getChildFragmentManager());
        adapter.setFragment(arrayList);
        vp.setAdapter(adapter);
        tb.setupWithViewPager(vp);
        tb.setTabMode(TabLayout.MODE_SCROLLABLE);
    }

    @Override
    protected void initData() {

    }
}
