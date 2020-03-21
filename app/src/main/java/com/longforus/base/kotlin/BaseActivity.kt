package com.longforus.base.kotlin

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v7.app.AppCompatActivity
import com.longforus.utils.ActivityStack
import com.longforus.utils.LogUtils

/**
 * activity公共基类
 */

abstract class BaseActivity : AppCompatActivity(), ITopView {
    protected lateinit var mActivity: Activity


    @LayoutRes
    abstract fun getLayoutId(): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mActivity = this
        ActivityStack.getInstance().pushActivity(this)
        baseInit(savedInstanceState)
        initView(savedInstanceState)
        initListener()
        inited()
    }

    /**
     * 基础初始化 绑定黄油刀,  使用binding的复写 不绑
     */
    protected open fun baseInit(savedInstanceState: Bundle?) {
        setContentView(getLayoutId())
    }


    protected abstract fun initView(savedInstanceState: Bundle?)

    protected abstract fun initListener()

    override fun onStop() {
        super.onStop()
        if (isFinishing) {
            ActivityStack.getInstance().removeActivity(this)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_REFRESH_KEY && resultCode == Activity.RESULT_OK) {
            onRefresh()
        }
    }

    override fun onResume() {
        super.onResume()
        if (LogUtils.sLogSwitch) {
            LogUtils.d("current", "(((((((((((っ･ω･)っ Σ(σ｀･ω･´)σ 起飞！activity : " + javaClass.name + "   _(:3 」∠)_ -･･*'``*:.｡. .｡.:*･゜ﾟ･*☆")
            if (intent != null && intent.extras != null) {
                LogUtils.d("current", intent.extras.toString())
            }
        }
    }

    /**
     * 请求回来刷新时调用
     */
    fun onRefresh() {

    }

    companion object {
        val REQUEST_REFRESH_KEY = 51541
    }
}
