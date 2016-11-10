package com.example.dllo.carhome.found;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;

import com.example.dllo.carhome.R;
import com.example.dllo.carhome.commonviewholder.CommonVH;
import com.youth.banner.BannerConfig;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/11/10.
 */
public class FoundFragmentAdapter extends RecyclerView.Adapter<CommonVH> {
    private CommonVH viewHolder;
    private FoundFragmentBean foundFragmentBean;
    private int width,height;
    private final static int TYPE_FOCUS = 0; // 轮播图
    private final static int TYPE_ENTRANCE = 1; // 业务接口
    private final static int TYPE_TIME = 2; // 图文时限专区
    private final static int TYPE_SMALL_LINE = 3; // 单帧小号横栏
    private final static int TYPE_LIMTE_TIME = 4; // 限时抢购
    private final static int TYPE_FIELD = 5; // 田字小号专区
    private final static int TYPE_ACT = 6; // 活动专区
    private final static int TYPE_MODE = 7; // 模块列表
    private final static int TYPE_PRODUCE = 8; // 商品列表

    public void setFoundFragmentBean(FoundFragmentBean foundFragmentBean) {
        this.foundFragmentBean = foundFragmentBean;
        notifyDataSetChanged();
    }

    @Override
    public CommonVH onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType){
            case TYPE_FOCUS: // 轮播图
            CommonVH focusVH = CommonVH.getViewHolder(parent,R.layout.item_found_focus);
                return focusVH;
            default:
                return null;


        }

    }

    @Override
    public void onBindViewHolder(CommonVH holder, int position) {
        switch (getItemViewType(position)){
            case TYPE_FOCUS: // 轮播图
                List<String> imgUrls = new ArrayList<>();
                for (int i = 0; i < foundFragmentBean.getResult().getCardlist().get(position).getData().size(); i++) {
                        imgUrls.add(foundFragmentBean.getResult().getCardlist().get(position).getData().get(i).getImageurl());
                }
                holder.setBanner(R.id.found_banner, BannerConfig.CIRCLE_INDICATOR_TITLE,imgUrls,BannerConfig.CENTER,2500);
                break;
            default:
                break;
        }

    }

    @Override
    public int getItemCount() {
        return foundFragmentBean.getResult().getCardlist().size();
    }

    @Override
    public int getItemViewType(int position) {
        return foundFragmentBean.getResult().getCardlist().get(position).getType();
    }

    @Override
    public void onViewAttachedToWindow(CommonVH holder) {
        super.onViewAttachedToWindow(holder);
        View view = holder.itemView;
        TranslateAnimation translateAnimation = new TranslateAnimation(200,0,0,0);
        translateAnimation.setDuration(300);
        view.setAnimation(translateAnimation);
        translateAnimation.start();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);

    }
}
