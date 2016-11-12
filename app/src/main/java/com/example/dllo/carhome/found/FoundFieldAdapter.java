package com.example.dllo.carhome.found;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.example.dllo.carhome.R;
import com.example.dllo.carhome.commonviewholder.CommonVH;

/**
 * Created by dllo on 16/11/11.
 */
public class FoundFieldAdapter extends RecyclerView.Adapter<CommonVH>{
    private FoundFragmentBean foundFragmentBean;

    public void setFoundFragmentBean(FoundFragmentBean foundFragmentBean) {
        this.foundFragmentBean = foundFragmentBean;
    }

    @Override
    public CommonVH onCreateViewHolder(ViewGroup parent, int viewType) {
        CommonVH viewHolder = CommonVH.getViewHolder(parent, R.layout.rv_found_field_item);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CommonVH holder, int position) {
        holder.setImage(R.id.iv_found_fragment_field,foundFragmentBean.getResult().getCardlist().get(4).getData().get(position).getImageurl());

    }

    @Override
    public int getItemCount() {
        return foundFragmentBean.getResult().getCardlist().get(4).getData().size();
    }
}
