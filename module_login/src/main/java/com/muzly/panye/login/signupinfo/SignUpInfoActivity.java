package com.muzly.panye.login.signupinfo;

import android.support.annotation.NonNull;

import com.muzly.panye.module_login.R;
import com.muzly.panye.muzlylib.base.BaseMVPActivity;

/**
 * @author Create by Payne
 * @date 2019/1/16  0:10
 */
public class SignUpInfoActivity extends BaseMVPActivity<SignUpInfoView, SignUpInfoPresenter> implements SignUpInfoView{
    @Override
    protected void setLayout() {
        setContentView(R.layout.module_login_sign_up_info_activity);
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
    public SignUpInfoPresenter createPresenter() {
        return new SignUpInfoPresenter(this);
    }
}
