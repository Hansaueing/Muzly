package com.muzly.panye.login.signupinfo;

import android.support.annotation.NonNull;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.makeramen.roundedimageview.RoundedImageView;
import com.muzly.panye.login.dialog.ImageSelectorDialog;
import com.muzly.panye.module_login.R;
import com.muzly.panye.module_login.R2;
import com.muzly.panye.muzlylib.base.BaseMVPActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author Create by Payne
 * @date 2019/1/16  0:10
 */
public class SignUpInfoActivity extends BaseMVPActivity<SignUpInfoView, SignUpInfoPresenter> implements SignUpInfoView {


    @BindView(R2.id.iv_res_green_shadow_arrow_back)
    ImageView ivResGreenShadowArrowBack;
    @BindView(R2.id.riv_module_login_sign_up_info_photo)
    RoundedImageView rivModuleLoginSignUpInfoPhoto;
    @BindView(R2.id.ed_module_login_sign_up_info_email)
    EditText edModuleLoginSignUpInfoEmail;
    @BindView(R2.id.ed_module_login_sign_up_info_nickname)
    EditText edModuleLoginSignUpInfoNickname;
    @BindView(R2.id.iv_1)
    ImageView iv1;
    @BindView(R2.id.rl_module_login_sign_up_info_age)
    RelativeLayout rlModuleLoginSignUpInfoAge;
    @BindView(R2.id.tv_module_login_sign_up_info_gender_woman)
    TextView tvModuleLoginSignUpInfoGenderWoman;
    @BindView(R2.id.tv_module_login_sign_up_info_gender_man)
    TextView tvModuleLoginSignUpInfoGenderMan;
    @BindView(R2.id.iv_2)
    ImageView iv2;
    @BindView(R2.id.iv_3)
    ImageView iv3;
    @BindView(R2.id.bt_module_login_sign_up_info_continue)
    Button btModuleLoginSignUpInfoContinue;
    @BindView(R2.id.tv_module_login_sign_up_info_terms)
    TextView tvModuleLoginSignUpInfoTerms;
    @BindView(R2.id.tv_module_login_sign_up_info_and)
    TextView tvModuleLoginSignUpInfoAnd;
    @BindView(R2.id.tv_module_login_sign_up_info_privacy)
    TextView tvModuleLoginSignUpInfoPrivacy;

    @Override
    protected void setLayout() {
        setContentView(R.layout.module_login_sign_up_info_activity);
        ButterKnife.bind(this);
    }

    @Override
    protected void initView() {
        tvModuleLoginSignUpInfoAnd.setText(" & ");
    }

    @Override
    protected void init() {
        ivResGreenShadowArrowBack.setOnClickListener(this);
        rivModuleLoginSignUpInfoPhoto.setOnClickListener(this);
    }

    @Override
    protected void setViewListener() {

    }

    @Override
    protected void onClick(int id) {
        if (id == R.id.iv_res_green_shadow_arrow_back){
            finish();
        }else if (id == R.id.riv_module_login_sign_up_info_photo){
            new ImageSelectorDialog(this).show();
        }
    }

    @NonNull
    @Override
    public SignUpInfoPresenter createPresenter() {
        return new SignUpInfoPresenter(this);
    }

}
