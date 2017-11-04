package com.habibipasha.data;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.habibipasha.models.Restepti;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataAdapter {

    private DatabaseHelper mDBHelper;
    private SQLiteDatabase mDb;

    public DataAdapter(Context context) {
        mDBHelper = new DatabaseHelper(context);
        try {
            mDBHelper.updateDataBase();
        } catch (IOException mIOException) {
            throw new Error("UnableToUpdateDatabase");
        }

        mDb = mDBHelper.getWritableDatabase();
    }

    public List<Restepti> getList() {
        List<Restepti> list = new ArrayList<>();
        Cursor cursor = mDb.rawQuery("SELECT * FROM restepti", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Restepti restepti = new Restepti(cursor.getInt(0), cursor.getString(1),
                    cursor.getString(2), cursor.getString(3),
                    cursor.getInt(4) == 1, cursor.getString(5),
                    cursor.getString(6), cursor.getString(7));
            list.add(restepti);
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }
}
