package com.habibipasha.ui.main;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.Toast;

import com.habibipasha.R;
import com.habibipasha.data.Constans;
import com.habibipasha.data.DataAdapter;
import com.habibipasha.models.Restepti;
import com.habibipasha.ui.base.BaseActivity;

import java.util.ArrayList;

public class MainActivity extends BaseActivity<MainView, MainPresenter> implements MainView{

    private ListView lvAllRetsept;
    private ListView favoritRetsept;
    private ListView myRetsept;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        TabHost tabHost = (TabHost) findViewById(R.id.tabhost);

        tabHost.setup();
         
        TabHost.TabSpec tabSpec;
         
        // создаем вкладку и указываем тег
        tabSpec = tabHost.newTabSpec(Constans.ALL);
        // название вкладки
        tabSpec.setIndicator("Все рецепты");
        // указываем id компонента из FrameLayout, он и станет содержимым
        tabSpec.setContent(R.id.lvAllRetsepti);
        // добавляем в корневой элемент
        tabHost.addTab(tabSpec);
         
        tabSpec = tabHost.newTabSpec(Constans.FAVORIT);

        tabSpec.setIndicator("Избраное");
        tabSpec.setContent(R.id.lvFavorit);
        tabHost.addTab(tabSpec);

        tabSpec = tabHost.newTabSpec(Constans.MY);

        tabSpec.setIndicator("Мои рецепты");
        tabSpec.setContent(R.id.llMyRetsept);
        tabHost.addTab(tabSpec);


        tabHost.setCurrentTabByTag(Constans.ALL);
         

        tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
      public void onTabChanged(String tabId) {
        Toast.makeText(getBaseContext(), "tabId = " + tabId, Toast.LENGTH_SHORT).show();
        presenter.updateTab(tabId);
      }
    });

        lvAllRetsept = findViewById(R.id.lvAllRetsepti);
        favoritRetsept = findViewById(R.id.lvFavorit);
        myRetsept = findViewById(R.id.lvMyRetsept);

        presenter.init();


    }

    @NonNull
    @Override
    public MainPresenter createPresenter() {
        return new MainPresenter(new DataAdapter(this));
    }


    @Override
    public void showAllRetsept(ArrayList<Restepti> resteptiList) {
        RetseptiAdapter retseptiAdapter = new RetseptiAdapter(this, resteptiList, presenter);
        lvAllRetsept.setAdapter(retseptiAdapter);
    }

    @Override
    public void showFavoritRetsept(ArrayList<Restepti> resteptiList) {
        RetseptiAdapter retseptiAdapter = new RetseptiAdapter(this,resteptiList, presenter);
        favoritRetsept.setAdapter(retseptiAdapter);
    }

    @Override
    public void showMyRetsept(ArrayList<Restepti> resteptiList) {
        RetseptiAdapter retseptiAdapter = new RetseptiAdapter(this,resteptiList, presenter);
        myRetsept.setAdapter(retseptiAdapter);
    }

    @Override
    public void updateAdapter() {
        ((RetseptiAdapter) lvAllRetsept.getAdapter()).notifyDataSetChanged();
        ((RetseptiAdapter) favoritRetsept.getAdapter()).notifyDataSetChanged();
    }

}

