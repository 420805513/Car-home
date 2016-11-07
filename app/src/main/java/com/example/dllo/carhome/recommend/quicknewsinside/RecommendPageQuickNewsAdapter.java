package com.example.dllo.carhome.recommend.quicknewsinside;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.dllo.carhome.R;
import com.example.dllo.carhome.commonviewholder.CommonVH;

/**
 * Created by dllo on 16/11/3.
 */
public class RecommendPageQuickNewsAdapter extends BaseAdapter {

    private RecommendPageQuickNewsBean recommendPageQuickNewsBean;
    private CommonVH viewHolder;


    public void setRecommendPageQuickNewsBean(RecommendPageQuickNewsBean recommendPageQuickNewsBean) {
        this.recommendPageQuickNewsBean = recommendPageQuickNewsBean;
    }

    @Override
    public int getCount() {
        return recommendPageQuickNewsBean.getResult().getList().size();
    }

    @Override
    public Object getItem(int position) {
        return recommendPageQuickNewsBean.getResult().getList().get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        viewHolder = CommonVH.getViewHolder(convertView,parent,R.layout.fragment_recommend_quicknews_type);
        viewHolder.setText(R.id.tv_recommend_quicknews_title,recommendPageQuickNewsBean.getResult().getList().get(position).getTitle())
                .setText(R.id.tv_recommend_quicknews_date,recommendPageQuickNewsBean.getResult().getList().get(position).getCreatetime())
                .setText(R.id.tv_recommend_quicknews_replycount,recommendPageQuickNewsBean.getResult().getList().get(position).getReviewcount() + "观众")
                .setImage(R.id.iv_recommend_quicknews_picture,recommendPageQuickNewsBean.getResult().getList().get(position).getBgimage());

        return viewHolder.getItemView();
    }
}
