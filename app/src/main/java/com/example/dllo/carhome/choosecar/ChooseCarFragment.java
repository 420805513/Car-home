package com.example.dllo.carhome.choosecar;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.example.dllo.carhome.R;
import com.example.dllo.carhome.base.BaseFragment;
import com.example.dllo.carhome.choosecar.doublehandcar.DoubleHandCarFragment;
import com.example.dllo.carhome.choosecar.newcar.NewCarFragment;

import java.util.ArrayList;

/**
 * Created by dllo on 16/10/24.
 */
public class ChooseCarFragment extends BaseFragment {
    private TabLayout tb;
    private ViewPager vp;

    @Override
    protected int getLayout() {
        return R.layout.fragment_choosecar;
    }

    @Override
    protected void initView() {
        vp = bindView(R.id.vp_choose_car);
        tb = bindView(R.id.tb_choose_car);

    }

    @Override
    protected void initData() {
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new NewCarFragment());
        fragments.add(new DoubleHandCarFragment());
        ChooseCarAdapter adapter = new ChooseCarAdapter(getChildFragmentManager());
        adapter.setFragments(fragments);
        vp.setAdapter(adapter);
        tb.setupWithViewPager(vp);
    }
}
