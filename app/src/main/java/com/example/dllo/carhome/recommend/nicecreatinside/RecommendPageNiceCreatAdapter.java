package com.example.dllo.carhome.recommend.nicecreatinside;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.dllo.carhome.R;
import com.example.dllo.carhome.commonviewholder.CommonVH;

/**
 * Created by dllo on 16/11/2.
 */
public class RecommendPageNiceCreatAdapter extends BaseAdapter {

    private RecommendPageNiceCreatBean recommendPageNiceCreatBean;
    private CommonVH viewHolder;
    final int TYPE_1 = 1;
    final int TYPE_2 = 2;


    public void setRecommendPageNiceCreatBean(RecommendPageNiceCreatBean recommendPageNiceCreatBean) {
        this.recommendPageNiceCreatBean = recommendPageNiceCreatBean;
    }

    @Override
    public int getCount() {
        return recommendPageNiceCreatBean.getResult().getNewslist().size();
    }

    @Override
    public Object getItem(int position) {
        return recommendPageNiceCreatBean.getResult().getNewslist().get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public int getItemViewType(int position) {
       if (recommendPageNiceCreatBean.getResult().getNewslist().get(position).getMediatype() == 3) {
           return TYPE_1;
       } else if (recommendPageNiceCreatBean.getResult().getNewslist().get(position).getMediatype() == 1) {
           return TYPE_2;
       } else
           return TYPE_1;
    }

    @Override
    public int getViewTypeCount() {
        return 4;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
       switch (getItemViewType(position)) {
           case TYPE_1:
               viewHolder = CommonVH.getViewHolder(convertView,parent, R.layout.fragment_recommend_nicecreat_type_one);
               viewHolder.setImage(R.id.iv_recommend_nc_user,recommendPageNiceCreatBean.getResult().getNewslist().get(position).getUserpic())
                       .setText(R.id.tv_recommend_nc_user,recommendPageNiceCreatBean.getResult().getNewslist().get(position).getUsername())
                       .setText(R.id.tv_recommend_nc_detail,recommendPageNiceCreatBean.getResult().getNewslist().get(position).getTitle())
                       .setImage(R.id.tv_recommend_nc_big_pic,recommendPageNiceCreatBean.getResult().getNewslist().get(position).getIndexdetail().get(0));
               break;
           case TYPE_2:
               viewHolder = CommonVH.getViewHolder(convertView,parent,R.layout.fragment_recommend_nicecreat_type_two);
               viewHolder.setImage(R.id.iv_recommend_nc_user1,recommendPageNiceCreatBean.getResult().getNewslist().get(position).getUserpic())
                       .setText(R.id.tv_recommend_nc_user1,recommendPageNiceCreatBean.getResult().getNewslist().get(position).getUsername())
                       .setText(R.id.tv_recommend_nc_detail1,recommendPageNiceCreatBean.getResult().getNewslist().get(position).getTitle())
                       .setImage(R.id.tv_recommend_nc_big_pic1,recommendPageNiceCreatBean.getResult().getNewslist().get(position).getIndexdetail().get(0));
               break;
       }
        return viewHolder.getItemView();
    }
}
