package com.longforus.mvpexample.presenter;

import android.widget.Toast;
import com.longforus.mvpexample.contract.IRegisterContract;
import com.longforus.base.java.BasePresenterJv;
import com.longforus.mvpexample.model.RegisterModel;

/**
 * Description :
 *
 * @author longforus
 * @date 2018/7/5  16:48
 * - generate by MvpAutoCodePlus plugin.
 */

public class RegisterPresenter extends BasePresenterJv<IRegisterContract.View,IRegisterContract.Model> implements IRegisterContract.Presenter {

    @Override
    protected IRegisterContract.Model createModel() {
        return new RegisterModel();
    }

    @Override
    public void onTvClick() {
        Toast.makeText(getContext(),mModel.getContent(),Toast.LENGTH_SHORT).show();
    }
}

