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
    Context context;
    private RecommendPageNiceCreatBean recommendPageNiceCreatBean;
    private CommonVH viewHolder;
    final int TYPE_1 = 1;
    final int TYPE_2 = 2;
//    final int TYPE_3 = 3;
//    final int TYPE_5 = 5;
//    final int TYPE_6 = 6;

    public RecommendPageNiceCreatAdapter(Context context) {
        this.context = context;
    }

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
       if (recommendPageNiceCreatBean.getResult().getNewslist().get(position).getMediatype() == 1) {
           return TYPE_1;
       } else if (recommendPageNiceCreatBean.getResult().getNewslist().get(position).getMediatype() == 2) {
           return TYPE_2;
       } else
           return TYPE_1;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
       switch (getItemViewType(position)) {
           case TYPE_1:
               viewHolder = CommonVH.getViewHolder(convertView,parent, R.layout.fragment_recommend_nicecreat_type_one);
               //TODO 布局没有写的说喵
               break;
           case TYPE_2:
               break;
       }
        return null;
    }
}
