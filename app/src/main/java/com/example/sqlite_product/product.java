package com.example.sqlite_product;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.EventLogTags;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class product extends SQLiteOpenHelper {

    private Context context;
    private static final String DATABASE_NAME="Product.db";
    private static final int DATABASE_VERSION=1;

    private static final String TABLE_NAME= "my_product";
    private static final String COLUMN_CODE= "_code";
    private static final String COLUMN_DESCRIPTION = "description";
    private static final String COLUMN_PRICE ="price";
    public product(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME +
                " (" + COLUMN_CODE + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_DESCRIPTION + " TEXT, " +
                COLUMN_PRICE + " INTEGER);";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    void addProduct(int code, String description, String price){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_CODE, code);
        cv.put(COLUMN_DESCRIPTION, description);
        cv.put(COLUMN_PRICE, price);
        long result = db.insert(TABLE_NAME,null,cv);
        if(result==-1){
            Toast.makeText(context,"Failed", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context,"Added successfully!", Toast.LENGTH_SHORT).show();

        }
    }

    Cursor readAllData(){
        String query = "SELECT * FROM " +TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if (db!=null){
            cursor = db.rawQuery(query,null);
        }
        return cursor;

    }


}
