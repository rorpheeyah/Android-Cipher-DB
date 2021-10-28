package com.rorpheeyah.androidcipherdb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;

import com.rorpheeyah.androidcipherdb.databinding.ActivityMainBinding;
import com.rorpheeyah.androidcipherdb.db_sqlcipher.DbCipherTableResult;
import com.rorpheeyah.androidcipherdb.db_sqlcipher.Result;

import net.sqlcipher.database.SQLiteDatabase;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    static private final int DATABASE_INSERT = 0;
    static private final int DATABASE_SELECT = 1;
    static private final int DATABASE_DELETE = 2;

    private static final int RECORD_COUNT = 10;

    /**
     * Database encrypted with SQLCipher
     */
    private DbCipherTableResult mDatabaseCipherTable;

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /**
         * Important: Must call this function before calling any SQLCipher functions
         */
        SQLiteDatabase.loadLibs(getApplicationContext());

        binding = ActivityMainBinding.inflate(LayoutInflater.from(this));
        setContentView(binding.getRoot());

        binding.btnAdd.setOnClickListener(v -> {
            mDatabaseCipherTable = new DbCipherTableResult(this);
            mDatabaseCipherTable.open();
            mDatabaseCipherTable.deleteAll();
            mDatabaseCipherTable.close();
            Log.e(TAG, "Generating database (Encryption: on)");
            databaseInsert();
            databaseSelect();
            databaseDelete();
        });
    }

    private void databaseInsert() {
        Result result;
        mDatabaseCipherTable.open();
        for (int i = 0; i < MainActivity.RECORD_COUNT; i++) {
            result = new Result(i, "Kufra " + i, i+1, 100.0f);
            mDatabaseCipherTable.addResult(result);
        }
        mDatabaseCipherTable.close();
    }

    private void databaseSelect() {
        mDatabaseCipherTable.open();
        mDatabaseCipherTable.testSelect(null, null);
        mDatabaseCipherTable.close();
    }

    private void databaseDelete() {
        mDatabaseCipherTable.open();
        while (mDatabaseCipherTable.deleteFirstRecord()) {
        }
        mDatabaseCipherTable.close();
    }
}