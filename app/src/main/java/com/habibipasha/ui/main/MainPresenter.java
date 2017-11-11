package com.habibipasha.ui.main;

import com.habibipasha.data.Constans;
import com.habibipasha.data.DataAdapter;
import com.habibipasha.models.Restepti;
import com.habibipasha.ui.base.BasePresenter;

import java.util.ArrayList;

/**
 * Created by PLC-9 on 04.11.2017.
 */

public class MainPresenter extends BasePresenter<MainView> {
    private DataAdapter adapter;
    private ArrayList<Restepti> resteptiList;
    private ArrayList<Restepti> resteptiFavoritList;


    public MainPresenter(DataAdapter dataAdapter) {
        this.adapter = dataAdapter;
    }

    public void init() {
        resteptiList = new ArrayList<>();
        resteptiFavoritList = adapter.getListFavorit();
        resteptiList.addAll(adapter.getList());
        getView().showAllRetsept(resteptiList);
        getView().showFavoritRetsept(resteptiFavoritList);
        getView().showMyRetsept(resteptiList);
    }

    public void changeFavorit(int id, boolean isChecked){
        adapter.changeFavorit(id, isChecked);
    }

    public void updateTab(String tabId) {
        switch (tabId) {
            case Constans.ALL:
                getView().showAllRetsept(adapter.getList());
                break;
            case Constans.FAVORIT:
                getView().showFavoritRetsept( adapter.getListFavorit());
                break;
            case Constans.MY:
                getView().showMyRetsept(resteptiList);
                break;
        }
        getView().updateAdapter();
    }
}
