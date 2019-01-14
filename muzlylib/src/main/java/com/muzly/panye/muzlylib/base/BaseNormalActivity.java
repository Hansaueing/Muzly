package com.muzly.panye.muzlylib.base;

import android.app.ActivityManager;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.KeyEvent;
import android.view.View;

import com.alibaba.android.arouter.launcher.ARouter;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

public abstract class BaseNormalActivity extends RxAppCompatActivity implements View.OnClickListener {
    protected Context context;

    private Dialog loadingDialog;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;

        setLayout();
        initView();
        init();
        setViewListener();
        processLogic();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            default:
                break;
        }
        onClick(v.getId());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    protected abstract void setLayout();

    protected abstract void initView();

    protected abstract void init();

    protected abstract void setViewListener();

    protected void processLogic() {
    }

    protected abstract void onClick(int id);

    /**
     * 设置界面方向，默认竖屏
     * SCREEN_ORIENTATION_LANDSCAPE：横屏
     */
    protected void setScreenOrientation() {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    protected void restartApp() {
        ARouter.getInstance()
                .build("/app/start")
                .withInt("app_status", 1)
                .navigation();
    }

    protected void error(String errorMsg) {

    }

    protected void loading() {
        loadingDialog.show();
    }

    protected void cancelLoading() {
        loadingDialog.dismiss();
    }

    /**
     * @描述 钱箱按钮被点击
     */
    protected void onCashKeyDown() {

    }




    /**
     * Activity截获按键事件.发给 BarcodeScannerResolver
     */
    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        return super.dispatchKeyEvent(event);
    }

    /**
     * 退出应用
     */
    public void closeApplication() {
        int currentVersion = Build.VERSION.SDK_INT;
        if (currentVersion > Build.VERSION_CODES.ECLAIR_MR1) {
            Intent startMain = new Intent(Intent.ACTION_MAIN);
            startMain.addCategory(Intent.CATEGORY_HOME);
            startMain.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(startMain);
            android.os.Process.killProcess(android.os.Process.myPid());
            System.exit(0);
        } else {// android2.1 及之前版本
            ActivityManager am = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
            am.restartPackage(getPackageName());
        }
    }
}
