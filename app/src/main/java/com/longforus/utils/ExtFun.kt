package com.longforus.utils

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers

/**
 * Description :
 * @author  XQ Yang
 * @date 2018/7/6  11:02
 */

fun <T> Observable<T>.mySubscribe(onError: ((Throwable) -> Unit)? = null, onSuccess: (T) -> Unit) {
    this.subscribeOn(io.reactivex.schedulers.Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe({ onSuccess.invoke(it) }, { onError?.invoke(it) })
}