package com.longforus.base.java;

import android.os.Bundle;
import android.support.annotation.CallSuper;

import com.longforus.base.kotlin.BaseFragment;

/**
 * Created by XQ Yang on 2017/9/8  11:10.
 * Description : 基础的mvp Fragment
 */

public abstract class BaseMvpFragment<V extends IView,P extends IPresenter<V>> extends BaseFragment implements MvpCallback<V,P> {

    protected P mPresenter;
    protected V mView;

    @Override
    public void onDestroy() {
        super.onDestroy();
        setMvpView(null);
        setPresenter(null);
    }

    @CallSuper
    @Override
    protected void initListener() {
        mPresenter.attachView(getMvpView());//在这个时候才attach view是因为这个时候view的初始化已经基本完成,在Presenter中调用view的域也不会为空
    }

    @CallSuper
    @Override
    protected void init(Bundle savedInstanceState) {
        mView = createView();
        if (getPresenter() == null) {
            mPresenter = createPresenter();
            getLifecycle().addObserver(mPresenter);
        }
    }

    @Override
    public P getPresenter() {
        return mPresenter;
    }

    @Override
    public void setPresenter(P presenter) {
        this.mPresenter = presenter;
    }

    @Override
    public V getMvpView() {
        return this.mView;
    }

    @Override
    public void setMvpView(V view) {
        this.mView = view;
    }
}
