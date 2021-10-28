package com.rorpheeyah.androidcipherdb.db_pets;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;

import net.sqlcipher.database.SQLiteDatabase;
import net.sqlcipher.database.SQLiteOpenHelper;
import net.sqlcipher.database.SQLiteStatement;

public class DbCipherTablePetHelper extends SQLiteOpenHelper {
    public static final String TABLE_TARGET = "table_pet";

    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_NAME = "col_name";
    public static final String COLUMN_RANKING = "col_ranking";
    public static final String COLUMN_TIME = "col_time";

    // Database creation sql statement
    private static final String DATABASE_CREATE = "create table "
            + TABLE_TARGET + "(" + COLUMN_ID
            + " integer primary key autoincrement, "
            + COLUMN_NAME + " text, "
            + COLUMN_RANKING + " integer, "
            + COLUMN_TIME + " real);";

    private static final String DATABASE_NAME = "dbcipher_pets.db";

    private static final int DATABASE_VERSION = 1;

    public DbCipherTablePetHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(@NonNull SQLiteDatabase database) {
        database.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(@NonNull SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.v(DbCipherTablePetHelper.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        SQLiteStatement statement = db.compileStatement("DROP TABLE IF EXISTS " + TABLE_TARGET);
        statement.execute();
        onCreate(db);
    }
}
