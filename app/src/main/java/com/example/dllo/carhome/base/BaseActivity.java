package com.example.dllo.carhome.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.RadioButton;

import com.example.dllo.carhome.recommend.MainActivity;

/**
 * Created by dllo on 16/10/21.
 */
public abstract class BaseActivity extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        initViews();
        initData();
    }
    // 绑定布局
    protected abstract int getLayout();
    // 初始化组件
    protected abstract void initViews();
    // 初始化数据, 基本上就是 拉取网络数据
    protected abstract void initData();
    // 简化findViewById 省去强转的过程
    protected <T extends View> T bindView(int id) {
        return (T) findViewById(id);
    }
    // 点击事件
    protected void setClick(View.OnClickListener clickListener,
                            View...views){
        for (View view :views){
            view.setOnClickListener(clickListener);
        }
    }

}
