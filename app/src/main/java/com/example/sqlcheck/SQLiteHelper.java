package com.example.sqlcheck;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

/**
 * Created by Quoc Nguyen on 13-Dec-16.
 */

public class SQLiteHelper extends SQLiteOpenHelper {

    public SQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    public void queryData(String sql){
        SQLiteDatabase database = getWritableDatabase();
        database.execSQL(sql);
    }

    public void insertData(String name, byte[] image,String days,String disc){
        SQLiteDatabase database = getWritableDatabase();
        String sql = "INSERT INTO Challenge VALUES (NULL, ?, ?, ?,?)";

        SQLiteStatement statement = database.compileStatement(sql);
        statement.clearBindings();

        statement.bindString(1, name);
        statement.bindBlob(2, image);
        statement.bindString(3,days);
        statement.bindString(4, disc);



        statement.executeInsert();
    }
    public void insertData2(Integer Cid, String name, byte[] image,String days,String disc,String is_done,String date){
        SQLiteDatabase database = getWritableDatabase();
        String sql = "INSERT INTO Challenge VALUES (NULL, ?, ?, ?, ?, ?, ?, ?)";

        SQLiteStatement statement = database.compileStatement(sql);
        statement.clearBindings();
        statement.bindLong(1,Cid);
        statement.bindString(2, name);
        statement.bindBlob(3, image);
        statement.bindString(4,days);
        statement.bindString(5, disc);
        statement.bindString(6, is_done);
        statement.bindString(7, date);



        statement.executeInsert();
    }

    public void updateData(String name,  byte[] image, String days,String disc,int id) {
        SQLiteDatabase database = getWritableDatabase();

        String sql = "UPDATE Challenge SET name = ?, image = ?, days= ?,disc = ? WHERE id = ?";
        SQLiteStatement statement = database.compileStatement(sql);

        statement.bindString(1, name);
        statement.bindBlob(2, image);
        statement.bindString(3, days);
        statement.bindString(4, disc);
        statement.bindDouble(5, (double)id);

        statement.execute();
        database.close();
    }

    public  void deleteData(int id) {
        SQLiteDatabase database = getWritableDatabase();

        String sql = "DELETE FROM Challenge WHERE id = ?";
        SQLiteStatement statement = database.compileStatement(sql);
        statement.clearBindings();
        statement.bindDouble(1, (double)id);

        statement.execute();
        database.close();
    }

    public Cursor getData(String sql){
        SQLiteDatabase database = getReadableDatabase();
        return database.rawQuery(sql, null);
    }


    public  void deleteData2(int id) {
        SQLiteDatabase database = getWritableDatabase();

        String sql = "DELETE FROM MyChallenge WHERE id = ?";
        SQLiteStatement statement = database.compileStatement(sql);
        statement.clearBindings();
        statement.bindDouble(1, (double)id);

        statement.execute();
        database.close();
    }





    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }


}
