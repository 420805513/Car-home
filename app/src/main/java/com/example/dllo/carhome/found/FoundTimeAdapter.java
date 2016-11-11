package com.example.dllo.carhome.found;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.example.dllo.carhome.R;
import com.example.dllo.carhome.commonviewholder.CommonVH;

/**
 * Created by dllo on 16/11/11.
 */
public class FoundTimeAdapter extends RecyclerView.Adapter<CommonVH> {
    private FoundFragmentBean foundFragmentBean;

    public void setFoundFragmentBean(FoundFragmentBean foundFragmentBean) {
        this.foundFragmentBean = foundFragmentBean;
    }

    @Override
    public CommonVH onCreateViewHolder(ViewGroup parent, int viewType) {
        CommonVH viewHolder = CommonVH.getViewHolder(parent, R.layout.rv_found_time_item);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CommonVH holder, int position) {
        holder.setImage(R.id.iv_found_fragment_time,foundFragmentBean.getResult().getCardlist().get(2).getData().get(position).getImageurl())
                .setText(R.id.tv_found_fragment_time_name,foundFragmentBean.getResult().getCardlist().get(2).getData().get(position).getTitle())
                .setText(R.id.tv_found_fragment_time_price,foundFragmentBean.getResult().getCardlist().get(2).getData().get(position).getSubtitle());

    }

    @Override
    public int getItemCount() {
        return foundFragmentBean.getResult().getCardlist().get(2).getData().size();
    }
}
