package com.habibipasha.ui.main;


import com.habibipasha.models.Restepti;
import com.habibipasha.ui.base.BaseView;
import com.hannesdorfmann.mosby3.mvp.MvpView;

import java.util.ArrayList;
import java.util.List;

public interface MainView extends  BaseView {

    void showAllRetsept(ArrayList<Restepti> resteptiList);
    void showFavoritRetsept(ArrayList<Restepti> resteptiList);
    void showMyRetsept(ArrayList<Restepti> resteptiList);

    void updateAdapter();
}

