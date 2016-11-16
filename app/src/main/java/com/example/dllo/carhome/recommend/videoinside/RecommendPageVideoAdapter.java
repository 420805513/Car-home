package com.example.dllo.carhome.recommend.videoinside;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.dllo.carhome.R;
import com.example.dllo.carhome.commonviewholder.CommonVH;

/**
 * Created by dllo on 16/11/16.
 */
public class RecommendPageVideoAdapter extends BaseAdapter {
    private RecommendPageVideoBean recommendPageVideoBean;
    private CommonVH viewHolder;

    public void setRecommendPageVideoBean(RecommendPageVideoBean recommendPageVideoBean) {
        this.recommendPageVideoBean = recommendPageVideoBean;
    }

    @Override
    public int getCount() {
        return recommendPageVideoBean.getResult().getList().size();
    }

    @Override
    public Object getItem(int position) {
        return recommendPageVideoBean.getResult().getList().get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        viewHolder = CommonVH.getViewHolder(convertView,parent, R.layout.fragment_recommend_video_item);
        viewHolder.setImage(R.id.iv_recommend_video_pic,recommendPageVideoBean.getResult().getList().get(position).getSmallimg())
                .setText(R.id.tv_recommend_video_title,recommendPageVideoBean.getResult().getList().get(position).getTitle());
        return viewHolder.getItemView();
    }
}
