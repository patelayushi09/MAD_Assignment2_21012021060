package com.example.mad_assignment2_21012021060

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context): SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    companion object {
        private const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "users.db"
        private const val TABLE_NAME = "user"
        private const val COLUMN_USER_ID = "user_id"
        private const val COLUMN_USER_NAME = "user_name"
        private const val COLUMN_USER_EMAIL = "user_email"
        private const val COLUMN_USER_PASSWORD = "user_password"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val createTableQuery =
            "CREATE TABLE $TABLE_NAME($COLUMN_USER_ID INTEGER PRIMARY KEY AUTOINCREMENT, $COLUMN_USER_NAME TEXT, $COLUMN_USER_EMAIL TEXT, $COLUMN_USER_PASSWORD TEXT)"
        if (db != null) {
            db.execSQL(createTableQuery)
        }
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        if (db != null) {
            db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        }
    }

    fun addUser(name: String, email: String, password: String) {
        val db: SQLiteDatabase = writableDatabase
        val values = ContentValues()
        values.put(COLUMN_USER_NAME, name)
        values.put(COLUMN_USER_EMAIL, email)
        values.put(COLUMN_USER_PASSWORD, password)

        // inserting rows in a table
        db.insert(TABLE_NAME, null, values)
        db.close()
    }

    @SuppressLint("Range")
    fun getNameFromEmail(email: String): String? {
        var name: String? = null
        val db: SQLiteDatabase = readableDatabase
        val columns = arrayOf(COLUMN_USER_NAME)
        val selection = "$COLUMN_USER_EMAIL = ?"
        val selectionArgs = arrayOf(email)
        val cursor = db.query(TABLE_NAME, columns, selection, selectionArgs, null, null, null)
        if (cursor.moveToFirst()) {
            name = cursor.getString(cursor.getColumnIndex(COLUMN_USER_NAME))
        }
        cursor.close()
        return name
    }

    @SuppressLint("Range")
    fun getPasswordFromEmail(email: String): String? {
        var password: String? = null
        val db: SQLiteDatabase = readableDatabase
        val columns = arrayOf(COLUMN_USER_PASSWORD)
        val selection = "$COLUMN_USER_EMAIL = ?"
        val selectionArgs = arrayOf(email)
        val cursor = db.query(TABLE_NAME, columns, selection, selectionArgs, null, null, null)
        if (cursor.moveToFirst()) {
            password = cursor.getString(cursor.getColumnIndex(COLUMN_USER_PASSWORD))
        }
        cursor.close()
        return password
    }
}
