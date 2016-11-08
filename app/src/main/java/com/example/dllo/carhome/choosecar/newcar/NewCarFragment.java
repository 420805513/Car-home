package com.example.dllo.carhome.choosecar.newcar;

import android.webkit.WebView;
import android.widget.ListView;

import com.example.dllo.carhome.R;
import com.example.dllo.carhome.base.BaseFragment;

/**
 * Created by dllo on 16/11/8.
 */
public class NewCarFragment extends BaseFragment {
    private ListView lv;

    @Override
    protected int getLayout() {
        return R.layout.fragment_choosecar_new_car;
    }

    @Override
    protected void initView() {
       lv = bindView(R.id.lv_choose_car_new_car);
    }

    @Override
    protected void initData() {



    }
}
