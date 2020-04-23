package com.appscrip.triviaapp;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    // Table Name
    public static final String TABLE_NAME = "quizes";

    // Table columns
    public static final String _ID = "_id";
    public static final String DATE = "date";
    public static final String QUE = "que";
    public static final String QUENUM = "quenum";
    public static final String ANS = "ans";

    // Database Information
    static final String DB_NAME = "TRIVIA.DB";

    // database version
    static final int DB_VERSION = 1;

    // Creating table query
    private static final String CREATE_TABLE = "create table " + TABLE_NAME + "(" + _ID
            + " INTEGER PRIMARY KEY AUTOINCREMENT, " + DATE + " TEXT NOT NULL, "
            + QUE + " TEXT, "
            + QUENUM + " TEXT, "
            + ANS + " TEXT "

            + ")" +";";

    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }




    public void insert(QuestionAnsDetail qa) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(ANS, qa.ans);
        values.put(DATE, qa.date);
        values.put(QUE, qa.que);
        values.put(QUENUM, qa.queNum);

        // Inserting Row
        db.insert(TABLE_NAME, null, values);
        //2nd argument is String containing nullColumnHack
        db.close(); // Closing database connection
    }

    public List<QuestionAnsDetail> getAll() {
        List<QuestionAnsDetail> qaList = new ArrayList<QuestionAnsDetail>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                QuestionAnsDetail qa = new QuestionAnsDetail();
                qa.setGameId(cursor.getString(0));
                qa.setDate(cursor.getString(1));
                qa.setQue(cursor.getString(2));
                qa.setQueNum(cursor.getString(3));
                qa.setAns(cursor.getString(4));

                // Adding contact to list
                qaList.add(qa);
            } while (cursor.moveToNext());
        }

        // return contact list
        return qaList;
    }

}
