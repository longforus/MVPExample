package com.longforus.base.kotlin

import io.reactivex.disposables.CompositeDisposable

/**
 * Description :
 * @author  XQ Yang
 * @date 2018/7/6  10:45
 */
open class BaseModelKt {
    val mDisposablePool: CompositeDisposable by lazy { CompositeDisposable() }
}