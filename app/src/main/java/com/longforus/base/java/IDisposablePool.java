package com.longforus.base.java;

import io.reactivex.disposables.Disposable;

/**
 * Created by XQ Yang on 2017/9/6  17:15.
 * Description : 连接池
 */

public interface IDisposablePool {
    void addDisposable(Disposable disposable);

    /**
     * 丢弃连接 在view销毁时调用
     */
    void clearPool();
}
