package com.example.dllo.carhome.forum.recommendinside;

import android.widget.ListView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.dllo.carhome.R;
import com.example.dllo.carhome.base.BaseActivity;
import com.example.dllo.carhome.gsonandvolley.GsonRequest;
import com.example.dllo.carhome.gsonandvolley.UrlList;
import com.example.dllo.carhome.gsonandvolley.VolleySingleton;

/**
 * Created by dllo on 16/11/7.
 */
public class ForumPageHotActivity extends BaseActivity{
    private ListView lv;
    @Override
    protected int getLayout() {
        return R.layout.activity_forum_hot_page;
    }

    @Override
    protected void initViews() {
        lv = bindView(R.id.lv_forum_hot_page);

    }

    @Override
    protected void initData() {
        GsonRequest<ForumPageHotBean> gsonRequest = new GsonRequest<ForumPageHotBean>(ForumPageHotBean.class, UrlList.URL_HOTPAGE_LIST, new Response.Listener<ForumPageHotBean>() {
            @Override
            public void onResponse(ForumPageHotBean response) {
                ForumPageHotAdapter adapter = new ForumPageHotAdapter();
                adapter.setForumPageHotBean(response);
                lv.setAdapter(adapter);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // 错误的话,所以基本没有写喵
            }

    });
        VolleySingleton.getInstance().addRequest(gsonRequest);
    }
}
