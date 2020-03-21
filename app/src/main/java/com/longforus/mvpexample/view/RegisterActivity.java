package com.longforus.mvpexample.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.Button;
import com.longforus.base.java.BaseMvpActivity;
import com.longforus.mvpexample.R;
import com.longforus.mvpexample.contract.IRegisterContract;
import com.longforus.mvpexample.presenter.RegisterPresenter;
import org.jetbrains.annotations.Nullable;

/**
 * Description :
 *
 * @author longforus
 * @date 2018/7/5  16:48
 * - generate by MvpAutoCodePlus plugin.
 */

public class RegisterActivity extends BaseMvpActivity<IRegisterContract.View,IRegisterContract.Presenter> implements IRegisterContract.View {

    @Override
    public IRegisterContract.Presenter createPresenter() {
        return new RegisterPresenter();
    }

    @Override
    public IRegisterContract.View createView() {
        return this;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }


    @Override
    protected void initView(@Nullable Bundle savedInstanceState) {
        Button tv = findViewById(R.id.tv);
        tv.setText("register");
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.onTvClick();
            }
        });

        findViewById(R.id.btn_show_fragment).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().add(R.id.fl, Fragment.instantiate(RegisterActivity.this, TestFragment.class.getName())).commit();
            }
        });
    }

    @Override
    protected void initListener() {

    }
}

