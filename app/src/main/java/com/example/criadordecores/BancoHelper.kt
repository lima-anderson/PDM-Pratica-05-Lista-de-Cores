package com.example.criadordecores

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class BancoHelper(context: Context): SQLiteOpenHelper(context, "dados", null, 1) {

    override fun onCreate(db: SQLiteDatabase?) {
        val sql = "create table DescricaoCor(" +
                "id integer primary key autoincrement, " +
                "nome text, " +
                "numero integer)"
        db?.execSQL(sql)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("drop table DescricaoCor")
        this.onCreate(db)
    }
}