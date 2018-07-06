package com.longforus.base.kotlin

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import butterknife.ButterKnife
import butterknife.Unbinder
import com.longforus.utils.LogUtils
import java.lang.ref.WeakReference

/**
 * 顶级Fragment
 */

abstract class BaseFragment : Fragment(), ITopView {
    protected var mActivity: Activity? = null
    protected var mRootView: WeakReference<View>? = null
    private var mUnbinder: Unbinder? = null
    private var inited = false

    @get:LayoutRes
    protected abstract val layoutId: Int

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == FRAGMENT_REQUEST_REFRESH_KEY && resultCode == Activity.RESULT_OK) {
            onRefresh()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mActivity = activity
        init(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var mFragmentView: View? = null
        if (mRootView == null || mRootView!!.get() == null) {
            inited = false
            mFragmentView = inflater.inflate(layoutId, container, false)
            mRootView = WeakReference(mFragmentView)
        } else {
            val parent = mRootView!!.get()?.parent as ViewGroup?
            parent?.removeView(mRootView!!.get())
            mFragmentView = mRootView!!.get()
        }
        mUnbinder = ButterKnife.bind(this, mFragmentView!!)
        return mRootView!!.get()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        if (!inited) {
            val rootView = mRootView!!.get()
            rootView?.let {
                initView(it, savedInstanceState)
                initListener()
                inited()
                inited = true
            }
        }
    }


    override fun onResume() {
        super.onResume()
        if (LogUtils.sLogSwitch) {
            LogUtils.d("current", "(((((((((((っ･ω･)っ Σ(σ｀･ω･´)σ 起飞！fragment :" + javaClass.name + "    (～o￣▽￣)～o 。。。滚来滚去……o～(＿△＿o～) ~。。。 ")
            if (arguments != null) {
                LogUtils.d("current", arguments!!.toString())
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        if (mUnbinder != null) {
            mUnbinder!!.unbind()
            mUnbinder = null
        }
        mActivity = null
    }

    /**
     * mFragmentView创建完成后,初始化具体的view 只会调用一次
     */
    protected abstract fun initView(rootView: View, savedInstanceState: Bundle?)

    /**
     * 初始话事件监听
     */
    protected abstract fun initListener()

    /**
     * view 创建之前 获取intent数据等
     */
    protected abstract fun init(savedInstanceState: Bundle?)

    /**
     * 请求回来刷新时调用
     */
    fun onRefresh() {

    }

    companion object {
        val FRAGMENT_REQUEST_REFRESH_KEY = 54541
    }
}
