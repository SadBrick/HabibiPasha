package com.habibipasha.data;

import android.content.ContentValues;
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

    private final String TABLE_NAME="restepti";
    private final String FAVORITE = "favorite";
    private final String NAME = "name";
    private final String CHASHKA = "chashka";
    private final String TABAK = "tabak";
    private final String JIDKOST = "jidkost";
    private final String WHERE_UPDATE = "_id = ?";
    private final String MY_RETSEPT_TABLE = "my_restepti";

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

    public ArrayList<Restepti> getList() {
        ArrayList<Restepti> list = new ArrayList<>();
        Cursor cursor = mDb.rawQuery("SELECT * FROM "+ TABLE_NAME +" ORDER BY "+ NAME, null);
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

public ArrayList<Restepti> getMyRetsept() {
        ArrayList<Restepti> list = new ArrayList<>();
        Cursor cursor = mDb.rawQuery("SELECT * FROM "+ MY_RETSEPT_TABLE +" ORDER BY "+ NAME, null);
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

    public ArrayList<Restepti> getListFavorit() {
        ArrayList<Restepti> list = new ArrayList<>();
        Cursor cursor = mDb.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE "+ FAVORITE +" = 1 ORDER BY "+NAME, null);
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

    public void changeFavorit(int id, boolean isChecked) {
        ContentValues cv = new ContentValues();

//        int i;
//        if(isChecked)
//            i = 1;
//        else i = 0;
//        cv.put("favorite",i);

        cv.put(FAVORITE, isChecked ? 1 : 0);

        mDb.update(TABLE_NAME, cv, WHERE_UPDATE, new String[]{String.valueOf(id)});

    }

    public void addTable(String name, String chashka, String tabak, String jidkost, String favorit){
        ContentValues cv = new ContentValues();

        cv.put(NAME, name);
        cv.put(CHASHKA, chashka);
        cv.put(TABAK, tabak);
        cv.put(JIDKOST, jidkost);
        cv.put(WHERE_UPDATE, favorit);

        mDb.insert(MY_RETSEPT_TABLE, null, cv);
    }
}
