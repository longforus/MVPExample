package com.longforus.mvpexample.model

import android.os.SystemClock
import com.longforus.base.java.DefaultDisposablePoolImpl
import com.longforus.mvpexample.contract.ITestContract
import io.reactivex.Observable

/**
 * Description :
 * @author  void
 * @date 8/20/2018  1:57 PM
 * 								 - generate by MvpAutoCodePlus plugin.
 */

class TestModel : DefaultDisposablePoolImpl(), ITestContract.Model {
    override fun getInfo(): Observable<String> {
        return Observable.create<String> { emitter ->
            SystemClock.sleep(800)
            emitter.onNext("这里是fragmnet")
            emitter.onComplete()
        }.doOnSubscribe {
            addDisposable(it)
        }
    }

}

