package com.longforus.mvpexample.presenter

import android.widget.Toast
import com.longforus.mvpexample.contract.ILoginContract
import com.longforus.mvpexample.model.LoginModel

/**
 * Description :
 * @author  longforus
 * @date 2018/7/5  16:13
 * 								 - generate by MvpAutoCodePlus plugin.
 */

class LoginPresenter : ILoginContract.Presenter {
    override fun onTvClick() {
        Toast.makeText(getContext(), mModel?.getContent(), Toast.LENGTH_SHORT).show()
        mView?.gotoRegister()
    }

    override fun createModel(): ILoginContract.Model = LoginModel()
    override var mModel: ILoginContract.Model? = null
    override var mView: ILoginContract.View? = null
}

