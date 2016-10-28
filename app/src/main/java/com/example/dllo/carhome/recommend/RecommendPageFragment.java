package com.example.dllo.carhome.recommend;

import android.widget.ListView;

import com.example.dllo.carhome.R;
import com.example.dllo.carhome.base.BaseFragment;
import com.example.dllo.carhome.recommend.listviewandinside.RecommendPageListViewAdapter;

/**
 * Created by dllo on 16/10/25.
 */
public class RecommendPageFragment extends BaseFragment{
    private ListView lv;
    @Override
    protected int getLayout() {
        return R.layout.fragment_recommend_page;
    }

    @Override
    protected void initView() {
        lv = bindView(R.id.lv_recommend);

    }

    @Override
    protected void initData() {
        RecommendPageListViewAdapter adapter = new RecommendPageListViewAdapter(getContext());
        // 先写到这里, 明天写假数据 , 然后网络请求
        lv.setAdapter(adapter);

    }
}
