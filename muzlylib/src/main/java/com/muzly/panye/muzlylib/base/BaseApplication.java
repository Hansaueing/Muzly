package com.muzly.panye.muzlylib.base;

import android.app.Application;

import com.alibaba.android.arouter.BuildConfig;
import com.alibaba.android.arouter.launcher.ARouter;
import com.blankj.utilcode.util.Utils;
import com.squareup.leakcanary.LeakCanary;
import com.yanzhenjie.nohttp.InitializationConfig;
import com.yanzhenjie.nohttp.NoHttp;

/**
 * Time: 2018-12-27 16:23
 * Author: payne
 **/
public class BaseApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        init();
    }

    private void init(){

        /*
        utilcode
         */
        Utils.init(this);

        /*
        ARouter
         */
        if (BuildConfig.DEBUG) {
            ARouter.openLog();
            ARouter.openDebug();
        }
        ARouter.init(this);

        /*
        NoHttp
         */
        NoHttp.initialize(InitializationConfig.newBuilder(this)
                .connectionTimeout(15 * 1000)
                .readTimeout(15 * 1000)
                .build());

        /*
        LeakCanary
         */
        if (LeakCanary.isInAnalyzerProcess(this)) {
            return;
        }
        LeakCanary.install(this);
    }
}
