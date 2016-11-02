package com.example.dllo.carhome.recommend.recommendinside;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.dllo.carhome.R;
import com.example.dllo.carhome.commonviewholder.CommonVH;

import java.util.Arrays;
import java.util.List;

/**
 * Created by dllo on 16/10/27.
 * ListView的Adapter
 */
public class RecommendPageListViewAdapter extends BaseAdapter {
    Context context;
    private RecommendPageListViewBean recommendPageListViewBean;

    final int TYPE_1 = 1;
    final int TYPE_2 = 2;
    final int TYPE_3 = 3;
    final int TYPE_5 = 5;
    final int TYPE_6 = 6;
    private CommonVH viewHolder;

    public RecommendPageListViewAdapter(Context context) {
        this.context = context;
    }

    public void setRecommendPageListViewBean(RecommendPageListViewBean recommendPageListViewBean) {
        this.recommendPageListViewBean = recommendPageListViewBean;
    }

    @Override
    public int getCount() {
        return recommendPageListViewBean.getResult().getNewslist().size();
    }

    @Override
    public Object getItem(int position) {
        return recommendPageListViewBean.getResult().getNewslist().get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        if (recommendPageListViewBean.getResult().getNewslist().get(position).getMediatype() == 1) {
            return TYPE_1;
        } else if(recommendPageListViewBean.getResult().getNewslist().get(position).getMediatype() == 2)
         {
             return TYPE_2;
        } else if (recommendPageListViewBean.getResult().getNewslist().get(position).getMediatype() == 3) {
            return TYPE_3;
        } else if (recommendPageListViewBean.getResult().getNewslist().get(position).getMediatype() == 5) {
            return TYPE_5;
        } else if (recommendPageListViewBean.getResult().getNewslist().get(position).getMediatype() == 6){
            return TYPE_6;
        }else
            return TYPE_1;

    }

    @Override
    public int getViewTypeCount() {
        return 10;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        switch (getItemViewType(position)) {
            case TYPE_1:
                viewHolder = CommonVH.getViewHolder(convertView, parent, R.layout.fragment_recommend_listview_type_one);
                viewHolder.setText(R.id.tv_listview_title_t1, recommendPageListViewBean.getResult().getNewslist().get(position).getTitle())
                        .setText(R.id.tv_listview_replycount_t1, recommendPageListViewBean.getResult().getNewslist().get(position).getReplycount() + "评论")
                        .setText(R.id.tv_listview_date_t1, recommendPageListViewBean.getResult().getNewslist().get(position).getTime())
                        .setImage(R.id.iv_listview_picture_t1, recommendPageListViewBean.getResult().getNewslist().get(position).getSmallpic());

            break;

            case TYPE_2:
                viewHolder = CommonVH.getViewHolder(convertView,parent,R.layout.fragment_recommend_listview_type_two);
                viewHolder.setText(R.id.tv_listview_title_t2,recommendPageListViewBean.getResult().getNewslist().get(position).getTitle())
                        .setText(R.id.tv_listview_replycount_t2,recommendPageListViewBean.getResult().getNewslist().get(position).getReplycount() + "回帖")
                        .setText(R.id.tv_listview_date_t2,recommendPageListViewBean.getResult().getNewslist().get(position).getTime())
                        .setImage(R.id.iv_listview_picture_t2,recommendPageListViewBean.getResult().getNewslist().get(position).getSmallpic());
            break;
            case TYPE_3:
                viewHolder = CommonVH.getViewHolder(convertView,parent,R.layout.fragment_recommend_listview_type_three);
                viewHolder.setText(R.id.tv_listview_title_t3,recommendPageListViewBean.getResult().getNewslist().get(position).getTitle())
                        .setText(R.id.tv_listview_replycount_t3,recommendPageListViewBean.getResult().getNewslist().get(position).getReplycount() + "播放")
                        .setText(R.id.tv_listview_date_t3,recommendPageListViewBean.getResult().getNewslist().get(position).getTime())
                        .setImage(R.id.iv_listview_picture_t3,recommendPageListViewBean.getResult().getNewslist().get(position).getSmallpic());
                break;
            case TYPE_5:
                viewHolder = CommonVH.getViewHolder(convertView,parent,R.layout.fragment_recommend_listview_type_five);
                viewHolder.setText(R.id.tv_listview_title_t5,recommendPageListViewBean.getResult().getNewslist().get(position).getTitle())
                        .setText(R.id.tv_listview_replycount_t5,recommendPageListViewBean.getResult().getNewslist().get(position).getReplycount() + "回帖")
                        .setText(R.id.tv_listview_date_t5,recommendPageListViewBean.getResult().getNewslist().get(position).getTime())
                        .setImage(R.id.iv_listview_picture_t5,recommendPageListViewBean.getResult().getNewslist().get(position).getSmallpic());
                break;
            case TYPE_6:
                viewHolder = CommonVH.getViewHolder(convertView,parent,R.layout.fragment_recommend_listview_type_six);
                List<String> list = getallpic(recommendPageListViewBean.getResult().getNewslist().get(position).getIndexdetail());
                viewHolder.setText(R.id.tv_listview_title_t6,recommendPageListViewBean.getResult().getNewslist().get(position).getTitle())
                        .setText(R.id.tv_listview_replycount_t6,recommendPageListViewBean.getResult().getNewslist().get(position).getReplycount() + "评论")
                        .setText(R.id.tv_listview_date_t6,recommendPageListViewBean.getResult().getNewslist().get(position).getTime())
                        .setImage(R.id.iv_listview_picture_t6_1,list.get(0))
                        .setImage(R.id.iv_listview_picture_t6_2,list.get(1))
                        .setImage(R.id.iv_listview_picture_t6_3,list.get(2));
                Log.d("RecommendPageListViewAd", list.get(0));
                Log.d("RecommendPageListViewAd", list.get(1));
             break;
        }


        return viewHolder.getItemView();

}

    public static List<String> getallpic(String str) {
        String str1 = str.substring(11,str.length());
        String[] strs = str1.split(",");
        List<String> list = Arrays.asList(strs);
        return list;
    }
}
