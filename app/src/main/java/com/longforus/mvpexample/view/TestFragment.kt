package com.longforus.mvpexample.view

import android.os.Bundle
import android.view.View
import com.longforus.base.java.BaseMvpFragment
import com.longforus.mvpexample.R
import com.longforus.mvpexample.contract.ITestContract
import com.longforus.mvpexample.presenter.TestPresenter
import kotlinx.android.synthetic.main.fragment_test.*

/**
 * Description :
 * @author  void
 * @date 8/20/2018  1:57 PM
 * 								 - generate by MvpAutoCodePlus plugin.
 */

class TestFragment : BaseMvpFragment<ITestContract.View, ITestContract.Presenter>(), ITestContract.View {
    override fun setInfo(info: String) {
       tv_info.text = info
    }

    override fun createPresenter(): ITestContract.Presenter = TestPresenter()

    override fun createView(): ITestContract.View  = this

    override fun initListener() {

    }

    override fun initView(rootView: View, savedInstanceState: Bundle?) {

    }


    override fun getLayoutId(): Int = R.layout.fragment_test

}

