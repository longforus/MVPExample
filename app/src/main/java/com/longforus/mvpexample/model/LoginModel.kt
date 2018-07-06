package com.longforus.mvpexample.model

import android.os.SystemClock
import com.longforus.base.kotlin.BaseModelKt
import com.longforus.mvpexample.contract.ILoginContract
import io.reactivex.Observable
import io.reactivex.ObservableOnSubscribe

/**
 * Description :
 * @author  longforus
 * @date 2018/7/5  16:13
 * 								 - generate by MvpAutoCodePlus plugin.
 */

class LoginModel : BaseModelKt(), ILoginContract.Model {
    override fun getContent() = Observable.create(ObservableOnSubscribe<String> { e ->
        run {
            SystemClock.sleep(500)
            e.onNext("来自LoginModel")
            e.onComplete()
        }
    })
}

