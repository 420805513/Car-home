package com.example.dllo.carhome.myself;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dllo.carhome.R;
import com.example.dllo.carhome.base.BaseActivity;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

/**
 * Created by dllo on 16/11/14.
 */
public class LogAAccount extends BaseActivity implements View.OnClickListener {
    private EditText account,password;
    private ImageView back;
    private TextView register;
    private Button btnLogin;

    @Override
    protected int getLayout() {
        return R.layout.activity_meself_log_a_account;
    }
    @Override
    protected void initViews() {
        EventBus.getDefault().register(this);
        btnLogin = bindView(R.id.btn_myself_login);
        btnLogin.setOnClickListener(this);
        account = bindView(R.id.et_account);
        password = bindView(R.id.et_password);
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
            case R.id.btn_myself_login:
                if (account.getText().toString() != null && password.getText().toString() != null){
                    BmobUser bmobUser = new BmobUser();
                    bmobUser.setUsername(account.getText().toString());
                    bmobUser.setPassword(password.getText().toString());
                    bmobUser.login(new SaveListener<BmobUser>() {
                        @Override
                        public void done(BmobUser bmobUser, BmobException e) {
                            if(e == null) {
                                LogEvent event = new LogEvent(account.getText().toString(),null);
                                EventBus.getDefault().post(event);
                                Log.d("UserRegister", event.getUserName());
                                Toast.makeText(LogAAccount.this, "登录成功了喵", Toast.LENGTH_SHORT).show();
                                finish();
                            } else if(e.getErrorCode() == 101){
                                Toast.makeText(LogAAccount.this, "账号密码输入错误了喵", Toast.LENGTH_SHORT).show();
                            } else {
                                Log.d("LogAAccount", "e:" + e);
                            }
                        }
                    });
                } else {
                    Toast.makeText(this, "账号密码不要为空", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);

    }
    @Subscribe
    public void getEvent(LogEvent event){
        account.setText(event.getUserName());
        password.setText(event.getUserPassword());
    }
}
