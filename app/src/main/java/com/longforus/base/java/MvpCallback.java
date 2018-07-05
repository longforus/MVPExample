package com.longforus.base.java;

import android.arch.lifecycle.LifecycleOwner;

/**
 * Created by XQ Yang on 2017/9/8  14:04.
 * Description : mvp模式抽象vp的解绑和绑定过程
 */

public interface MvpCallback<V extends IView & LifecycleOwner,P extends IPresenter<V>> {
    //创建Presenter  调用在init中
    P createPresenter();

    //创建View
    V createView();

    P getPresenter();

    void setPresenter(P presenter);

    V getMvpView();

    void setMvpView(V view);
}
