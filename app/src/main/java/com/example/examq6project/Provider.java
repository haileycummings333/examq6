package com.example.examq6project;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;

public class Provider extends ContentProvider {


    public static final String DBNAME = "FunkoPOPDB";
    public static final String TABLE_NAME = "FunkoPOP";
    public static final String COLUMN_ID = "_ID";
    public static final String COLUMN_POP_NAME = "POP_NAME";
    public static final String COLUMN_POP_NUMBER = "POP_NUMBER";
    public static final String COLUMN_POP_TYPE = "POP_TYPE";
    public static final String COLUMN_FANDOM = "FANDOM";
    public static final String COLUMN_ON = "On";
    public static final String COLUMN_ULTIMATE = "ULTIMATE";
    public static final String COLUMN_PRICE = "PRICE";
    private static final String AUTHORITY = "com.example.examq6project.provider";
    public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY + DBNAME);

    private static final String CREATE_DB_QUERY = "CREATE TABLE " +
            TABLE_NAME + " (" +
            COLUMN_ID + " INTEGER PRIMARY KEY, " +
            COLUMN_POP_NAME + " TEXT, " +
            COLUMN_POP_NUMBER + " INTEGER, " +
            COLUMN_POP_TYPE + " TEXT, " +
            COLUMN_FANDOM + " TEXT, " +
            COLUMN_ON + "BOOLEAN, " +
            COLUMN_ULTIMATE + " TEXT, " +
            COLUMN_PRICE + " DOUBLE)";


    protected static final class MainDatabaseHelper extends SQLiteOpenHelper {
        MainDatabaseHelper(Context context) {
            super(context, DBNAME, null, 1);
        }
        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(CREATE_DB_QUERY);
        }
        @Override
        public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
        }
    };
    private MainDatabaseHelper SQLHelper;


    public Provider() {
    }
    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return SQLHelper.getWritableDatabase().delete(TABLE_NAME, selection, selectionArgs);

    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
        return SQLHelper.getReadableDatabase().query(TABLE_NAME, projection, selection,
                selectionArgs, null, null, sortOrder);
    }
    @Override
    public Uri insert(Uri uri, ContentValues values) {
        long id = SQLHelper.getWritableDatabase().insert(TABLE_NAME, null, values);
        return Uri.withAppendedPath(CONTENT_URI, "" + id);
    }


    @Override
    public boolean onCreate() {
        SQLHelper = new MainDatabaseHelper(getContext());
        return true;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        return SQLHelper.getWritableDatabase().update(TABLE_NAME,values, selection, selectionArgs);
    }

    @Override
    public String getType(Uri uri) {
        // TODO: Implement this to handle requests for the MIME type of the data
        // at the given URI.
        throw new UnsupportedOperationException("Not yet implemented");
    }

}