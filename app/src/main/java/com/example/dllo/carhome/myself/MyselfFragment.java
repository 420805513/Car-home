package com.example.dllo.carhome.myself;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dllo.carhome.R;
import com.example.dllo.carhome.base.BaseFragment;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import cn.bmob.v3.BmobUser;

/**
 * Created by dllo on 16/10/24.
 */
public class MyselfFragment extends BaseFragment implements View.OnClickListener {
    private TextView tvName;
    private ImageView DP;
    @Override
    protected int getLayout() {
        return R.layout.fragment_myself;
    }

    @Override
    protected void initView() {
        tvName = bindView(R.id.tv_username);
        DP = bindView(R.id.iv_userpic);
        tvName.setOnClickListener(this);
        DP.setOnClickListener(this);
        EventBus.getDefault().register(this);

    }

    @Override
    protected void initData() {
        if(BmobUser.getObjectByKey("username" )!= null) {
            tvName.setText(BmobUser.getObjectByKey("username").toString());
        }
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_userpic:
                if (tvName.getText().equals("账号登录")) {
                    Intent intent = new Intent(getActivity(), LogAAccount.class);
                    startActivity(intent);
                }
                break;
            case R.id.tv_username:
                if (tvName.getText().equals("账号登录")) {
                    Intent intent1 = new Intent (getActivity(),LogAAccount.class);
                    startActivity(intent1);
                } else {
                    Intent intent2 = new Intent(getActivity(),UserInfo.class);
//                    intent2.putExtra("username",tvName.getText());
                    startActivity(intent2);
                }
                break;
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
    @Subscribe
    public void getLogName(LogEvent logEvent){
        if (logEvent.getUserName() != null){
            String str = logEvent.getUserName();
            tvName.setText(str);
        } else {
            tvName.setText("账号登录");
        }

    }
}
