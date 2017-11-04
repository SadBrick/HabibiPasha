package com.habibipasha.ui.main.fragment;

import com.habibipasha.models.Restepti;
import com.habibipasha.ui.base.BaseView;

import java.util.ArrayList;

/**
 * Created by PLC-9 on 04.11.2017.
 */

public interface AllResteptView extends BaseView{
    void showList(ArrayList<Restepti> resteptiList);
}
