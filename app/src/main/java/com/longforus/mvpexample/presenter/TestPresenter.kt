package com.longforus.mvpexample.presenter

import com.longforus.base.java.BasePresenterJv
import com.longforus.mvpexample.contract.ITestContract
import com.longforus.mvpexample.model.TestModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Description :
 * @author  void
 * @date 8/20/2018  1:57 PM
 * 								 - generate by MvpAutoCodePlus plugin.
 */

class TestPresenter : BasePresenterJv<ITestContract.View, ITestContract.Model>(), ITestContract.Presenter {
    override fun createModel(): ITestContract.Model = TestModel()

    override fun attachView(view: ITestContract.View?) {
        super.attachView(view)
        mModel.getInfo().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe {
            mView.setInfo(it)
        }
    }

}

