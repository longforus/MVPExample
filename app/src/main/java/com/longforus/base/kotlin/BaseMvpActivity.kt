package com.longforus.base.kotlin

import android.content.Context

/**
 * Created by XQ Yang on 2017/9/8  11:10.
 * Description : mvp的基础 Activity
 */

abstract class BaseMvpActivity : BaseActivity(), ILoadingDialogView {

    override fun showLoadDialog(msg: String) {
        //显示读取dialog
    }

    override fun dismissLoadDialog() {
        //隐藏读取dialog
    }

    override fun getContext(): Context {
        return this
    }

    fun finish(result: Int) {
        setResult(result)
        finish()
    }

}
