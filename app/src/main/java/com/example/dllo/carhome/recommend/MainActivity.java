package com.example.dllo.carhome.recommend;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

import com.example.dllo.carhome.R;
import com.example.dllo.carhome.base.BaseActivity;

import java.util.ArrayList;

public class MainActivity extends BaseActivity implements View.OnClickListener{
    // MainActivity 进行界面的跳转
    private RadioButton main_btn_recommend,main_btn_forum,main_btn_choosecar,main_btn_found,main_btn_myself;
    private FragmentManager manager;
    private FragmentTransaction transaction;
    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initViews() {
        findID();
        setClick();
    }

    @Override
    protected void initData() {

    }


    @Override
    public void onClick(View v) {
        manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();

    }

    private void findID() {
        main_btn_recommend = bindView(R.id.main_btn_recommend);
        main_btn_forum = bindView(R.id.main_btn_forum);
        main_btn_choosecar = bindView(R.id.main_btn_choosecar);
        main_btn_found = bindView(R.id.main_btn_found);
        main_btn_myself = bindView(R.id.main_btn_myself);
    }
    private void setClick(){
        setClick(this,main_btn_recommend);
        setClick(this,main_btn_forum);
        setClick(this,main_btn_choosecar);
        setClick(this,main_btn_found);
        setClick(this,main_btn_myself);
    }
}
