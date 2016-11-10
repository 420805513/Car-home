package com.example.dllo.carhome.recommend;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.example.dllo.carhome.R;
import com.example.dllo.carhome.commonviewholder.CommonVH;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by dllo on 16/11/9.
 */
public class RecommendMoreAdapter extends RecyclerView.Adapter<CommonVH>{
    private CommonVH viewHolder;
    ArrayList<String> arrayList;


    public void setArrayList(ArrayList<String> arrayList) {
        this.arrayList = arrayList;
    }

    // 交换数据类里 指定位置的两条数据
    public void move(int from,int to) {
        // 交换
        Collections.swap(arrayList,from,to);
        notifyItemMoved(from,to);
    }
    @Override
    public CommonVH onCreateViewHolder(ViewGroup parent, int viewType) {
        viewHolder = CommonVH.getViewHolder(parent, R.layout.fragment_recommend_rv_item);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final CommonVH holder, final int position) {
       holder.setText(R.id.tv_recommend_more_rv,arrayList.get(position));
        holder.setItemClick(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().post(new PositionEvent(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

}
