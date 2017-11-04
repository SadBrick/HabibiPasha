package com.habibipasha.ui.main.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.habibipasha.R;
import com.habibipasha.data.DataAdapter;
import com.habibipasha.models.Restepti;
import com.habibipasha.ui.base.BaseFragment;
import com.habibipasha.ui.main.RetseptiAdapter;

import java.util.ArrayList;


public class AllResteptFragment extends BaseFragment<AllResteptView, AllResteptPresenter> implements AllResteptView {

    private ListView lvRestept;


    public static AllResteptFragment newInstance() {
        return new AllResteptFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_all_restepti, container, false);
    }

    @Override
    public AllResteptPresenter createPresenter() {
        return new AllResteptPresenter(new DataAdapter(getContext()));
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        lvRestept = view.findViewById(R.id.lvListRestepti);
        presenter.init();
    }

    @Override
    public void showList(ArrayList<Restepti> resteptiList) {
        RetseptiAdapter adapter = new RetseptiAdapter(getContext(), resteptiList);
        lvRestept.setAdapter(adapter);
    }
}
