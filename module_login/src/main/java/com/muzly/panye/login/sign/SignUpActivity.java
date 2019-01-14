package com.muzly.panye.login.sign;

import android.support.annotation.NonNull;
import android.view.Window;

import com.muzly.panye.module_login.R;
import com.muzly.panye.muzlylib.base.BaseMVPActivity;

/**
 * @author Create by Payne
 * @date 2019/1/14  23:29
 */
public class SignUpActivity extends BaseMVPActivity<SignUpView,SignUpPresenter> implements SignUpView {
    @Override
    protected void setLayout() {
        setContentView(R.layout.module_login_sign_up_activity);
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void init() {

    }

    @Override
    protected void setViewListener() {

    }

    @Override
    protected void onClick(int id) {

    }

    @NonNull
    @Override
    public SignUpPresenter createPresenter() {
        return new SignUpPresenter(this);
    }
}
