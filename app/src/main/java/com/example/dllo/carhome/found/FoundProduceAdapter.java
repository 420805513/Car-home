package com.example.dllo.carhome.found;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.example.dllo.carhome.R;
import com.example.dllo.carhome.commonviewholder.CommonVH;
import com.example.dllo.carhome.found.FoundFragmentBean.ResultBean.CardlistBean.DataBean;

import java.util.List;

/**
 * Created by dllo on 16/11/12.
 */
public class FoundProduceAdapter extends RecyclerView.Adapter<CommonVH>{
    private List<DataBean> datas;

    public void setDatas(List<DataBean> datas) {
        this.datas = datas;
    }

    @Override
    public CommonVH onCreateViewHolder(ViewGroup parent, int viewType) {
        CommonVH viewHolder = CommonVH.getViewHolder(parent, R.layout.rv_found_produce_item);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CommonVH holder, int position) {
        holder.setImage(R.id.iv_found_fragment_produce,datas.get(position).getLogo())
                .setText(R.id.tv_found_fragment_produce_title,datas.get(position).getTitle())
                .setText(R.id.tv_found_fragment_produce_subtitle,datas.get(position).getAdinfo())
                .setText(R.id.tv_found_fragment_produce_price,datas.get(position).getPrice());
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }
}
