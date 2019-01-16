package com.muzly.panye.login.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;

import com.muzly.panye.module_login.R;

/**
 * @author Create by Payne
 * @date 2019/1/17  0:56
 */
public class ImageSelectorDialog extends Dialog {

    public ImageSelectorDialog(@NonNull Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.module_login_sign_up_image_selector);
    }
}
