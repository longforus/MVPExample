package com.longforus.mvpexample.model;

import com.longforus.mvpexample.contract.IRegisterContract;
import com.longforus.base.java.DefaultDisposablePoolImpl;

/**
 * Description :
 *
 * @author longforus
 * @date 2018/7/5  16:48
 * - generate by MvpAutoCodePlus plugin.
 */

public class RegisterModel extends DefaultDisposablePoolImpl implements IRegisterContract.Model {

    @Override
    public String getContent() {
        return "来自RegisterModel";
    }
}

