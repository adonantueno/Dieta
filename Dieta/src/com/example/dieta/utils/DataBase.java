package com.example.dieta.utils;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBase extends SQLiteOpenHelper {
	String sqlCreate = "CREATE TABLE Meals (name TEXT, calories INTEGER, proteins REAL, fat REAL, hydrates REAL)";
	String sqlDelete = "DROP TABLE IF EXISTST Meals";
	
	public DataBase(Context context, String name, CursorFactory factory, int version) {
		super(context, name, factory, version);
	}
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(sqlCreate);
		for(int i=1; i<=10; i++) {
			ContentValues newRegister = new ContentValues();
			newRegister.put("name", "name"+i);
			newRegister.put("calories", i);
			newRegister.put("proteins", i);
			newRegister.put("fat", i);
			newRegister.put("hydrates", i);
			db.insert("Meals", null, newRegister);
		}

	}
	
	@Override
	public void onUpgrade(SQLiteDatabase db, int olderVersion, int newVersion) {
		db.execSQL(sqlDelete);
		db.execSQL(sqlCreate);
	}

}
