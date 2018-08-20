package com.longforus.mvpexample.contract

import com.longforus.base.java.IModel
import com.longforus.base.java.IPresenter
import com.longforus.base.java.IView
import io.reactivex.Observable

/**
 * Description : 测试kotlin下使用Java父接口和父类
 * @author  void
 * @date 8/20/2018  1:57 PM
 * 								 - generate by MvpAutoCodePlus plugin.
 */

interface ITestContract {
    interface View : IView {
        fun setInfo(info :String)
    }
    interface Presenter : IPresenter<View> {

    }
    interface Model : IModel {
        fun getInfo():Observable<String>
    }
}
