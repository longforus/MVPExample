package com.longforus.mvpexample.view

import android.content.Intent
import android.os.Bundle
import com.longforus.base.kotlin.BaseMvpActivity
import com.longforus.mvpexample.R
import com.longforus.mvpexample.contract.ILoginContract
import com.longforus.mvpexample.presenter.LoginPresenter
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Description :
 * @author  longforus
 * @date 2018/7/5  16:13
 * 								 - generate by MvpAutoCodePlus plugin.
 */

class LoginActivity : BaseMvpActivity(), ILoginContract.View {

    override fun gotoRegister() {
        startActivity(Intent(this, RegisterActivity::class.java))
    }

    override val contentViewId: Int = R.layout.activity_main
    override fun initListener() {

    }

    override fun initView(savedInstanceState: Bundle?) {
        tv.setOnClickListener {
            mPresenter.onTvClick()
        }
    }

    override var mPresenter: ILoginContract.Presenter = LoginPresenter()

}

