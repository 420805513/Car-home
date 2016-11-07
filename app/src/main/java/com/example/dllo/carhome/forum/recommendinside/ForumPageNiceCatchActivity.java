package com.example.dllo.carhome.forum.recommendinside;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.dllo.carhome.R;
import com.example.dllo.carhome.base.BaseActivity;
import com.example.dllo.carhome.forum.ForumFragment;

/**
 * Created by dllo on 16/11/7.
 */
public class ForumPageNiceCatchActivity extends BaseActivity implements View.OnClickListener {
    private ImageView iv;
    private ListView lv;
    @Override
    protected int getLayout() {
        return R.layout.activity_forum_nice_catch_more;
    }

    @Override
    protected void initViews() {
        iv = bindView(R.id.iv_forum_nice_catch_quit);
        lv = bindView(R.id.lv_forum_nice_catch_listView);
        iv.setOnClickListener(this);
    }

    @Override
    protected void initData() {
        ForumPageNiceCatchListViewAdapter forumPageNiceCatchListViewAdapter = new ForumPageNiceCatchListViewAdapter();
        lv.setAdapter(forumPageNiceCatchListViewAdapter);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_forum_nice_catch_quit:
                finish();
                break;

        }
    }

}
