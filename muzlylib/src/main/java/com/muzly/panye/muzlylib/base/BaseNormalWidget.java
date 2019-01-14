package com.muzly.panye.muzlylib.base;

import android.content.Context;
import android.view.View;

import com.trello.rxlifecycle2.LifecycleProvider;

/**
 * 页面View基类
 * Created by Administrator on 2016/9/20.
 */
public abstract class BaseNormalWidget implements View.OnClickListener {
    protected Context context;
    public View contentView;
    protected LifecycleProvider provider;

    public BaseNormalWidget(Context context) {
        this.context = context;
    }

    public BaseNormalWidget(Context context, LifecycleProvider provider) {
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
    public void onClick(View v) {
        onClick(v.getId());
    }
}
