package com.muzly.panye.muzlylib.base;

import android.app.ActivityManager;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.CheckResult;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.KeyEvent;

import com.alibaba.android.arouter.launcher.ARouter;
import com.hannesdorfmann.mosby3.mvp.MvpActivity;
import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter;
import com.hannesdorfmann.mosby3.mvp.MvpView;
import com.trello.rxlifecycle2.LifecycleProvider;
import com.trello.rxlifecycle2.LifecycleTransformer;
import com.trello.rxlifecycle2.RxLifecycle;
import com.trello.rxlifecycle2.android.ActivityEvent;
import com.trello.rxlifecycle2.android.RxLifecycleAndroid;

import io.reactivex.Observable;
import io.reactivex.subjects.BehaviorSubject;

public abstract class BaseMVPActivity<View extends MvpView, Presenter extends MvpBasePresenter<View>> extends MvpActivity<View, Presenter> implements LifecycleProvider<ActivityEvent>, BaseView, android.view.View.OnClickListener {
    protected Context context;
    private final BehaviorSubject<ActivityEvent> lifecycleSubject = BehaviorSubject.create();

    private Dialog loadingDialog;

    @NonNull
    @Override
    public final Observable<ActivityEvent> lifecycle() {
        return lifecycleSubject.hide();
    }

    @Override
    @NonNull
    @CheckResult
    public final <T> LifecycleTransformer<T> bindUntilEvent(@NonNull ActivityEvent event) {
        return RxLifecycle.bindUntilEvent(lifecycleSubject, event);
    }

    @Override
    @NonNull
    @CheckResult
    public final <T> LifecycleTransformer<T> bindToLifecycle() {
        return RxLifecycleAndroid.bindActivity(lifecycleSubject);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        //        setScreenOrientation();
        setLayout();
        initView();
        init();
        setViewListener();
        processLogic();
    }

    @Override
    protected void onStart() {
        super.onStart();
        lifecycleSubject.onNext(ActivityEvent.START);
    }

    @Override
    protected void onResume() {
        super.onResume();
        lifecycleSubject.onNext(ActivityEvent.RESUME);
    }

    @Override
    protected void onPause() {
        lifecycleSubject.onNext(ActivityEvent.PAUSE);
        super.onPause();
    }

    @Override
    protected void onStop() {
        lifecycleSubject.onNext(ActivityEvent.STOP);
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        lifecycleSubject.onNext(ActivityEvent.DESTROY);
        super.onDestroy();
    }


    @Override
    public void onClick(android.view.View v) {
        switch (v.getId()) {

            default:
                break;
        }
        onClick(v.getId());
    }

    protected abstract void setLayout();

    protected abstract void initView();

    protected abstract void init();

    protected abstract void setViewListener();

    protected void processLogic() {
    }

    ;

    protected abstract void onClick(int id);

    /**
     * 设置界面方向，默认横屏
     * SCREEN_ORIENTATION_LANDSCAPE：横屏
     */
    protected void setScreenOrientation() {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
    }

    @Override
    public void error(String errorMsg) {

    }

    @Override
    public void loading() {
        loadingDialog.show();
    }

    @Override
    public void cancelLoading() {
        loadingDialog.dismiss();
    }

    /**
     * @描述 钱箱按钮被点击
     */
    protected void onCashKeyDown() {

    }

    protected void restartApp() {
        ARouter.getInstance()
                .build("/app/start")
                .withInt("app_status", 1)
                .navigation();
    }


    /**
     * 扫码枪是输入设备，检测是否有外接输入设备.(这样判断其实并不严格)
     */
    private boolean hasScanGun() {
        Configuration cfg = getResources().getConfiguration();
        return cfg.keyboard != Configuration.KEYBOARD_NOKEYS;
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
