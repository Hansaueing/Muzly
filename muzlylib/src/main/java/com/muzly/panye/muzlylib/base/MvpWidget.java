package com.muzly.panye.muzlylib.base;

import android.support.annotation.NonNull;

import com.hannesdorfmann.mosby3.mvp.MvpPresenter;
import com.hannesdorfmann.mosby3.mvp.MvpView;
import com.hannesdorfmann.mosby3.mvp.delegate.MvpDelegateCallback;

/**
 * @描述
 * @作者 XGH
 * @日期 2018-12-17 18:06
 */
public abstract class MvpWidget<V extends MvpView, P extends MvpPresenter<V>> implements MvpDelegateCallback<V, P>, MvpView   {

    protected P presenter;

    @NonNull
    @Override public P getPresenter() {
        return presenter;
    }

    @Override public void setPresenter(@NonNull P presenter) {
        this.presenter = presenter;
    }

    @NonNull @Override public V getMvpView() {
        return (V) this;
    }


}
