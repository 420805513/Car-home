package com.example.dllo.carhome.forum.recommendinside;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.dllo.carhome.R;
import com.example.dllo.carhome.base.BaseActivity;
import com.example.dllo.carhome.gsonandvolley.GsonRequest;
import com.example.dllo.carhome.gsonandvolley.VolleySingleton;

/**
 * Created by dllo on 16/11/7.
 */
public class ForumPageNiceCatchDetailListViewActivity extends BaseActivity implements View.OnClickListener {
    private ListView lv;
    private ImageView iv;
    private TextView tv;
    @Override
    protected int getLayout() {
        return R.layout.activity_forum_nice_catch_detail_list_view;
    }

    @Override
    protected void initViews() {
        lv = bindView(R.id.lv_forum_nice_catch_detail);
        iv = bindView(R.id.iv_forum_nice_catch_detail_quit);
        tv = bindView(R.id.tv_forum_nice_catch_detail);
        iv.setOnClickListener(this);
    }

    @Override
    protected void initData() {
        Intent intent = getIntent();
        String url =  intent.getStringExtra("url");
        String title = intent.getStringExtra("title");
        tv.setText(title);
        // 与ForumPageForumBean 公用一个bean以及adapter
        GsonRequest<ForumPageForumBean> gsonRequest = new GsonRequest<ForumPageForumBean>(ForumPageForumBean.class, url, new Response.Listener<ForumPageForumBean>() {
            @Override
            public void onResponse(ForumPageForumBean response) {
                // 正确的话
                ForumPageForumAdapter adapter = new ForumPageForumAdapter();
                adapter.setForumPageForumBean(response);
                lv.setAdapter(adapter);
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
        switch (v.getId()){
            case R.id.iv_forum_nice_catch_detail_quit:
                finish();
                break;
        }
    }
}

