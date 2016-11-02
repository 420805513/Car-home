package com.example.dllo.carhome.recommend;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.dllo.carhome.R;
import com.example.dllo.carhome.gsonandvolley.VolleySingleton;
import com.example.dllo.carhome.recommend.listviewandinside.RecommendPageListViewBean;
import com.jude.rollviewpager.RollPagerView;
import com.jude.rollviewpager.adapter.LoopPagerAdapter;

import java.util.ArrayList;

/**
 * Created by dllo on 16/11/1.
 */
public class LoopAdapter extends LoopPagerAdapter{
    private RecommendPageListViewBean recommendPageListViewBean;

    public void setRecommendPageListViewBean(RecommendPageListViewBean recommendPageListViewBean) {
        this.recommendPageListViewBean = recommendPageListViewBean;
    }

    public LoopAdapter(RollPagerView viewPager) {
            super(viewPager);

        }




        @Override
        public View getView(ViewGroup container, int position) {
            ImageView view = new ImageView(container.getContext());
            VolleySingleton.getInstance().getImage(recommendPageListViewBean.getResult().getFocusimg().get(position).getImgurl(),view);
            view.setScaleType(ImageView.ScaleType.CENTER_CROP);
            view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            return view;
        }

        @Override
        public int getRealCount() {
            return recommendPageListViewBean.getResult().getFocusimg().size();
        }
    }

