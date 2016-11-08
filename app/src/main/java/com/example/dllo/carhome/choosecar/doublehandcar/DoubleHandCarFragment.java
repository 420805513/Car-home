package com.example.dllo.carhome.choosecar.doublehandcar;

import android.webkit.WebView;

import com.example.dllo.carhome.R;
import com.example.dllo.carhome.base.BaseFragment;

/**
 * Created by dllo on 16/11/8.
 */
public class DoubleHandCarFragment extends BaseFragment {
    private WebView wv;
    @Override
    protected int getLayout() {
        return R.layout.fragment_choosecar_double_hand_car;
    }

    @Override
    protected void initView() {
        wv = bindView(R.id.wv_double_hand_car);
    }

    @Override
    protected void initData() {
        wv.loadUrl("http://m.che168.com/dalian/list/?sourcename=mainapp&safe=0&carsafe=1&pvareaid=102254");
    }
}
