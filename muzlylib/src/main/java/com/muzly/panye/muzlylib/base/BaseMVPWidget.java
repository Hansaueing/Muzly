package com.muzly.panye.muzlylib.base;

import android.content.Context;

import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter;
import com.hannesdorfmann.mosby3.mvp.MvpView;
import com.trello.rxlifecycle2.LifecycleProvider;

/**
 * @描述
 * @作者 XGH
 * @日期 2018-12-17 18:09
 */
public abstract class BaseMVPWidget<View extends MvpView, Presenter extends MvpBasePresenter<View>> extends MvpWidget<View, Presenter> implements android.view.View.OnClickListener {
    protected Context context;
    public android.view.View contentView;
    protected LifecycleProvider provider;

    public BaseMVPWidget(Context context) {
        this.context = context;
    }

    public BaseMVPWidget(Context context, LifecycleProvider provider) {
        this.context = context;
        this.provider = provider;
    }

    public void setProvider(LifecycleProvider provider) {
        this.provider = provider;
    }

    protected void init() {
        loadViewLayout();
        initView();
        initData();
        setListener();
        processLogic();
    }

    /**
     * 为Activity加载布局文件的方法
     */
    protected abstract void loadViewLayout();

    /**
     * 寻找控件的方法
     */
    protected abstract void initView();

    /**
     * 初始化数据
     */
    protected abstract void initData();

    /**
     * 为控件设置监听
     */
    protected abstract void setListener();

    /**
     * 逻辑操作，数据请求
     */
    protected abstract void processLogic();

    /**
     * 点击事件
     *
     * @param id
     */
    protected abstract void onClick(int id);

    @Override
    public void onClick(android.view.View v) {
        onClick(v.getId());
    }

}
