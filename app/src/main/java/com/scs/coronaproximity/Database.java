package com.scs.coronaproximity;

import android.database.sqlite.SQLiteDatabase;

import static android.content.Context.MODE_PRIVATE;
import static android.database.sqlite.SQLiteDatabase.openOrCreateDatabase;

public class Database {

    public void openConnection(){
        SQLiteDatabase mydatabase = openOrCreateDatabase("database",null);

    }
}
