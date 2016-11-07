package com.example.dllo.carhome.forum.recommendinside;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.dllo.carhome.R;
import com.example.dllo.carhome.commonviewholder.CommonVH;

/**
 * Created by dllo on 16/11/7.
 */
public class ForumPageHotAdapter extends BaseAdapter {
    private ForumPageHotBean forumPageHotBean;
    private CommonVH viewHolder;

    public void setForumPageHotBean(ForumPageHotBean forumPageHotBean) {
        this.forumPageHotBean = forumPageHotBean;
    }

    @Override
    public int getCount() {
        return forumPageHotBean.getResult().getList().size();
    }

    @Override
    public Object getItem(int position) {
        return forumPageHotBean.getResult().getList().get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        viewHolder = CommonVH.getViewHolder(convertView,parent, R.layout.activity_forum_hot_page_list_item);
        viewHolder.setText(R.id.tv_forum_hot_page_title,forumPageHotBean.getResult().getList().get(position).getTitle())
                .setText(R.id.tv_forum_hot_page_bbs,forumPageHotBean.getResult().getList().get(position).getBbsname())
                .setText(R.id.tv_forum_hot_page_reply,forumPageHotBean.getResult().getList().get(position).getReplycounts()+ "回")
                .setText(R.id.tv_forum_hot_page_time,forumPageHotBean.getResult().getList().get(position).getPostdate());
        return viewHolder.getItemView();
    }
}
