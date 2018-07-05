package com.longforus.mvpexample.contract

import com.longforus.base.kotlin.IModel
import com.longforus.base.kotlin.IPresenter
import com.longforus.base.kotlin.IView

/**
 * Description :
 * @author  longforus
 * @date 2018/7/5  16:13
 * 								 - generate by MvpAutoCodePlus plugin.
 */

interface ILoginContract {
    interface View : IView<Presenter> {
        fun gotoRegister()
    }

    interface Presenter : IPresenter<View, Model> {
        fun onTvClick()
    }

    interface Model : IModel {
        fun getContent(): String
    }
}
