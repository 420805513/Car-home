package com.example.dllo.carhome.found;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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
    private FoundFragmentBean foundFragmentBean;
    private final static int TYPE_FOCUS = 0; // 轮播图
    private final static int TYPE_ENTRANCE = 1; // 业务接口
    private final static int TYPE_TIME = 2; // 图文时限专区
//    private final static int TYPE_SMALL_LINE = 3; // 单帧小号横栏
    private final static int TYPE_LIMTE_TIME = 3; // 限时抢购
    private final static int TYPE_FIELD = 4; // 田字小号专区
    private final static int TYPE_ACT = 5; // 活动专区
    private final static int TYPE_MODE = 6; // 模块列表
    private final static int TYPE_PRODUCE = 7; // 商品列表

    public void setFoundFragmentBean(FoundFragmentBean foundFragmentBean) {
        this.foundFragmentBean = foundFragmentBean;
        notifyDataSetChanged();
    }

    @Override
    public CommonVH onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType){
            case TYPE_FOCUS: // 轮播图
            CommonVH focusVH = CommonVH.getViewHolder(parent,R.layout.item_found_focus);
                Log.d("aaa", "0");
                return focusVH;
            case TYPE_ENTRANCE: // 业务接口
                CommonVH entranceVH =  CommonVH.getViewHolder(parent,R.layout.item_found_entrance);
                Log.d("aaa", "1");
                return entranceVH;
            case TYPE_TIME : // 图文限时专区
                CommonVH timeVH = CommonVH.getViewHolder(parent,R.layout.item_found_time);
                Log.d("aaa", "2");
                return timeVH;
//            case TYPE_SMALL_LINE: // 单帧小号横栏
//                CommonVH smallLineVH = CommonVH.getViewHolder(parent,R.layout.item_found_small_line);
//                Log.d("aaa", "3");
//                return smallLineVH;
            case TYPE_LIMTE_TIME: // 限时抢购
                CommonVH limteTimeVH = CommonVH.getViewHolder(parent,R.layout.item_found_limte_time);
                Log.d("aaa", "3");
                return limteTimeVH;
            case TYPE_FIELD: // 田字小号专区
                CommonVH fieldVH = CommonVH.getViewHolder(parent,R.layout.item_found_field);
                Log.d("aaa", "4");
                return fieldVH;
            case TYPE_ACT: // 活动专区
                CommonVH actVH = CommonVH.getViewHolder(parent,R.layout.item_found_act);
                Log.d("aaa", "5");
                return actVH;
            case TYPE_MODE: // 模块列表
                CommonVH modeVH = CommonVH.getViewHolder(parent,R.layout.item_found_mode);
                Log.d("aaa", "6");
                return modeVH;
            case TYPE_PRODUCE: // 商品列表
                Log.d("aaa", "7");
                CommonVH produceVH = CommonVH.getViewHolder(parent,R.layout.item_found_produce);
                return produceVH;
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
            case TYPE_ENTRANCE: // 业务接口
                FoundEntranceAdapter adapter = new FoundEntranceAdapter();
                // 强转果然失败了
                adapter.setFoundFragmentBean(foundFragmentBean);
                holder.setRecyclerView(1,R.id.rv_found_entrance,adapter, LinearLayoutManager.HORIZONTAL);
                break;
            case TYPE_TIME: // 图文限时
                FoundTimeAdapter adapter1 = new FoundTimeAdapter();
                adapter1.setFoundFragmentBean(foundFragmentBean);
                holder.setRecyclerView(1,R.id.rv_found_time,adapter1,LinearLayoutManager.HORIZONTAL);
                break;
//            case TYPE_SMALL_LINE: // 小号单帧(就是一张图片
//                holder.setImage(R.id.iv_found_fragment_small_line,foundFragmentBean.getResult().getCardlist().get(position).getData().get(0).getImageurl());
//                break;
            case TYPE_LIMTE_TIME: // 限时抢购
                FoundLimteTimeAdapter adapter2 = new FoundLimteTimeAdapter();
                adapter2.setFoundFragmentBean(foundFragmentBean);
                holder.setRecyclerView(1,R.id.rv_found_limte_time,adapter2,LinearLayoutManager.HORIZONTAL);
                break;
            case TYPE_FIELD: // 田字小号
                FoundFieldAdapter adapter3 = new FoundFieldAdapter();
                adapter3.setFoundFragmentBean(foundFragmentBean);
                holder.setRecyclerView(2,R.id.rv_found_field,adapter3,LinearLayoutManager.VERTICAL);
                break;
            case TYPE_ACT: // 活动专区
                holder.setImage(R.id.iv_found_fragment_act_1,foundFragmentBean.getResult().getCardlist().get(position).getData().get(0).getImageurl())
                        .setImage(R.id.iv_found_fragment_act_2,foundFragmentBean.getResult().getCardlist().get(position).getData().get(1).getImageurl())
                        .setImage(R.id.iv_found_fragment_act_3,foundFragmentBean.getResult().getCardlist().get(position).getData().get(2).getImageurl());
                break;
            case TYPE_MODE: // 模块列表
                FoundModeAdapter adapter4 = new FoundModeAdapter();
                adapter4.setDatas(foundFragmentBean.getResult().getCardlist().get(position).getData());
                holder.setRecyclerView(2,R.id.rv_found_mode,adapter4,LinearLayoutManager.VERTICAL);
                holder.setText(R.id.tv_found_fragment_mode,foundFragmentBean.getResult().getCardlist().get(position).getTitle());
                break;
            case TYPE_PRODUCE: // 商品列表
                FoundProduceAdapter adapter5 = new FoundProduceAdapter();
                adapter5.setDatas(foundFragmentBean.getResult().getCardlist().get(position).getData());
                holder.setRecyclerView(1,R.id.rv_found_produce,adapter5,LinearLayoutManager.VERTICAL)
                        .setText(R.id.tv_found_fragment_produce,foundFragmentBean.getResult().getCardlist().get(position).getTitle());
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

}
