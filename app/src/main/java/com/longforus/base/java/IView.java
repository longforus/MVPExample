package com.longforus.base.java;

import android.arch.lifecycle.LifecycleOwner;
import android.content.Context;

/**
 * Created by XQ Yang on 2017/8/8  11:24.
 * Description : 顶级view接口
 */

public interface IView extends LifecycleOwner {
    Context getContext();
}
