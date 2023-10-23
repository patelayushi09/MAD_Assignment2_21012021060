package com.example.mad_assignment2_21012021060

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        // database version
        private const val DATABASE_VERSION = 1

        // database name
        private const val DATABASE_NAME = "UserManager.db"

        // table  name is user
        private const val TABLE_USER = "user"

        // user table columns name
        private const val COLUMN_USER_ID = "user_id"
        private const val COLUMN_USER_NAME = "user_name"
        private const val COLUMN_USER_EMAIL = "user_email"
        private const val COLUMN_USER_PASSWORD = "user_password"
    }

    private var CREATE_USER_TABLE:String?
    init {
        // Initialize the CREATE_USER_TABLE in the init block
        CREATE_USER_TABLE = "CREATE TABLE $TABLE_USER ($COLUMN_USER_ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "$COLUMN_USER_NAME TEXT, $COLUMN_USER_EMAIL TEXT, $COLUMN_USER_PASSWORD TEXT)"
    }

    // drop table query
    private val DROP_USER_TABLE = "DROP TABLE IF EXISTS $TABLE_USER"

    override fun onCreate(sqLiteDatabase: SQLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_USER_TABLE)
    }

    override fun onUpgrade(sqLiteDatabase: SQLiteDatabase, i: Int, i1: Int) {
        // drop user table if exists
        sqLiteDatabase.execSQL(DROP_USER_TABLE)

        // create tables again
        onCreate(sqLiteDatabase)
    }

    @SuppressLint("Range")
    fun getNameFromEmail(email: String): String? {
        var name: String? = null
        val db: SQLiteDatabase = readableDatabase
        val columns = arrayOf(COLUMN_USER_NAME)
        val selection = "$COLUMN_USER_EMAIL = ?"
        val selectionArgs = arrayOf(email)
        val cursor = db.query(TABLE_USER, columns, selection, selectionArgs, null, null, null)
        if (cursor.moveToFirst()) {
            name = cursor.getString(cursor.getColumnIndex(COLUMN_USER_NAME))
        }
        cursor.close()
        return name
    }

    // method to create records
    fun addUser(user: User) {
        val db: SQLiteDatabase = writableDatabase
        val values = ContentValues()
        values.put(COLUMN_USER_NAME, user.getName())
        values.put(COLUMN_USER_EMAIL, user.getEmail())
        values.put(COLUMN_USER_PASSWORD, user.getPassword())

        // inserting rows in a table
        db.insert(TABLE_USER, null, values)
        db.close()
    }

    // method to check if a user exists
    fun checkUser(email: String): Boolean {
        val col = arrayOf(COLUMN_USER_ID)
        val db: SQLiteDatabase = readableDatabase
        val selection = "$COLUMN_USER_EMAIL = ?"
        val args = arrayOf(email)
        val cursor = db.query(TABLE_USER, col, selection, args, null, null, null)
        val cursorcount = cursor.count
        cursor.close()
        return cursorcount > 0
    }

    fun checkUser(mail: String, pass: String): Boolean {
        val col = arrayOf(COLUMN_USER_ID)
        val db: SQLiteDatabase = readableDatabase
        val selection = "$COLUMN_USER_EMAIL = ? AND $COLUMN_USER_PASSWORD = ?"
        val args = arrayOf(mail, pass)
        val cursor = db.query(TABLE_USER, col, selection, args, null, null, null)
        val cursorcount = cursor.count
        cursor.close()
        return cursorcount > 0
    }
}

