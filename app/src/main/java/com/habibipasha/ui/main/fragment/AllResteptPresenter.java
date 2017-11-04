package com.habibipasha.ui.main.fragment;

import com.habibipasha.data.DataAdapter;
import com.habibipasha.models.Restepti;
import com.habibipasha.ui.base.BasePresenter;

import java.util.ArrayList;

/**
 * Created by PLC-9 on 04.11.2017.
 */

public class AllResteptPresenter extends BasePresenter<AllResteptView> {
    private DataAdapter adapter;
    private ArrayList<Restepti> resteptiList;

    public AllResteptPresenter(DataAdapter dataAdapter) {
        this.adapter = dataAdapter;
    }

    public void init() {
        resteptiList = new ArrayList<>();
        resteptiList.addAll(adapter.getList());
        getView().showList(resteptiList);
    }
}
