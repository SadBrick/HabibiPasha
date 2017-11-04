package com.habibipasha.ui;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.habibipasha.R;
import com.habibipasha.data.DataAdapter;
import com.habibipasha.data.DatabaseHelper;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DataAdapter adapter = new DataAdapter(this);
        adapter.getList();
    }
}

