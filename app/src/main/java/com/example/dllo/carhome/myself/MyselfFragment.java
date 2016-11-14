package com.example.dllo.carhome.myself;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dllo.carhome.R;
import com.example.dllo.carhome.base.BaseFragment;

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
        // TODO 点击事件跳转登录界面

    }

    @Override
    protected void initData() {


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_userpic:
                Intent intent = new Intent (getActivity(),LogAAccount.class);
                startActivity(intent);
                break;
            case R.id.tv_username:
                Intent intent1 = new Intent (getActivity(),LogAAccount.class);
                startActivity(intent1);
                break;

        }
    }
}
