package com.example.dllo.carhome.choosecar;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.example.dllo.carhome.R;
import com.example.dllo.carhome.base.BaseFragment;

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
        tb = bindView(R.id.tb_choose_car);
        vp = bindView(R.id.vp_choose_car);
    }

    @Override
    protected void initData() {
        // TODO 将fragments们添加到Arraylist<Fragments>,并且加载adapter,vpsetadapter,tbsetvp


    }
}
