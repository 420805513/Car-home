package com.example.dllo.carhome.recommend;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;

import com.example.dllo.carhome.R;
import com.example.dllo.carhome.base.BaseFragment;
import com.example.dllo.carhome.recommend.recommendsearchpart.RecommendSearchActivity;

/**
 * Created by dllo on 16/10/24.
 */
public class RecommendFragment extends BaseFragment implements View.OnClickListener {
    private ViewPager vp;
    private TabLayout tb;
    private ImageView iv,search;
    String [] titles = {"推荐","优创+","说客","视频","快报","行情","新闻","评测","导购","用车","技术","文化","改装"};

    @Override
    protected int getLayout() {
        return R.layout.fragment_recommend;
    }

    @Override
    protected void initView() {
        vp = bindView(R.id.vp_recommend);
        tb = bindView(R.id.tb_recommend);
        iv = bindView(R.id.iv_more);
        search = bindView(R.id.iv_recommend_sreach);
        iv.setOnClickListener(this);
        search.setOnClickListener(this);

        RecommendFragmentAdapter adapter = new RecommendFragmentAdapter(getChildFragmentManager(), titles);
        vp.setAdapter(adapter);
        tb.setupWithViewPager(vp);


    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_more:
                Intent intent = new Intent(getActivity(),RecommendMoreActivity.class);
                startActivityForResult(intent,100);
                break;
            case R.id.iv_recommend_sreach:
                Intent intent1 = new Intent (getActivity(),RecommendSearchActivity.class);
                startActivity(intent1);
                break;
        }
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == 101){
            int pos = data.getIntExtra("position",-1);
            if(pos != -1){
                vp.setCurrentItem(pos);
            }
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

    }

}
