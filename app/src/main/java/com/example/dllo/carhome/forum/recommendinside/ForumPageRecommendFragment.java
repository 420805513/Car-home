package com.example.dllo.carhome.forum.recommendinside;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.dllo.carhome.R;
import com.example.dllo.carhome.base.BaseFragment;
import com.example.dllo.carhome.gsonandvolley.UrlList;
import com.example.dllo.carhome.gsonandvolley.GsonRequest;
import com.example.dllo.carhome.gsonandvolley.VolleySingleton;
import com.example.dllo.carhome.recommend.MainActivity;


/**
 * Created by dllo on 16/11/7.
 */
public class ForumPageRecommendFragment extends BaseFragment implements View.OnClickListener {
    private ListView listview;
    private RelativeLayout relativeLayout;
    private RelativeLayout relativeLayoutDown;
    private View headLeader;

    @Override
    protected int getLayout() {
        return R.layout.fragment_forum_recommend_page;

    }

    @Override
    protected void initView() {
        listview = bindView(R.id.lv_forum);
        headLeader = getActivity().getLayoutInflater().inflate(R.layout.fragment_forum_recommend_headleader,null);
        relativeLayout = bindView(headLeader,R.id.rl_forum_all_recommend);
        relativeLayoutDown = bindView(headLeader,R.id.rl_forum_hot_page);
        relativeLayout.setOnClickListener(this);
        relativeLayoutDown.setOnClickListener(this);
        listview.addHeaderView(headLeader);

    }

    @Override
    protected void initData() {
        GsonRequest<ForumPageForumBean> gsonRequest = new GsonRequest<ForumPageForumBean>(ForumPageForumBean.class, UrlList.URL_FORUM_RECOMMEND, new Response.Listener<ForumPageForumBean>() {
            @Override
            public void onResponse(ForumPageForumBean response) {
                // 正确的话
                ForumPageForumAdapter adapter = new ForumPageForumAdapter();
                adapter.setForumPageForumBean(response);
                listview.setAdapter(adapter);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // 错误的话

        }
    });
        VolleySingleton.getInstance().addRequest(gsonRequest);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rl_forum_all_recommend:
                // 跳转到新的activity,listview
                Intent intent = new Intent(getActivity(),ForumPageNiceCatchActivity.class);
                startActivity(intent);
                break;
            case R.id.rl_forum_hot_page:
                // 跳转到新的activity,listview
                Intent intent1 = new Intent(getActivity(),ForumPageHotActivity.class);
                startActivity(intent1);
                break;
        }
    }
}


