package com.longforus.base.kotlin

/**
 * Description :
 * @author  XQ Yang
 * @date 2018/7/5  11:45
 */
import android.app.Activity
import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.OnLifecycleEvent
import android.content.Context
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

interface ITopView : LifecycleOwner {
    fun getContext(): Context
    fun inited()
}

interface ITopPresenter : LifecycleObserver {
    fun attachView(view: ITopView)
    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun detachView()
}


interface ITopModel {
    fun onDetach()
}


interface IView<P : ITopPresenter> : ITopView {
    var mPresenter: P
    override fun inited() {
        mPresenter.attachView(this)
    }

    fun finish(resultCode: Int = Activity.RESULT_CANCELED)
}

interface IPresenter<V : ITopView, M : IModel> : ITopPresenter {
    var mView: V?
    var mModel: M?
    fun getContext() = mView?.getContext()

    @Suppress("UNCHECKED_CAST")
    override fun attachView(view: ITopView) {
        mView = view as V
        mView?.lifecycle?.addObserver(this)
        mModel = createModel()
    }

    override fun detachView() {
        mModel?.onDetach()
        mModel = null
        mView = null
    }

    fun createModel(): M
}

interface IModel : ITopModel {
    val mDisposablePool: CompositeDisposable

    fun addDisposable(disposable: Disposable) {
        mDisposablePool.add(disposable)
    }

    override fun onDetach() {
        mDisposablePool.clear()
    }
}
