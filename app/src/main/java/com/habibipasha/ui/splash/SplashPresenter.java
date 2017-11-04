package com.habibipasha.ui.splash;

import android.os.CountDownTimer;

import com.habibipasha.ui.base.BasePresenter;


public class SplashPresenter extends BasePresenter<SplashView> {
    void waitSplash() {
        new CountDownTimer(3000, 1000) {

            public void onTick(long millisUntilFinished) {
            }

            public void onFinish() {
                getView().openNext();
            }
        }.start();

    }
}
