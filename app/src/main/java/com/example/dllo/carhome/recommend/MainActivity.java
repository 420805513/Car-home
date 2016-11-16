package com.example.dllo.carhome.recommend;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.dllo.carhome.R;
import com.example.dllo.carhome.base.BaseActivity;
import com.example.dllo.carhome.choosecar.ChooseCarFragment;
import com.example.dllo.carhome.forum.ForumFragment;
import com.example.dllo.carhome.found.FoundFragment;
import com.example.dllo.carhome.myself.MyselfFragment;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends BaseActivity implements View.OnClickListener{
    // MainActivity 进行界面的跳转
    private RadioButton main_btn_recommend,main_btn_forum,main_btn_choosecar,main_btn_found,main_btn_myself;
    private FragmentManager manager;
    private boolean isExit = false;
//    private FragmentTransaction transaction;
    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initViews() {
        manager = getSupportFragmentManager();
        findID();
        setClick();

    }

    @Override
    protected void initData() {
        firstPage();


    }


    @Override
    public void onClick(View v) {
//        manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        switch (v.getId()) {
            case R.id.main_btn_recommend:
                transaction.replace(R.id.main_view, new RecommendFragment());
                break;
            case R.id.main_btn_forum:
                transaction.replace(R.id.main_view,new ForumFragment());
                break;
            case R.id.main_btn_choosecar:
                transaction.replace(R.id.main_view,new ChooseCarFragment());
                break;
            case R.id.main_btn_found:
                transaction.replace(R.id.main_view,new FoundFragment());
                break;
            case R.id.main_btn_myself:
                transaction.replace(R.id.main_view,new MyselfFragment());
                break;
        }
        transaction.commit();
    }

    private void findID() {
        main_btn_recommend = bindView(R.id.main_btn_recommend);
        main_btn_forum = bindView(R.id.main_btn_forum);
        main_btn_choosecar = bindView(R.id.main_btn_choosecar);
        main_btn_found = bindView(R.id.main_btn_found);
        main_btn_myself = bindView(R.id.main_btn_myself);
        main_btn_recommend.setChecked(true);
    }
    private void setClick(){
        setClick(this,main_btn_recommend,main_btn_forum,main_btn_choosecar,main_btn_found,main_btn_myself);
    }
    private void firstPage() {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.main_view, new RecommendFragment());
        transaction.commit();

    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode== KeyEvent.KEYCODE_BACK){
            exitByDoubleClick();
        }
        return false;
    }

    private void exitByDoubleClick() {
        Timer tExit =  null;
        if(!isExit){
            isExit=true;
            Toast.makeText(MainActivity.this,"再按一次退出程序", Toast.LENGTH_SHORT).show();
            tExit =new Timer();
            tExit.schedule(new TimerTask() {
                @Override
                public void run() {
                    isExit = false;
                }
            },2000);
        }else{
            finish();
            System.exit(0);
        }
    }
}
