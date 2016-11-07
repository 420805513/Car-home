package com.example.dllo.carhome.forum.recommendinside;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.dllo.carhome.R;
import com.example.dllo.carhome.commonviewholder.CommonVH;

/**
 * Created by dllo on 16/11/7.
 */
public class ForumPageForumAdapter extends BaseAdapter {
    private ForumPageForumBean forumPageForumBean;
    private CommonVH viewHolder;


    public void setForumPageForumBean(ForumPageForumBean forumPageForumBean) {
        this.forumPageForumBean = forumPageForumBean;
    }

    @Override
    public int getCount() {
        return forumPageForumBean.getResult().getList().size();
    }

    @Override
    public Object getItem(int position) {
        return forumPageForumBean.getResult().getList().get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        viewHolder = CommonVH.getViewHolder(convertView,parent, R.layout.fragment_forum_listview_type);
        viewHolder.setText(R.id.tv_listview_title_forum,forumPageForumBean.getResult().getList().get(position).getTitle())
                .setText(R.id.tv_listview_from_forum,forumPageForumBean.getResult().getList().get(position).getBbsname())
                .setText(R.id.tv_listview_replycount_forum,forumPageForumBean.getResult().getList().get(position).getReplycounts()+ "回帖")
                .setImage(R.id.iv_listview_picture_forum,forumPageForumBean.getResult().getList().get(position).getSmallpic());
        return viewHolder.getItemView();
    }
}
