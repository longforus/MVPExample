package com.longforus.mvpexample.contract;

import com.longforus.base.java.IView;
import com.longforus.base.java.IPresenter;
import com.longforus.base.java.IModel;

/**
 * Description :
 *
 * @author longforus
 * @date 2018/7/5  16:48
 * - generate by MvpAutoCodePlus plugin.
 */

public interface IRegisterContract {
    interface View extends IView {
    }

    interface Presenter extends IPresenter<View> {
        void onTvClick();
    }

    interface Model extends IModel {
        String getContent();
    }
}
