package com.example.dllo.carhome.recommend.speakinside;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.dllo.carhome.R;
import com.example.dllo.carhome.commonviewholder.CommonVH;

/**
 * Created by dllo on 16/11/3.
 */
public class RecommendPageSpeakAdapter extends BaseAdapter {

    private RecommendPageSpeakBean recommendPageSpeakBean;
    private CommonVH viewHolder;



    public void setRecommendPageSpeakBean(RecommendPageSpeakBean recommendPageSpeakBean) {
        this.recommendPageSpeakBean = recommendPageSpeakBean;
    }

    @Override
    public int getCount() {
        return recommendPageSpeakBean.getResult().getList().size();
    }

    @Override
    public Object getItem(int position) {
        return recommendPageSpeakBean.getResult().getList().get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
       viewHolder = CommonVH.getViewHolder(convertView,parent,R.layout.fragment_recommend_speak_type);
        viewHolder.setText(R.id.tv_recommend_speak_title,recommendPageSpeakBean.getResult().getList().get(position).getTitle())
                .setText(R.id.tv_recommend_speak_date,recommendPageSpeakBean.getResult().getList().get(position).getTime())
                .setText(R.id.tv_recommend_speak_replycount,recommendPageSpeakBean.getResult().getList().get(position).getReplycount() + "评论")
                .setImage(R.id.iv_recommend_speak_picture,recommendPageSpeakBean.getResult().getList().get(position).getSmallpic());
        return viewHolder.getItemView();
    }
}
