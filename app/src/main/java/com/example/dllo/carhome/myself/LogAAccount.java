package com.example.dllo.carhome.myself;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dllo.carhome.R;
import com.example.dllo.carhome.base.BaseActivity;

/**
 * Created by dllo on 16/11/14.
 */
public class LogAAccount extends BaseActivity implements View.OnClickListener {
    private EditText account,password;
    private ImageView back;
    private TextView register;

    @Override
    protected int getLayout() {
        return R.layout.activity_meself_log_a_account;
    }

    @Override
    protected void initViews() {
        account = bindView(R.id.et_account);
        account = bindView(R.id.et_password);
        register = bindView(R.id.tv_myself_register);
        register.setOnClickListener(this);
        back = bindView(R.id.iv_myself_log_back);
        back.setOnClickListener(this);

    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_myself_log_back:
                finish();
                break;
            case R.id.tv_myself_register:
                Intent intent = new Intent(LogAAccount.this,UserRegister.class);
                startActivity(intent);
                break;
        }
    }
}
