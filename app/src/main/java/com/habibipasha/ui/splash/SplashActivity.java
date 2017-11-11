package com.habibipasha.ui.splash;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.habibipasha.R;
import com.habibipasha.ui.main.MainActivity;
import com.habibipasha.ui.base.BaseActivity;

/**
 * Created by PLC-9 on 04.11.2017.
 */

public class SplashActivity extends BaseActivity<SplashView, SplashPresenter> implements SplashView{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        presenter.waitSplash();
        pOpp();
    }

    @NonNull
    @Override
    public SplashPresenter createPresenter() {
        return new SplashPresenter();
    }

    @Override
    public void openNext() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}
