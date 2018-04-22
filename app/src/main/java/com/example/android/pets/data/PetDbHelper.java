package com.example.android.pets.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


/**
 * Created by Tin on 30/05/2017.
 */

public class PetDbHelper extends SQLiteOpenHelper{

    /** Name of the Database */
    public static final String DATABASE_NAME = "shelter.db";
    /** If the database schema changes, the Database Version must be incremented */
    public static final int DATABASE_VERSION = 1;

    /** Constructs a new instance of {@link PetDbHelper}. */
    public PetDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /** This is called when the database is created for the first time.
     * This is the SQL CREATE TABLE Statement written in a format for Android */
    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create a String that contains the SQL statement that will create the pets table
        String SQL_CREATE_PETS_TABLE = "CREATE TABLE " + PetContract.PetEntry.TABLE_NAME + " ("
                + PetContract.PetEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + PetContract.PetEntry.COLUMN_PET_NAME + " TEXT NOT NULL, "
                + PetContract.PetEntry.COLUMN_PET_BREED + " TEXT, "
                + PetContract.PetEntry.COLUMN_PET_GENDER + " INTEGER NOT NULL, "
                + PetContract.PetEntry.COLUMN_PET_WEIGHT + " INTEGER NOT NULL DEFAULT 0);";
        // Execute the SQL statement
        db.execSQL(SQL_CREATE_PETS_TABLE);

    }

    /** This is called when the database needs to be upgraded. */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // The database is still at Version 1, so there's nothing to be done here
    }
}
