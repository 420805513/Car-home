package com.example.dllo.carhome.recommend.newsinside;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.dllo.carhome.R;
import com.example.dllo.carhome.commonviewholder.CommonVH;

/**
 * Created by dllo on 16/11/3.
 */
public class RecommendPageNewsAdapter extends BaseAdapter {

    private RecommendPageNewsBean recommendPageNewsBean;
    private CommonVH viewHolder;


    public void setRecommendPageNewsBean(RecommendPageNewsBean recommendPageNewsBean) {
        this.recommendPageNewsBean = recommendPageNewsBean;
    }

    @Override
    public int getCount() {
        return recommendPageNewsBean.getResult().getNewslist().size();
    }

    @Override
    public Object getItem(int position) {
        return recommendPageNewsBean.getResult().getNewslist().get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        viewHolder = CommonVH.getViewHolder(convertView,parent, R.layout.fragment_recommend_news_type);
        viewHolder.setText(R.id.tv_recommend_news_title,recommendPageNewsBean.getResult().getNewslist().get(position).getTitle())
                .setText(R.id.tv_recommend_news_date,recommendPageNewsBean.getResult().getNewslist().get(position).getTime())
                .setText(R.id.tv_recommend_news_replycount,recommendPageNewsBean.getResult().getNewslist().get(position).getReplycount() + "评论")
                .setImage(R.id.iv_recommend_news_picture,recommendPageNewsBean.getResult().getNewslist().get(position).getSmallpic());
        return viewHolder.getItemView();
    }
}
