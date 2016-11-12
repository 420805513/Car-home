package com.example.dllo.carhome.found;

import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.example.dllo.carhome.R;
import com.example.dllo.carhome.commonviewholder.CommonVH;
import com.example.dllo.carhome.found.FoundFragmentBean.ResultBean.CardlistBean.DataBean;

import java.util.List;

/**
 * Created by dllo on 16/11/12.
 */
public class FoundModeAdapter extends RecyclerView.Adapter<CommonVH>{
    private List<DataBean> datas;
    public void setDatas(List<DataBean> datas) {
        this.datas = datas;
    }

    @Override
    public CommonVH onCreateViewHolder(ViewGroup parent, int viewType) {
        CommonVH viewHolder = CommonVH.getViewHolder(parent, R.layout.rv_found_mode_item);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CommonVH holder, int position) {
        holder.setImage(R.id.iv_found_fragment_mode,datas.get(position).getImageurl())
                .setText(R.id.tv_found_fragment_mode_name,datas.get(position).getTitle())
                .setText(R.id.tv_found_fragment_mode_detail,datas.get(position).getSubtitle())
                .setText(R.id.tv_found_fragment_mode_new_price,datas.get(position).getCurrentprice())
                .setText(R.id.tv_found_fragment_mode_old_price,datas.get(position).getPrice(), Paint.STRIKE_THRU_TEXT_FLAG|Paint.ANTI_ALIAS_FLAG);

    }

    @Override
    public int getItemCount() {
        return datas.size();
    }
}
