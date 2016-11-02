package com.example.dllo.carhome.recommend;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.dllo.carhome.R;
import com.example.dllo.carhome.UrlList;
import com.example.dllo.carhome.gsonandvolley.GsonRequest;
import com.example.dllo.carhome.gsonandvolley.VolleySingleton;
import com.example.dllo.carhome.recommend.listviewandinside.RecommendPageListViewAdapter;
import com.example.dllo.carhome.recommend.listviewandinside.RecommendPageListViewBean;
import com.jude.rollviewpager.RollPagerView;
import com.jude.rollviewpager.adapter.LoopPagerAdapter;
import com.jude.rollviewpager.hintview.ColorPointHintView;

/**
 * Created by dllo on 16/10/25.
 */
public class RecommendPageFragment extends Fragment {
      private static final String KEY = "pos";
      private ListView lv;
      private RollPagerView mRollViewPager;


    /**
     * pos位置
     */
    public static RecommendPageFragment getInstance(int pos) {
        RecommendPageFragment rpf = new RecommendPageFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(KEY,pos);
        rpf.setArguments(bundle);
        return rpf;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_recommend_page,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        lv = (ListView) view.findViewById(R.id.lv_recommend);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // 拿值
        Bundle arguments = getArguments();
        int pos = arguments.getInt(KEY);
        switch (pos) {
            case 0:
                GsonRequest<RecommendPageListViewBean> gsonRequest = new GsonRequest<RecommendPageListViewBean>(RecommendPageListViewBean.class, UrlList.URL_RECOMMEND, new Response.Listener<RecommendPageListViewBean>() {
                    @Override
                    public void onResponse(RecommendPageListViewBean response) {
                        // 请求成功的方法
//                        Log.d("RecommendPageFragment", response.getResult().getFocusimg().get(0).getImgurl());
                        RecommendPageListViewAdapter adapter = new RecommendPageListViewAdapter(getContext());
                        adapter.setRecommendPageListViewBean(response);

                        View headLeader = getActivity().getLayoutInflater().inflate(R.layout.fragment_recommend_page_circleview, null);
                        // 轮播图的内容
                        mRollViewPager = (RollPagerView) headLeader.findViewById(R.id.rpv_recommend);
                        LoopAdapter loopAdapter = new LoopAdapter(mRollViewPager);
                        loopAdapter.setRecommendPageListViewBean(response);
//                        mRollViewPager.setHintView(new ColorPointHintView(getContext(), Color.YELLOW, Color.WHITE));
                        lv.addHeaderView(headLeader);
                        mRollViewPager.setAdapter(loopAdapter);
                        // 添加头布局
                        lv.setAdapter(adapter);

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // 请求失败的方法

                    }
                });
                VolleySingleton.getInstance().addRequest(gsonRequest);

                break;
            case 1:

                break;
            case 2:

                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
            case 8:
                break;
            case 9:
                break;
            case 10:
                break;
            case 11:
                break;
            case 12:
                break;

        }
    }

    //    private ListView lv;
//    private RollPagerView mRollViewPager;
//
//    @Override
//    protected int getLayout() {
//        return R.layout.fragment_recommend_page;
//    }
//
//    @Override
//    protected void initView() {
//        lv = bindView(R.id.lv_recommend);
//
//    }
//

    private void initData() {


    }

}
