package com.example.dllo.carhome.recommend;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.example.dllo.carhome.R;
import com.example.dllo.carhome.base.BaseActivity;
import com.example.dllo.carhome.commonviewholder.CommonVH;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;

import javax.security.auth.Destroyable;

/**
 * Created by dllo on 16/10/27.
 */
public class RecommendMoreActivity extends BaseActivity implements View.OnClickListener {
    private ImageView iv;
    private RecyclerView rv;
    private String [] titles = {"推荐","优创+","说客","视频","快报","行情","新闻","评测","导购","用车","技术","文化","改装"};
    private RecommendMoreAdapter adapter;

    @Override
    protected int getLayout() {
        return R.layout.activity_recommend_more;
    }

    @Override
    protected void initViews() {
        iv =bindView(R.id.iv_recommend_more_quit);
        iv.setOnClickListener(this);
        rv =bindView(R.id.rv_recommend_more);
        EventBus.getDefault().register(this);
    }

    @Override
    protected void initData() {
        adapter = new RecommendMoreAdapter();
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < titles.length; i++) {
            arrayList.add(titles[i]);
        }
        ItemTouchHelper.Callback callback = mCallback();
        ItemTouchHelper helper = new ItemTouchHelper(callback);
        helper.attachToRecyclerView(rv);
        adapter.setArrayList(arrayList);
        rv.setAdapter(adapter);

        GridLayoutManager manager = new GridLayoutManager(this,3);
        rv.setLayoutManager(manager);




    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_recommend_more_quit:
                finish();
                break;
        }
    }
    private ItemTouchHelper.Callback mCallback() {
        return new ItemTouchHelper.Callback() {
            @Override
            public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
                return ItemTouchHelper.Callback.makeMovementFlags(ItemTouchHelper.UP|ItemTouchHelper.DOWN|
                        ItemTouchHelper.START|ItemTouchHelper.END,0);
            }

            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                int from = viewHolder.getAdapterPosition();
                int to = target.getAdapterPosition();
                adapter.move(from,to);
                return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                // 滑动

            }

            @Override
            public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int actionState) {
                super.onSelectedChanged(viewHolder, actionState);
                if (actionState != ItemTouchHelper.ACTION_STATE_IDLE) {
                    // 当前Item的状态不为空闲的时候
                    View view = viewHolder.itemView;
                    view.setBackgroundColor(0xFFFF0000); // 把背景设置成红色
                }
            }

            @Override
            public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
                super.clearView(recyclerView, viewHolder);
                // 当Item的状态空闲时
                viewHolder.itemView.setBackgroundColor(0xFFFFFFFF);
            }
        };
    }
    @Subscribe
    public void finishPage(PositionEvent positionEvent) {
        if (positionEvent.getI() >= 0) {
            Intent intent = new Intent();
            intent.putExtra("position",positionEvent.getI());
            setResult(101,intent);
            finish();
            Log.d("RecommendMoreActivity", "positionEvent.getI():" + positionEvent.getI());
        }
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
