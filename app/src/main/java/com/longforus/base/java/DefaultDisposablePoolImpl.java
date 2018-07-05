package com.longforus.base.java;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Description :实现了连接丢弃
 *
 * @author XQ Yang
 * @date 2018/6/19  13:45
 */
public class DefaultDisposablePoolImpl implements IDisposablePool {
    private CompositeDisposable mDisposable;

    @Override
    public void addDisposable(Disposable disposable) {
        if (mDisposable == null) {
            mDisposable = new CompositeDisposable(disposable);
        } else {
            mDisposable.add(disposable);
        }
    }

    @Override
    public void clearPool() {
        if (mDisposable != null) {
            mDisposable.clear();
            mDisposable = null;
        }
    }
}
