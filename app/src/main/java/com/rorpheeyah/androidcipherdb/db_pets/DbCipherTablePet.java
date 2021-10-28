package com.rorpheeyah.androidcipherdb.db_pets;

import android.content.ContentValues;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import net.sqlcipher.Cursor;
import net.sqlcipher.DatabaseUtils;
import net.sqlcipher.SQLException;
import net.sqlcipher.database.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class DbCipherTablePet {
    private SQLiteDatabase mDatabase;
    private final DbCipherTablePetHelper mDbHelper;

    /**
     * Array of all columns in the table
     */
    private final String[] mAllColumns = {
            DbCipherTablePetHelper.COLUMN_ID,
            DbCipherTablePetHelper.COLUMN_NAME,
            DbCipherTablePetHelper.COLUMN_RANKING,
            DbCipherTablePetHelper.COLUMN_TIME
    };

    public DbCipherTablePet(Context context) {
        mDbHelper = new DbCipherTablePetHelper(context);
    }

    /**
     * Open the SQLite database
     */
    public void open() throws SQLException {
        mDatabase = mDbHelper.getWritableDatabase("pet_db_cipher_!@#_2021");
    }

    /**
     * Close the SQLite database
     */
    public void close() {
        mDbHelper.close();
    }


    public Pet addPet(@NonNull final Pet pet) {
        ContentValues values = new ContentValues();
        values.put(DbCipherTablePetHelper.COLUMN_NAME, pet.mName);
        values.put(DbCipherTablePetHelper.COLUMN_RANKING, pet.mRanking);
        values.put(DbCipherTablePetHelper.COLUMN_TIME, pet.mTime);

        final long insertId = mDatabase.insert(DbCipherTablePetHelper.TABLE_TARGET, null, values);

        Cursor cursor = mDatabase.query(DbCipherTablePetHelper.TABLE_TARGET,
                mAllColumns, DbCipherTablePetHelper.COLUMN_ID + " = "
                        + insertId, null, null, null, null);

        cursor.moveToFirst();

        Pet petInserted = cursorToResult(cursor);
        cursor.close();

        return petInserted;
    }

    public boolean deletePet(@NonNull String id) {
        List<Pet> pets = getPets(null, null, "1");
        mDatabase.delete(DbCipherTablePetHelper.TABLE_TARGET, DbCipherTablePetHelper.COLUMN_ID + "=?", new String[] {id});
        return pets.size() > 0;
    }
    /**
     * Delete all records from the database table (but not the table itself)
     */
    public void deleteAll() {
        mDatabase.delete(DbCipherTablePetHelper.TABLE_TARGET, null, null);
    }

    /**
     * Retrieve a list of Results that match the filters passed
     *
     * @param where Sqlite where filter string
     * @param args  Sqlite args array
     * @return List of dbQuake objects that meet filter
     */
    public List<Pet> getPets(@Nullable String where, @Nullable String[] args, String limit) {
        List<Pet> databaseSelectedPets = new ArrayList<>();
        Cursor cursor = mDatabase.query(DbCipherTablePetHelper.TABLE_TARGET,
                mAllColumns, where, args, null, null, null, limit);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Pet pet = cursorToResult(cursor);
            databaseSelectedPets.add(pet);
            cursor.moveToNext();
        }

        cursor.close();

        return databaseSelectedPets;
    }

    /**
     * Take the cursor from a database query and create fill the result structure
     *
     * @param cursor Database cursor from sqlite query
     * @return new result structure
     */
    private Pet cursorToResult(@NonNull final Cursor cursor) {
        Pet pet = new Pet();
        pet.mID = cursor.getLong(0);
        pet.mName = cursor.getString(1);
        pet.mRanking = cursor.getInt(2);
        pet.mTime = cursor.getFloat(3);
        return pet;
    }
}
