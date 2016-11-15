package com.example.dllo.carhome.myself;

import android.content.Intent;
import android.util.EventLog;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.dllo.carhome.R;
import com.example.dllo.carhome.base.BaseActivity;

import org.greenrobot.eventbus.EventBus;

import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

/**
 * Created by dllo on 16/11/14.
 */
public class UserRegister extends BaseActivity implements View.OnClickListener {
    private EditText username,password,passwordCheck;
    private Button btn;
    private ImageView ivBack;
    @Override
    protected int getLayout() {
        return R.layout.activity_myself_register;
    }

    @Override
    protected void initViews() {
        username = bindView(R.id.et_register_username);
        password = bindView(R.id.et_register_password);
        passwordCheck = bindView(R.id.et_register_password_check);
        ivBack = bindView(R.id.iv_myself_register_back);
        ivBack.setOnClickListener(this);
        btn = bindView(R.id.btn_user_to_register);
        btn.setOnClickListener(this);

    }

    @Override
    protected void initData() {


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_myself_register_back:
                finish();
                break;
            case R.id.btn_user_to_register:
                final String str = username.getText().toString();
                final String str1 = password.getText().toString();
                String str2 = passwordCheck.getText().toString();
                if (str == null) {
                    Toast.makeText(this, "用户名为空", Toast.LENGTH_SHORT).show();
                } else if ( !str1.equals(str2) || str1 == null || str2 == null) {
                    Toast.makeText(this, "请检查您两次输入的密码", Toast.LENGTH_SHORT).show();
                } else if(str != null && str1 != null && str2 != null && str1.equals(str2)) {
                    BmobUser user = new BmobUser();
                    user.setUsername(str);
                    user.setPassword(str1);
                    user.signUp(new SaveListener<BmobUser>() {
                        @Override
                        public void done(BmobUser bmobUser, BmobException e) {
                            if (e == null){
                                Toast.makeText(UserRegister.this, "注册成功,可以进行登录了", Toast.LENGTH_SHORT).show();
                                finish();

                            } else {
                                Log.d("UserRegister", "e:" + e);
                            }
                        }
                    });
                }
                break;
        }

    }
}
