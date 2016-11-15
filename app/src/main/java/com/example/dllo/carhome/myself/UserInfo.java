package com.example.dllo.carhome.myself;


import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dllo.carhome.R;
import com.example.dllo.carhome.base.BaseActivity;


import org.greenrobot.eventbus.EventBus;

import cn.bmob.v3.BmobUser;


/**
 * Created by dllo on 16/11/15.
 */
public class UserInfo extends BaseActivity implements View.OnClickListener {
    private ImageView IVBack;
    private TextView TVUserName;
    private LinearLayout quit;

    @Override
    protected int getLayout() {
        return R.layout.activity_myself_user_information;
    }

    @Override
    protected void initViews() {
        IVBack = bindView(R.id.iv_myself_info_back);
        TVUserName = bindView(R.id.tv_myself_info_user_name);
        quit = bindView(R.id.ll_myself_user_quit);
        IVBack.setOnClickListener(this);
        quit.setOnClickListener(this);

    }

    @Override
    protected void initData() {
        String username = (String) BmobUser.getObjectByKey("username");
        TVUserName.setText(username);

        }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_myself_info_back:
                finish();
                break;
            case R.id.ll_myself_user_quit:
                BmobUser.logOut(); // 退出
                Toast.makeText(this, "成功退出了喵", Toast.LENGTH_SHORT).show();
                LogEvent event = new LogEvent(null,null);
                EventBus.getDefault().post(event);
                finish();
                break;
        }
    }
}
