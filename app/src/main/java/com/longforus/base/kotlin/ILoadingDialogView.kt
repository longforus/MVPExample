/*
 * Copyright (c) 18-2-1 下午1:58. XQ Yang
 */

package com.longforus.base.kotlin

/**
 * @author XQ Yang
 * @date 2017/11/15  11:40
 */
interface ILoadingDialogView {
    fun dismissLoadDialog()

    fun showLoadDialog(msg: String)
}
