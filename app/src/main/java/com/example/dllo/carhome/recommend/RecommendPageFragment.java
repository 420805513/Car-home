package com.example.dllo.carhome.recommend;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.dllo.carhome.R;
import com.example.dllo.carhome.base.BaseFragment;
import com.example.dllo.carhome.gsonandvolley.UrlList;
import com.example.dllo.carhome.gsonandvolley.GsonRequest;
import com.example.dllo.carhome.gsonandvolley.VolleySingleton;
import com.example.dllo.carhome.recommend.newsinside.RecommendPageNewsAdapter;
import com.example.dllo.carhome.recommend.newsinside.RecommendPageNewsBean;
import com.example.dllo.carhome.recommend.quicknewsinside.RecommendPageQuickNewsAdapter;
import com.example.dllo.carhome.recommend.quicknewsinside.RecommendPageQuickNewsBean;
import com.example.dllo.carhome.recommend.recommendinside.LoopAdapter;
import com.example.dllo.carhome.recommend.recommendinside.RecommendPageListViewAdapter;
import com.example.dllo.carhome.recommend.recommendinside.RecommendPageListViewBean;
import com.example.dllo.carhome.recommend.speakinside.RecommendPageSpeakAdapter;
import com.example.dllo.carhome.recommend.speakinside.RecommendPageSpeakBean;
import com.jude.rollviewpager.RollPagerView;

/**
 * Created by dllo on 16/10/25.
 */
public class RecommendPageFragment extends BaseFragment {
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
        Bundle arguments = getArguments();
        final int pos = arguments.getInt(KEY);
        switch (pos) {
            case 0:
                GsonRequest<RecommendPageListViewBean> gsonRequest = new GsonRequest<RecommendPageListViewBean>(RecommendPageListViewBean.class, UrlList.URL_RECOMMEND, new Response.Listener<RecommendPageListViewBean>() {
                    @Override
                    public void onResponse(RecommendPageListViewBean response) {
                        // 请求成功的方法
                        RecommendPageListViewAdapter adapter = new RecommendPageListViewAdapter();
                        adapter.setRecommendPageListViewBean(response);

                        View headLeader = getActivity().getLayoutInflater().inflate(R.layout.fragment_recommend_page_circleview, null,false);
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
//                GsonRequest<RecommendPageNiceCreatBean> gsonRequest1 = new GsonRequest<RecommendPageNiceCreatBean>(RecommendPageNiceCreatBean.class, UrlList.URL_NICECREAT, new Response.Listener<RecommendPageNiceCreatBean>() {
//                    @Override
//                    public void onResponse(RecommendPageNiceCreatBean response) {
//                        //请求成功的方法
//
//
//                    }
//                }, new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        // 请求失败的方法
//
//                    }
//
//        });

                break;
            case 2:
                // 说客
                GsonRequest<RecommendPageSpeakBean> gsonRequest2 = new GsonRequest<RecommendPageSpeakBean>(RecommendPageSpeakBean.class, UrlList.URL_SPEAK, new Response.Listener<RecommendPageSpeakBean>() {
                    @Override
                    public void onResponse(RecommendPageSpeakBean response) {
                        RecommendPageSpeakAdapter adapter = new RecommendPageSpeakAdapter();
                        adapter.setRecommendPageSpeakBean(response);
                        lv.setAdapter(adapter);

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }

                });
                VolleySingleton.getInstance().addRequest(gsonRequest2);

                break;
            case 3:
                // 视频
                break;
            case 4:
                // 快报
                GsonRequest<RecommendPageQuickNewsBean> gsonRequest4 = new GsonRequest<RecommendPageQuickNewsBean>(RecommendPageQuickNewsBean.class, UrlList.URL_QUICKNEWS, new Response.Listener<RecommendPageQuickNewsBean>() {
                    @Override
                    public void onResponse(RecommendPageQuickNewsBean response) {
                        RecommendPageQuickNewsAdapter adapter =  new RecommendPageQuickNewsAdapter();
                        adapter.setRecommendPageQuickNewsBean(response);
                        lv.setAdapter(adapter);

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });
                VolleySingleton.getInstance().addRequest(gsonRequest4);
                break;
            case 5:
                // 行情
                GsonRequest<RecommendPageListViewBean> gsonRequest5 = new GsonRequest<RecommendPageListViewBean>(RecommendPageListViewBean.class, UrlList.URL_CONDITION, new Response.Listener<RecommendPageListViewBean>() {
                    @Override
                    public void onResponse(RecommendPageListViewBean response) {
                        RecommendPageListViewAdapter adapter = new RecommendPageListViewAdapter();
                        adapter.setRecommendPageListViewBean(response);
                        lv.setAdapter(adapter);
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }

                });
                VolleySingleton.getInstance().addRequest(gsonRequest5);

                break;
            case 6:
                // 新闻
                GsonRequest<RecommendPageNewsBean> gsonRequest6 = new GsonRequest<RecommendPageNewsBean>(RecommendPageNewsBean.class, UrlList.URL_NEWS, new Response.Listener<RecommendPageNewsBean>() {
                    @Override
                    public void onResponse(RecommendPageNewsBean response) {
                        RecommendPageNewsAdapter adapter = new RecommendPageNewsAdapter();
                        adapter.setRecommendPageNewsBean(response);
                        lv.setAdapter(adapter);

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });
                VolleySingleton.getInstance().addRequest(gsonRequest6);
                break;
            case 7:
                GsonRequest<RecommendPageListViewBean> gsonRequest7 = new GsonRequest<RecommendPageListViewBean>(RecommendPageListViewBean.class, UrlList.URL_EVALUATION, new Response.Listener<RecommendPageListViewBean>() {
                    @Override
                    public void onResponse(RecommendPageListViewBean response) {
                        RecommendPageListViewAdapter adapter = new RecommendPageListViewAdapter();
                        adapter.setRecommendPageListViewBean(response);
                        lv.setAdapter(adapter);
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }

                });
                VolleySingleton.getInstance().addRequest(gsonRequest7);

                break;
            case 8:
                GsonRequest<RecommendPageListViewBean> gsonRequest8 = new GsonRequest<RecommendPageListViewBean>(RecommendPageListViewBean.class, UrlList.URL_SHOPPINGGUIDE, new Response.Listener<RecommendPageListViewBean>() {
                    @Override
                    public void onResponse(RecommendPageListViewBean response) {
                        RecommendPageListViewAdapter adapter = new RecommendPageListViewAdapter();
                        adapter.setRecommendPageListViewBean(response);
                        lv.setAdapter(adapter);
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }

                });
                VolleySingleton.getInstance().addRequest(gsonRequest8);

                break;
            case 9:
                GsonRequest<RecommendPageListViewBean> gsonRequest9 = new GsonRequest<RecommendPageListViewBean>(RecommendPageListViewBean.class, UrlList.URL_USECAR, new Response.Listener<RecommendPageListViewBean>() {
                    @Override
                    public void onResponse(RecommendPageListViewBean response) {
                        RecommendPageListViewAdapter adapter = new RecommendPageListViewAdapter();
                        adapter.setRecommendPageListViewBean(response);
                        lv.setAdapter(adapter);
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }

                });
                VolleySingleton.getInstance().addRequest(gsonRequest9);

                break;
            case 10:
                GsonRequest<RecommendPageListViewBean> gsonRequest10 = new GsonRequest<RecommendPageListViewBean>(RecommendPageListViewBean.class, UrlList.URL_TECHNOLOGY, new Response.Listener<RecommendPageListViewBean>() {
                    @Override
                    public void onResponse(RecommendPageListViewBean response) {
                        RecommendPageListViewAdapter adapter = new RecommendPageListViewAdapter();
                        adapter.setRecommendPageListViewBean(response);
                        lv.setAdapter(adapter);
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }

                });
                VolleySingleton.getInstance().addRequest(gsonRequest10);

                break;
            case 11:
                GsonRequest<RecommendPageListViewBean> gsonRequest11 = new GsonRequest<RecommendPageListViewBean>(RecommendPageListViewBean.class, UrlList.URL_CULTURE, new Response.Listener<RecommendPageListViewBean>() {
                    @Override
                    public void onResponse(RecommendPageListViewBean response) {
                        RecommendPageListViewAdapter adapter = new RecommendPageListViewAdapter();
                        adapter.setRecommendPageListViewBean(response);
                        lv.setAdapter(adapter);
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }

                });
                VolleySingleton.getInstance().addRequest(gsonRequest11);

                break;
            case 12:
                GsonRequest<RecommendPageListViewBean> gsonRequest12 = new GsonRequest<RecommendPageListViewBean>(RecommendPageListViewBean.class, UrlList.URL_REFIT, new Response.Listener<RecommendPageListViewBean>() {
                    @Override
                    public void onResponse(RecommendPageListViewBean response) {
                        RecommendPageListViewAdapter adapter = new RecommendPageListViewAdapter();
                        adapter.setRecommendPageListViewBean(response);
                        lv.setAdapter(adapter);
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }

                });
                VolleySingleton.getInstance().addRequest(gsonRequest12);

                break;

        }

    }



//    public void init(String wangzhi){
//        GsonRequest<RecommendPageListViewBean> gsonRequest12 = new GsonRequest<RecommendPageListViewBean>(RecommendPageListViewBean.class, wangzhi, new Response.Listener<RecommendPageListViewBean>() {
//            @Override
//            public void onResponse(RecommendPageListViewBean response) {
//                RecommendPageListViewAdapter adapter = new RecommendPageListViewAdapter(getContext());
//                adapter.setRecommendPageListViewBean(response);
//                lv.setAdapter(adapter);
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//
//            }
//
//        });
//        VolleySingleton.getInstance().addRequest(gsonRequest12);
//    }

}
