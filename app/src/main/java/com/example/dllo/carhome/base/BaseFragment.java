package com.example.dllo.carhome.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dllo.carhome.R;

/**
 * Created by dllo on 16/10/24.
 */
public abstract class BaseFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(getLayout(),container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }
    // 自身view
    private <T extends View> T bindView(int id) {
        return (T) getView().findViewById(id);
    }
    // 其他view
    private <T extends View> T bindView(View view,int id) {
        return (T) view.findViewById(id);
    }

    protected  abstract  int getLayout();

    protected abstract void initView();

    protected abstract void initData();


}