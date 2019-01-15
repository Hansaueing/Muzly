package com.muzly.panye.login.sign;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;

import com.blankj.utilcode.util.LogUtils;
import com.muzly.panye.login.signupinfo.SignUpInfoActivity;
import com.muzly.panye.login.signupinfo.SignUpInfoView;
import com.muzly.panye.module_login.R;
import com.muzly.panye.module_login.R2;
import com.muzly.panye.muzlylib.base.BaseMVPActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * @author Create by Payne
 * @date 2019/1/14  23:29
 */
public class SignUpActivity extends BaseMVPActivity<SignUpView, SignUpPresenter> implements SignUpView {


    @BindView(R2.id.btn_module_login_sign_up)
    Button btnModuleLoginSignUp;
    @BindView(R2.id.btn_module_login_sign_in)
    Button btnModuleLoginSignIn;

    @Override
    protected void setLayout() {
        setContentView(R.layout.module_login_sign_up_activity);
        ButterKnife.bind(this);
    }

    @Override
    protected void initView() {
    }

    @Override
    protected void init() {
    }

    @Override
    protected void setViewListener() {
        btnModuleLoginSignIn.setOnClickListener(this);
        btnModuleLoginSignUp.setOnClickListener(this);
    }

    @Override
    protected void onClick(int id) {
        if (id == R.id.btn_module_login_sign_up) {
            Intent intent = new Intent(this, SignUpInfoActivity.class);
            startActivity(intent);
        } else if (id == R.id.btn_module_login_sign_in) {
            LogUtils.i("btn_module_login_sign_in");
        }
    }

    @NonNull
    @Override
    public SignUpPresenter createPresenter() {
        return new SignUpPresenter(this);
    }

}
