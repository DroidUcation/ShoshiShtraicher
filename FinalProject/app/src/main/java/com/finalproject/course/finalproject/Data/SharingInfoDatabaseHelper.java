package com.finalproject.course.finalproject.Data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Sharing Information DatabaseHelper : products, recipes and tips
 */
public class SharingInfoDatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1; // Database Version
    // Table Create Statements
    //Products table create statement
    private static final String CREATE_TABLE_PRODUCTS =
            "CREATE TABLE IF NOT EXIST"
            + SharingInfoContract.ProductsEntry.TABLE_NAME + "("
            + " id INTEGER PRIMARY KEY,"
            + SharingInfoContract.ProductsEntry.PRODUCT_NAME + " TEXT,"
            + SharingInfoContract.ProductsEntry.STORE_NAME + " TEXT,"
            + SharingInfoContract.ProductsEntry.IMAGE + " BLOB,"
            + SharingInfoContract.ProductsEntry.STORE_URL + " TEXT,"
            + SharingInfoContract.ProductsEntry.CITY + " TEXT,"
            + SharingInfoContract.ProductsEntry.STREET + " TEXT,"
            + SharingInfoContract.ProductsEntry.HOUSE_NO + " INTEGER,"
            + SharingInfoContract.ProductsEntry.COMMENT + " TEXT,"
            + SharingInfoContract.ProductsEntry.PHONE + " TEXT"
            + SharingInfoContract.ProductsEntry.DATE_MODIFIED + " TEXT"+")";

    //TODO: Recipes table create statement
    //TODO: Tips table create statement

    public SharingInfoDatabaseHelper(Context context){
        super(context,"SharingInfoDB",null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // creating required tables
        db.execSQL(CREATE_TABLE_PRODUCTS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
