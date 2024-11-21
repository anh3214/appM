package com.example.myapplication.data.database.syncDatabase

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class AppDatabaseHelper(context: Context) : SQLiteOpenHelper(
    context,
    DatabaseContract.DATABASE_NAME,
    null,
    DatabaseContract.DATABASE_VERSION
) {

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(DatabaseContract.UserTable.CREATE_TABLE)
        db?.execSQL(DatabaseContract.MedicineTable.CREATE_TABLE)
        db?.execSQL(DatabaseContract.ReportTable.CREATE_TABLE)
        db?.execSQL(DatabaseContract.SchedulingTable.CREATE_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS ${DatabaseContract.UserTable.TABLE_NAME}")
        db?.execSQL("DROP TABLE IF EXISTS ${DatabaseContract.MedicineTable.TABLE_NAME}")
        db?.execSQL("DROP TABLE IF EXISTS ${DatabaseContract.ReportTable.TABLE_NAME}")
        db?.execSQL("DROP TABLE IF EXISTS ${DatabaseContract.SchedulingTable.TABLE_NAME}")
        onCreate(db)
    }
}