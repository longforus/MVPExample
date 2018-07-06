package com.longforus.mvpexample.presenter

import android.widget.Toast
import com.longforus.base.kotlin.BasePresenterKt
import com.longforus.mvpexample.contract.ILoginContract
import com.longforus.mvpexample.model.LoginModel
import com.longforus.utils.mySubscribe

/**
 * Description :
 * @author  longforus
 * @date 2018/7/5  16:13
 * 								 - generate by MvpAutoCodePlus plugin.
 */

class LoginPresenter : BasePresenterKt<ILoginContract.View>(), ILoginContract.Presenter {

    override val mModel: ILoginContract.Model by lazy { LoginModel() }

    override fun onTvClick() {
        mModel.getContent().mySubscribe {
            Toast.makeText(getContext(), it, Toast.LENGTH_SHORT).show()
        }
        mView?.gotoRegister()
    }
}

