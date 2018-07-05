package com.longforus.mvpexample.model

import com.longforus.mvpexample.contract.ILoginContract
import io.reactivex.disposables.CompositeDisposable

/**
 * Description :
 * @author  longforus
 * @date 2018/7/5  16:13
 * 								 - generate by MvpAutoCodePlus plugin.
 */

class LoginModel : ILoginContract.Model {
    override fun getContent(): String = "来自LoginModel"

    override val mDisposablePool: CompositeDisposable by lazy { CompositeDisposable() }
}

