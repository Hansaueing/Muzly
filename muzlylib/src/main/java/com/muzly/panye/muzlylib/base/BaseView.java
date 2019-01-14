package com.muzly.panye.muzlylib.base;

import com.hannesdorfmann.mosby3.mvp.MvpView;

public interface BaseView extends MvpView {

    void error(String errorMsg);

    void loading();

    void cancelLoading();

}
